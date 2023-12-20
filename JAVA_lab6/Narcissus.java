package JAVA_lab6;

import java.util.Random;

public class Narcissus implements Flower{
    private Double price = 40.0;
    private boolean freshness;
    private int length;


    public Narcissus() {
        Random random = new Random();
        freshness = random.nextBoolean();
        length = random.nextInt(50);
    }

    @Override
    public void buyFlower(Bouquet bouquet) {
        bouquet.totalPrice += price;
    }
    @Override
    public boolean isFreshness() {
        return freshness;
    }
    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Narcissus{" +
                "price=" + price +
                ", freshness=" + freshness +
                ", length=" + length +
                '}';
    }
}
