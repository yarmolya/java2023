package JAVA_lab8.lab6;

public interface Flower {
    void buyFlower(BouquetService bouquetService) throws RuntimeException;
    boolean isFreshness();
    int getLength();
}
