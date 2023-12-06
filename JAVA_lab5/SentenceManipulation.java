import java.util.ArrayList;
import java.util.List;

class Letter {
    private char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

class Word {
    private List<Letter> letters;

    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        return letters.stream().map(Letter::toString).reduce("", String::concat);
    }
}

class Sentence {
    private List<Object> elements;

    public Sentence(List<Object> elements) {
        this.elements = elements;
    }

    public List<Object> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        if (elements.size() >= 2) {
            List<Object> modifiedElements = new ArrayList<>(elements);
            Object firstElement = modifiedElements.get(0);
            Object lastElement = modifiedElements.get(modifiedElements.size() - 2);

            modifiedElements.set(0, lastElement);
            modifiedElements.set(modifiedElements.size() - 2, firstElement);

            boolean firstWord = true;

            StringBuilder sentenceBuilder = new StringBuilder();

            for (Object element : modifiedElements) {
                if (element instanceof Punctuation) {
                    sentenceBuilder.append(element);
                } else if (element instanceof Word) {
                    Word word = (Word) element;
                    String wordString = word.toString();
                    if (firstWord) {
                        wordString = wordString.substring(0, wordString.length() - 1);
                        wordString = Character.toUpperCase(wordString.charAt(0)) + wordString.substring(1);
                    } else {
                        wordString = wordString.toLowerCase();
                    }
                    if (!firstWord) {
                        sentenceBuilder.append(" ");
                    }
                    sentenceBuilder.append(wordString);
                    firstWord = false;
                }
            }
            return sentenceBuilder.toString();
        } else {
            return elements.stream().map(Object::toString).reduce("", (s1, s2) -> s1 + " " + s2).trim();
        }
    }
}

class Punctuation {
    private char value;

    public Punctuation(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

class Text {
    private List<Sentence> sentences;

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return sentences.stream().map(Sentence::toString).reduce("", (s1, s2) -> s1 + " " + s2).trim();
    }
}

public class SentenceManipulation {
    public static void main(String[] args) {
        String inputText = "Це перше речення. А ось друге речення, чи не правда? Тут третє речення.";

        try {
            Text result = manipulateSentences(inputText);
            System.out.println("Вихідний текст:\n" + inputText);
            System.out.println("Результат:\n" + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static Text manipulateSentences(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("Вхідний текст не може бути порожнім або null.");
        }

        List<Sentence> sentences = new ArrayList<>();
        List<Object> currentElements = new ArrayList<>();
        List<Letter> currentWordLetters = new ArrayList<>();
        boolean inWord = false;

        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                currentChar = ' ';
                if (!currentWordLetters.isEmpty()) {
                    currentElements.add(new Word(new ArrayList<>(currentWordLetters)));
                    currentWordLetters.clear();
                    inWord = false;
                }
            } else {
                currentWordLetters.add(new Letter(currentChar));
                inWord = true;
            }

            if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                if (inWord) {
                    currentElements.add(new Word(new ArrayList<>(currentWordLetters)));
                    currentWordLetters.clear();
                    inWord = false;
                }
                currentElements.add(new Punctuation(currentChar));
                sentences.add(new Sentence(new ArrayList<>(currentElements)));
                currentElements.clear();
            }
        }

        return new Text(sentences);
    }
}
