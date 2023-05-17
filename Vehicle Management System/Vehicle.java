import java.io.Serializable;

public abstract class Vehicle implements Vehicable, Serializable {
    private String manufacturer;
    private double price;
    
    public Vehicle() {
        
    }
    
    public Vehicle(String manufacturer, double price) {
        this.manufacturer = manufacturer;
        this.price = price;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public double getPrice() { 
        return price;
    }
    
    
    public abstract double calcRange();
    
    public abstract double calcKilometerCost(double unitPrice);

    public abstract double calcIncentive();
    
    public abstract double calcFine();
}
