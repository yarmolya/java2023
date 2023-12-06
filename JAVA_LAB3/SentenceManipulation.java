import java.util.ArrayList;
import java.util.List;

public class SentenceManipulation {
    public static void main(String[] args) {
        String inputText = "Це перше речення. А ось друге речення, чи не правда? Тут третє речення.";

        try {
            String result = manipulateSentences(inputText);
            System.out.println("Вихідний текст:\n" + inputText);
            System.out.println("Результат:\n" + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static String manipulateSentences(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("Вхідний текст не може бути порожнім або null.");
        }

        List<String> manipulatedSentences = new ArrayList<>();
        List<Character> sentenceEndings = new ArrayList<>();

        int start = 0;
        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);

            if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                sentenceEndings.add(currentChar);
                String currentSentence = inputText.substring(start, i + 1).trim();
                manipulatedSentences.add(currentSentence);
                start = i + 1; // Move the start index to the next character after punctuation
            }
        }

        // Handle the case where the last sentence doesn't end with punctuation
        if (start < inputText.length()) {
            manipulatedSentences.add(inputText.substring(start).trim());
        }

        // Manipulate sentences and append punctuation
        List<String> resultSentences = new ArrayList<>();
        for (int i = 0; i < manipulatedSentences.size(); i++) {
            String sentence = manipulatedSentences.get(i);
            if (!sentence.isEmpty()) {
                String[] words = sentence.split(" ");
                if (words.length >= 2) {
                    String firstWord = words[0].substring(0).toLowerCase();
                    String lastWord = words[words.length - 1].substring(0, 1).toUpperCase() + words[words.length - 1].substring(1);
                    words[0] = lastWord.substring(0, lastWord.length()-1);
                    words[words.length - 1] = firstWord;
                    String manipulatedSentence = String.join(" ", words);
                    manipulatedSentence += sentenceEndings.get(i);
                    resultSentences.add(manipulatedSentence);
                }
            } else {
                resultSentences.add(sentence);
            }
        }

        return String.join(" ", resultSentences.toArray(new String[0]));
    }
}
