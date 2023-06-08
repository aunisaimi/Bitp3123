package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainfallByteBasedGenerator 
{
	public static void main (String [] args)
	{
		//1. Declare output file
		String outFile = "RainFallByteBased.txt";
		
		//Declaring the data
		//i. Station id
		int id[] = {2421003,2322006,2321006,2222002,2424031,2324032};
		
		//ii. district
		String district[] = {"Alor Gajah","Alor Gajah","Alor Gajah","Alor Gajah","Jasin","Jasin"};
		
		//iii. station
		String station[] = {"Simpang Ampat","Melaka Pindah","Ladang Lendu","Durian Tunggal","Durian Tunggal D/S","Datoh Kramat di Nyalas Melaka"}; 
		
		//first reading on 02/06/2023
		double reading1[] = {0.0,0.0,0.0,0.0,0.0,0.0};
		
		//second reading on 03/06/2023
		double reading2[] = {4.0,0.0,2.0,0.0,0.0,0.0};
		
		//third reading on 04/06/2023
		double reading3[] = {1.0,0.0,0.0,0.0,0.0,0.0};
		
		//fourth reading on 05/06/2023
		double reading4[] = {0.0,0.0,0.0,0.0,0.0,0.0};
		
		//fifth reading on 06/06/2023
		double reading5[] = {6.0,2.0,3.0,37.0,46.0,0.0};
		
		//sixth reading on 07/06/2023
		double reading6[] = {19.0,18.5,4.0,6.0,7.0,17.0};
		
		try
		{
			//2. Create an output stream between this program and the output 
			DataOutputStream dosOut = new DataOutputStream(new FileOutputStream(outFile));
			
			//3. Write the 6 days reading of daily rainfall
			dosOut.write(5);
			dosOut.write(0);
			dosOut.write(0);
			dosOut.write(4);
			dosOut.write(1);
			dosOut.write(0);
			
			//4. clear stream
			dosOut.flush();
			
			//5. close stream
			dosOut.close();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//end of program
		System.out.println("End of program! Check the " + outFile);
		
		
		
		
		
	}
	
}
