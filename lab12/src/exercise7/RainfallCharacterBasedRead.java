package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RainfallCharacterBasedRead 
{


	public static void main (String [] args)
	{
		//1. declare output file
		String sourceFile = "RainfallCharacter.txt";
		
		// display the sentence the sentence of data readings
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try
		{
			//2. build the reader object
			BufferedReader brInput = new BufferedReader(new FileReader(sourceFile));
			
			//3. read values from stream where variables will handle data readings from source fole
			
			//receive daily rainfall data reading
			String dailyRainfall = "";
			
			int numRecords = 0;
			
			double totalRainfall = 0.0;
			
			
			//3. Read data
			dailyRainfall = brInput.readLine();
			while(dailyRainfall != null) {
				
				//display each of daily readings
				System.out.println(dailyRainfall);
				
				//calculate daily readings
				totalRainfall = totalRainfall + Double.parseDouble(dailyRainfall);
				
				//auto update current number of records read from source file
				numRecords++;
				
				//read next value for daily readings
				dailyRainfall = brInput.readLine();
				
			}
			
			//DIsplay total number records for daily readings
			System.out.println("\nTotal readings: " + numRecords);
			
			// Display total daily rainfall
			System.out.println("\nTotal daily rainfall: " + totalRainfall);
			
			//Calculate average daily rainfall
			double averageRainfall = totalRainfall/ Double.valueOf(numRecords);
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.println("\nAverage Rainfall for " + numRecords + "Days from station Simpang AMpat in Alor Gajah district"
					           + formattedAverage);
			
			
			//4. close the reader
			brInput.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
