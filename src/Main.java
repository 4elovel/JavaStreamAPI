import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class Main {


    public static void main(String[] args) {
        //Task 1
        Random rand = new Random();
        List<Integer> numbers = new Random().ints(100,
                        -1000, 1000)
                .boxed().toList();
        long positive = numbers.stream().filter(x -> x > 0).count();
        long negative = numbers.stream().filter(x -> x < 0).count();
        long twoDigits = numbers.stream().filter(x -> Math.abs(x) > 9 && Math.abs(x) < 100).count();
        long mirror = numbers.stream().filter(Main::isMirrored).count();
        System.out.println(positive + " " + negative + " " + twoDigits + " " + mirror);
        //Task 2
        List<String> products = Arrays.asList("Milk", "Bread", "Cheese", "Butter", "Milk", "Yogurt",
                "Cream", "Milk");

        String productName = "Milk";
        String startingLetter = "B";

        System.out.println("All products:");
        products.forEach(System.out::println);

        System.out.println("Products with name less than five characters:");
        products.stream().filter(p -> p.length() < 5).forEach(System.out::println);

        long count = products.stream().filter(p -> p.equalsIgnoreCase(productName)).count();
        System.out.println("Count of product " + productName + ": " + count);

        System.out.println("Products starting with " + startingLetter + ":");
        products.stream().filter(p -> p.startsWith(startingLetter)).forEach(System.out::println);

        System.out.println("Products from category 'milk':");
        products.stream().filter(p -> p.equalsIgnoreCase("Milk")).forEach(System.out::println);
        //Task 3
        List<Device> devices = Arrays.asList(
                new Device("Phone", 2020, 699.99, "Black", "Mobile"),
                new Device("Laptop", 2021, 999.99, "Silver", "Computer"),
                new Device("Tablet", 2019, 399.99, "White", "Mobile"),
                new Device("Monitor", 2022, 199.99, "Black", "Computer")
        );
        System.out.println("All devices:");
        devices.forEach(System.out::println);
        String specificColor = "Black";
        System.out.println("Devices of color " + specificColor + ":");
        devices.stream().filter(d -> Objects.equals(d.getColor(), specificColor))
                .forEach(System.out::println);
        int specificYear = 2021;
        System.out.println("Devices of year " + specificYear + ":");
        devices.stream().filter(d -> d.getYear() == specificYear).forEach(System.out::println);

        double specificPrice = 500.00;
        System.out.println("Devices more expensive than " + specificPrice + ":");
        devices.stream().filter(d -> d.getPrice() > specificPrice).forEach(System.out::println);

        String specificType = "Mobile";
        System.out.println("Devices of type " + specificType + ":");
        devices.stream().filter(d -> d.getType().equals(specificType)).forEach(System.out::println);

        int startYear = 2020;
        int endYear = 2022;
        System.out.println("Devices from year range " + startYear + " to " + endYear + ":");
        devices.stream().filter(d -> d.getYear() >= startYear && d.getYear() <= endYear)
                .forEach(System.out::println);
        //Task 4
        List<Projector> projectors = Arrays.asList(
                new Projector("ProjectorA", 2020, 500.00, "BrandX"),
                new Projector("ProjectorB", 2021, 600.00, "BrandY"),
                new Projector("ProjectorC", 2022, 700.00, "BrandX"),
                new Projector("ProjectorD", 2023, 800.00, "BrandZ")
        );
        System.out.println("All projectors:");
        projectors.forEach(System.out::println);

        String specificManufacturer = "BrandX";
        System.out.println("Projectors of manufacturer " + specificManufacturer + ":");
        projectors.stream().filter(p -> p.getManufacturer().equals(specificManufacturer))
                .forEach(System.out::println);

        int currentYear = LocalDateTime.now().getYear();
        System.out.println("Projectors of current year " + currentYear + ":");
        projectors.stream().filter(p -> p.getYear() == currentYear).forEach(System.out::println);

        double price = 650.00;
        System.out.println("Projectors more expensive than " + price + ":");
        projectors.stream().filter(p -> p.getPrice() > price).forEach(System.out::println);

        System.out.println("Projectors sorted by price ascending:");
        projectors.stream().sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);

        System.out.println("Projectors sorted by price descending:");
        projectors.stream().sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println("Projectors sorted by year ascending:");
        projectors.stream().sorted(Comparator.comparingInt(Projector::getYear))
                .forEach(System.out::println);

        System.out.println("Projectors sorted by year descending:");
        projectors.stream().sorted(Comparator.comparingInt(Projector::getYear).reversed())
                .forEach(System.out::println);
    }


    private static boolean isMirrored(int num) {
        String strNum = Integer.toString(num);
        return strNum.contentEquals(new StringBuilder(strNum).reverse().toString());
    }
}
