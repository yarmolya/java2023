import java.util.Arrays;
import java.util.Comparator;

// Клас літак
class Airplane {
    private String model;
    private int year;
    private double price;
    private int passengerCapacity;
    private boolean isAvailable;

    // Конструктор класу
    public Airplane(String model, int year, double price, int passengerCapacity, boolean isAvailable) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.passengerCapacity = passengerCapacity;
        this.isAvailable = isAvailable;
    }

    // Геттери та сеттери для полів класу
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

// Головний клас
public class Lab4 {
    public static void main(String[] args) {
        // Створення масиву з об’єктів класу літак
        Airplane[] airplanes = {
                new Airplane("Boeing 747", 2000, 150000000.0, 416, true),
                new Airplane("Airbus A320", 2015, 80000000.0, 150, true),
                new Airplane("Cessna 172", 1980, 300000.0, 4, true),
                new Airplane("Embraer E190", 2012, 60000000.0, 114, true),
                new Airplane("Bombardier Challenger 300", 2018, 25000000.0, 9, true)
        };

        // Сортування масиву за роком випуску (зростанням)
        Arrays.sort(airplanes, Comparator.comparingInt(Airplane::getYear));

        System.out.println("Сортування за роком випуску (зростанням):");
        printAirplanes(airplanes);

        // Сортування масиву за ціною (спаданням)
        Arrays.sort(airplanes, Comparator.comparingDouble(Airplane::getPrice).reversed());

        System.out.println("\nСортування за ціною (спаданням):");
        printAirplanes(airplanes);
    }

    // Допоміжний метод для виведення інформації про літаки
    private static void printAirplanes(Airplane[] airplanes) {
        for (Airplane airplane : airplanes) {
            System.out.println("Модель: " + airplane.getModel() +
                    ", Рік випуску: " + airplane.getYear() +
                    ", Ціна: " + airplane.getPrice() +
                    ", Пасажирська місткість: " + airplane.getPassengerCapacity() +
                    ", Доступність: " + (airplane.isAvailable() ? "Доступний" : "Не доступний"));
        }
    }
}
