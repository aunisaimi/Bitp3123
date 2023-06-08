package exercise5;

import java.io.FileInputStream;
import java.io.DataInputStream;

/*
 * This program is to read the data that generated for 6 days for Rainfall 
 * 
 */

public class RainfallDataReader 
{

	public static void main (String [] args)
	{
		//1. Write output file
		String sourceFile = "RainFall.txt";
		
		//2. Display sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");
		
		
		try
		{
			//3. create stream to read data
			DataInputStream disInput = new DataInputStream (new FileInputStream(sourceFile));
			
			
			//4. Read values from the stream. variables to handle data read from source file
			// receive daily rainfall reading
			
			double dailyRainfall=0;
			
			//variables to count number of daily reading in the siurce file
			int noRecord=0;
			
			//variable to calcilate total daily rainfall
			double totalRainfall=0.0;
			
			//read valueRainfalls from stream
			dailyRainfall = disInput.read();
			
			System.out.println("The 6 das readings of daily rainfall from station Simpang Ampat: ");
			
			// read until end of file/stream
			while (dailyRainfall !=-1)
			{
				
				//Display each daily rainfall reading
				System.out.println(dailyRainfall);
				
				//Calculating daily rainfall reading
				totalRainfall= totalRainfall+dailyRainfall;
				
				//auto update current number of records read
				noRecord++;
				
				//read next value for daily rainfall reading
				dailyRainfall = disInput.read();
			}
			
			//Display total num of records of daily reading
			System.out.println("\nTotal Records: " + noRecord);
			
			//Display total daily rainfall
			System.out.println("\nTotal RainFall: " + totalRainfall);
			
			
			//Calcilate average daily rainfall
			double averageRainFall = totalRainfall / Double.valueOf(noRecord);
			
			String formattedAverage = String.format("%.1f", averageRainFall);
			System.out.println("\nAverage RainFall for " + noRecord + "days from station Simpang Ampat: " + formattedAverage);
			
			//4. Close stream.
			disInput.close();
			
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		//end of program
		System.out.println("\nEnd of program! Check the RainFall.txt");
	}
	
	
}
