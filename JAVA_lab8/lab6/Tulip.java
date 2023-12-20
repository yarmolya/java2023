package JAVA_lab8.lab6;

import java.util.Random;

public class Tulip implements Flower {
    private final Double price = 50.0;
    private final boolean freshness;
    private final int length;

    public Tulip() {
        Random random = new Random();
        freshness = random.nextBoolean();
        length = random.nextInt(50);
    }

    @Override
    public void buyFlower(BouquetService bouquetService) throws RuntimeException {
        bouquetService.totalPrice += price;
    }

    @Override
    public boolean isFreshness() {
        return freshness;
    }

    @Override
    public int getLength() {
        return length;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Tulip{" +
                "price=" + price +
                ", freshness=" + freshness +
                ", length=" + length +
                '}';
    }
}
