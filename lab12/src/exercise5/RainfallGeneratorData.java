package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* this program displays the generated data for 6 days
 * reading of daily rainfall from Simpang Ampat in Alor Gajah District.
 * 
 * @author Auni Afeeqah (B032110274)
 * 
 * 
 */

public class RainfallGeneratorData 
{

	public static void main (String [] args) 
	{
	
		//Declare output file
		String outFile = "RainFall.txt";
		
		try
		{
			//2. Create an output stream between this program and the output 
			DataOutputStream dosOutput = new DataOutputStream(new FileOutputStream(outFile));
			
			//3. Write the 6 days reading of daily rainfall
			dosOutput.write(5);
			dosOutput.write(0);
			dosOutput.write(0);
			dosOutput.write(4);
			dosOutput.write(1);
			dosOutput.write(0);
			
			//4. clear stream
			dosOutput.flush();
			
			//5. close the stream
			dosOutput.close();
		
	}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//end of program.
		
		System.out.println("End of program. Check out " + outFile);
	
}
}
