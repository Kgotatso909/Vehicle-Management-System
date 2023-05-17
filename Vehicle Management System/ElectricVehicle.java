
/**
 * Write a description of class BEV here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ElectricVehicle extends Vehicle {
    private double batterySize;
    private double eConsumption;
    
    public ElectricVehicle() {
        
    }

    public ElectricVehicle(String manufacturer, double price, double batterySize, double eConsumption) {
        super(manufacturer, price);
        this.batterySize = batterySize;
        this.eConsumption = eConsumption;
    }

    public double getBattery() {
        return batterySize;   
    }

    public double getConsumption() {
        return eConsumption;   
    }
    
    @Override
    public double calcRange(){
        return batterySize/eConsumption;
    }
    
    @Override
    public  double calcKilometerCost(double unitPrice){
        return (unitPrice*batterySize)/calcRange();
    }
    
    @Override
    public double calcIncentive(){
        
        if((getPrice() > 0 && getPrice() < 650_000) && batterySize == 70){
            return getPrice()*0.12; // 12% incentive rate
        } else if(getPrice() >= 650_000 && batterySize == 70){
            return getPrice()*0.09; // 9% incentive rate
        }
        return getPrice()*0.16;
    }
    
    @Override
    public double calcFine(){
        throw new UnsupportedOperationException("Electric vehicle do not have fine");
    }
    
    public String toString() {
        String str = String.format("%-15sR %-15.2f%-10.2f %-15.3f", getManufacturer(), getPrice(), batterySize, eConsumption);   
        return str;
    }
}
