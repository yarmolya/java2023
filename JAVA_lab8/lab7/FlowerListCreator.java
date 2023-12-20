package JAVA_lab8.lab7;

import java.util.Arrays;

public class FlowerListCreator {
    public static void main(String[] args) {
        try {
            // Create a FlowerList
            FlowerList<String> flowerList = new FlowerList<>();

            // Add some flowers to the list
            flowerList.addAll(Arrays.asList("Rose", "Tulip", "Daisy"));

            // Print the flower list
            System.out.println("Flower List: " + flowerList);

            // Demonstrate other list operations
            System.out.println("Size: " + flowerList.size());
            System.out.println("Contains 'Tulip': " + flowerList.contains("Tulip"));
            System.out.println("Get element at index 1: " + flowerList.get(1));

            // Modify the list
            flowerList.add("Sunflower");
            System.out.println("After adding 'Sunflower': " + flowerList);

            flowerList.remove("Rose");
            System.out.println("After removing 'Rose': " + flowerList);

            // Clear the list
            flowerList.clear();
            System.out.println("After clearing the list: " + flowerList);

            // Simulate a situation that can throw FlowerException
            throw new FlowerException("Simulated FlowerException");
        } catch (FlowerException e) {
            // Handle FlowerException
            e.printStackTrace();
        }
    }
}
