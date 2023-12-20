package JAVA_lab8.lab6;

import java.util.ArrayList;
import java.util.List;

public class BouquetService {
    List<Flower> flowerList;
    Double totalPrice;

    public BouquetService() {
        flowerList = new ArrayList<>();
        totalPrice = 0.0;
    }


    public void add(List<Flower> flowers) throws RuntimeException {
        flowerList.addAll(flowers);
        for (Flower flower : flowers) {
            flower.buyFlower(this);
        }
    }



    public void add(Flower flower) throws RuntimeException {
        flowerList.add(flower);
        flower.buyFlower(this);
    }



    public void findByLength(int first, int last) {
        flowerList.stream()
                .filter(a -> a.getLength() > first && a.getLength() < last)
                .forEach(System.out::println);
    }
}
