package exercise6;

import java.util.ArrayList;
import java.util.HashSet;

import java.io.FileNotFoundException;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class RainfallByteBasedRead 
{

	public static void main (String [] args)
	{
		
		//1. declare the input or source file
		String sourceFile = "RainFallByteBased.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		
		try
		{
			//2. creat input stream for data readings
			DataInputStream disIn = new DataInputStream(new FileInputStream(sourceFile));
			
			//variables for byte based data
			
			//i. station id:
			int id = 0;
			
			// ii. station name
			String station = "";
			
			// iii. District name
			String district = "";
			
			// Daily rainfall readings from 2/6 to 7/6
			double reading1 = 0.0, reading2 = 0.0, reading3 = 0.0;
			double reading4 = 0.0, reading5 = 0.0, reading6 = 0.0;
			
			//variable declaration to calculate below:
			
			// total number of records read from the source file
			int numRecords = 0;
			
			// total daily rainfall readings for each station name
			double sum = 0.0;
			
			// declaraation for ArrayList to store each total daily list of rainfall readings
			ArrayList<Double> totalRainfall = new ArrayList<Double>();
			
			//Declaration for Arraylist to store each station for calculation purpose
			ArrayList<String> stations = new ArrayList<String>();
			
			// HashSet to store the distinct district for calculation purpose
			HashSet<String> districtCount = new HashSet<String>();
			
			//3. Process the data until the end of the file
			
			while(disIn.available()>0) 
			{
				//read data here
				
				// i. station id
				id = disIn.readInt();
				
				// ii. station name
				station = disIn.readUTF();
				
				// iii. district 
				district = disIn.readUTF();
				
				// iv. daily rainfall reading for 2/6/2023
				reading1 = disIn.readDouble();
				
				// v. daily rainfall reading for 3/6/2023
				reading2 = disIn.readDouble();
				
				// iv. daily rainfall reading for 4/6/2023
				reading3 = disIn.readDouble();
				
				// vi. daily rainfall reading for 5/6/2023
				reading4 = disIn.readDouble();
				
				// vii. daily rainfall reading for 6/6/2023
				reading5 = disIn.readDouble();
				
				// viii. daily rainfall reading for 7/6/2023
				reading6 = disIn.readDouble();
				
				System.out.println(id + "\t" + station + "\t" + district + "\t" + 
								   reading1 + "\t" + reading2 + "\t" + reading3 + 
								   "\t" + reading4 + "\t" + reading5 + "\t" + reading6);
				
				
				//calculate total daily rainfall for each station
				sum = reading1 + reading2 + reading3 + reading4 + reading5 + reading6;
				
				// save the sum into arraylist for totalRainfall
				totalRainfall.add(sum);
				
				//sace the station name into arraylist, stations
				stations.add(station);
				
				//save the district into hashset, district
				districtCount.add(district);
				
				// auto aupdate for current record
				numRecords++;
				
			}
			System.out.println("\n");
			

			// calculate average daily rainfall readings in each station 
			for(int index = 0; index < stations.size(); index++)
			{
				//calculation for average daily rainfall reading in each stations
				
				double average = totalRainfall.get(index) / numRecords;
				
				//format the average in one decimal 
				String formattedAverage = String.format("%.1f", average);
				
				// display total daily rainfall reading in each station 
				System.out.println("The total daily rainfall readings in " + stations.get(index) + ":" 
								   + totalRainfall.get(index));
				System.out.println("The average daily rainfall readings in " + stations.get(index) + ":"
						           + formattedAverage + "\n");
				
				
			}
			
			System.out.println("There are " + stations.size() + "stations and " + districtCount.size() + " district in Melaka.. " );
			
			
			//close the stream
			disIn.close();
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//output
		System.out.println("End of the program..");
		}
		
	
}
