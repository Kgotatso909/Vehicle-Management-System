
/**
 * Write a description of class File here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//=========================
//DO NOT CHANGE GIVEN CODE
//=========================
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class File
{
    Vehicable [] arrVehicle = new Vehicable[10];
    int count = 0;

    public void readFromFile() throws IOException
    {
        Scanner file = new Scanner(new FileReader("vehicles.txt"));

        while(file.hasNext())
        {
            String line = file.nextLine();
            String [] data = line.split(",");
            char type = data[0].charAt(0);
            String manuf = data[1];
            double price = Double.parseDouble(data[2]);

            if(type == 'I')
            {
                int fuelTank = Integer.parseInt(data[3]);
                double consumption = Double.parseDouble(data[4]);
                int emissions = Integer.parseInt(data[5]);

                arrVehicle[count] = new CombustionVehicle(manuf,price,fuelTank,consumption,emissions);
            }
            else if(type == 'E')
            {
                double batterySize = Double.parseDouble(data[3]);
                double eConsumption = Double.parseDouble(data[4]);

                arrVehicle[count] = new ElectricVehicle(manuf,price,batterySize,eConsumption);
            }
            count++;
        }
        file.close();
    }
    
    

    public Vehicable[] getArray()
    {
      return arrVehicle;   
    }

    public int getCount()
    {
     return count;   
    }
    
    public static void writeToBinFile(Vehicable[] arrVehicle, int count){
        
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("a.ser"))){
            for(int i=0; i<count; i++){
                os.writeObject(arrVehicle);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void readFromBinFile(int count){
        boolean endOfFile = false;
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("a.ser"))){
            
            while(!(endOfFile)){
                try {
                Vehicable vehicable = (Vehicable) os.readObject();
                if (vehicable instanceof ElectricVehicle) {
                    ElectricVehicle electricVehicle = (ElectricVehicle) vehicable;
                } else if (vehicable instanceof CombustionVehicle) {
                    CombustionVehicle combustionVehicle = (CombustionVehicle) vehicable;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                endOfFile = true; 
            }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //=========================
    //DO NOT CHANGE GIVEN CODE
    //=========================
}
