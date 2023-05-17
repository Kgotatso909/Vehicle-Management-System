
/**
 * Write a description of class testVehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//=========================
//DO NOT CHANGE GIVEN CODE
//=========================
public class testVehicle
{
    public static void main(String[] args) throws Exception
    {
        Vehicable[] arrVehicle = new Vehicable[10];
        int count = 0;
        
        File file = new File();
        file.readFromFile();
        
        arrVehicle = file.getArray();
        count = file.getCount();
        
        displayVehicles(arrVehicle, count);
        
        file.writeToBinFile(arrVehicle, count);
        file.readFromBinFile(count);
     }
    
     public static void displayVehicles(Vehicable[] arrV, int count)
     {
         System.out.println("List of battery electric vehicles");
         System.out.printf("%-15s%-17s%-11s%-15s%-12s%-10s\n", "Manufacturer", "Price", "Battery", "kWh per km", "Range", "Cost per KM");
        
         for(int k = 0; k < count; k++)
        {
             if(arrV[k] instanceof ElectricVehicle)
             {
                 System.out.printf("%s%-12.2fR %-10.2f\n", arrV[k].toString(), arrV[k].calcRange(), arrV[k].calcKilometerCost(2.33));   
             }
         }
        
         System.out.println("\nList of internal combustion engine vehicles");
         System.out.printf("%-15s%-18s%-11s%-15s%-17s%-14s%-10s\n", "Manufacturer", "Price", "Tank", "KM per liter", "Emissions(g/km)", "Range", "Cost per KM");
        
         for(int k = 0; k < count; k++)
         {
            if(arrV[k] instanceof CombustionVehicle)
             {
                 System.out.printf("%s%-14.2fR %-10.2f\n", arrV[k].toString(), arrV[k].calcRange(), arrV[k].calcKilometerCost(24.45));   
             }
         }
     }
}
