package JAVA_lab8.lab6;

import java.util.ArrayList;
import java.util.List;

public class Bouquet { //exception handler
    private final BouquetService bouquetService = new BouquetService();

    public void add(List<Flower> flowers) throws RuntimeException {
        try {
            bouquetService.add(flowers);
        }catch (NullPointerException nullPointerException){
            System.out.println("List of flowers can`t be empty");
        }
    }
    public void add(Flower flower) throws RuntimeException {
        try {
            bouquetService.add(flower);
        }catch (NullPointerException nullPointerException){
            System.out.println("Flower can`t be null");
        }
    }


    public void sortByFreshness() {
        bouquetService.flowerList.forEach(System.out::println);
        System.out.println("--------------------------------------");

        bouquetService.flowerList.stream()
                .sorted((b1, b2) -> Boolean.compare(b2.isFreshness(), b1.isFreshness()))
                .forEach(System.out::println);

        System.out.println("--------------------------------------");
    }

    public void findByLength(int first, int last) {
        if(first > last){
            System.out.println("Incorrect parameters");
        }
        if(last < 0){
            System.out.println("Range can`t be less than zero");
        }
        bouquetService.findByLength(first, last);
    }

    public BouquetService getBouquetService() {
        return bouquetService;
    }

    public void getTotalPrice() {
        System.out.println(bouquetService.totalPrice);
    }
}
