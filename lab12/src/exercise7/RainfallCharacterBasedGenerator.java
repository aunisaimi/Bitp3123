package exercise7;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class RainfallCharacterBasedGenerator {
	
	public static void main(String [] args)
	{
		//1. Identify destination and declare the the output file
		String outFile = "RainfallCharacter.txt";
		
		try
		{
			//2. Construct BufferedWriter object along with FileWriter
			FileWriter files = new FileWriter(outFile);
			BufferedWriter bwOutput = new BufferedWriter(files);
			
			int[] arrays = {5,0,0,4,1,0};
			
			// 3. fill in data
			
			for (int index = 0; index <arrays.length; index++) {
				bwOutput.write(String.valueOf(arrays[index]));
				bwOutput.newLine();
			}
			
			//4. Clear the stream
			bwOutput.flush();
			
			// 5. close the stream
			bwOutput.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// end the program
		System.out.println("End of the program. Check out the " + outFile);
		
	}

}
