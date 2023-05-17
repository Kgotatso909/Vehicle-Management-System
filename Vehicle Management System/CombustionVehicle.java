
/**
 * Write a description of class ICE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CombustionVehicle extends Vehicle
{
    private int fuelTank;
    private double fConsumption;
    private int emissions;
    
    public CombustionVehicle()
    {
        
    }

    public CombustionVehicle(String manufacturer, double price, int fuelTank, double fConsumption, int emissions)
    {
        super(manufacturer, price);
        this.fuelTank = fuelTank;
        this.fConsumption = fConsumption;
        this.emissions = emissions;
    }

    public int getFuelTank()
    {
        return fuelTank;   
    }

    public double getConsumption()
    {
        return fConsumption;   
    }

    public int getEmissions()
    {
        return emissions;   
    }
    
     @Override
    public  double calcRange(){
        return fuelTank*fConsumption;
    }
    
    @Override
    public  double calcKilometerCost(double unitPrice){
        return (unitPrice*fuelTank)/calcRange();
    }
    
    @Override
    public  double calcIncentive(){
        throw new UnsupportedOperationException("Combustion Vehicle do not have Incentive");
    }
    
    @Override
    public  double calcFine(){
        if(emissions < 95){
            return 0.0;
        } else if(emissions >= 95 && emissions <=99){
            return 2500.0;
        } else if(emissions >= 100 && emissions <= 114){
            return 8500.0;
        } else {
            return 15000.0;
        }
    }
    
    public String toString()
    {
        String str = String.format("%-15sR %-15.2f%-10d %-14.2f %-17d", getManufacturer(), getPrice(), fuelTank, fConsumption, emissions);  
        return str;
    }
}
