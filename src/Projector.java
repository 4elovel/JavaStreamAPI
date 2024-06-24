public class Projector {

    private final String name;
    private final int year;
    private final double price;
    private final String manufacturer;

    public Projector(String name, int year, double price, String manufacturer) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Projector{name='" + name + "', year=" + year + ", price=" + price
                + ", manufacturer='" + manufacturer + "'}";
    }
}
