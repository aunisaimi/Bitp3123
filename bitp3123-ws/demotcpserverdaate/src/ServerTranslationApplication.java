import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTranslationApplication 
{
	public static void main(String[] args) throws IOException{
		
			ServerSocket serverSocket = null;
			
			try 
			{
				// Binding ServerSocket to a port
				int portNo = 4228;
				serverSocket = new ServerSocket(portNo);
				
				String text1 = "Good Morning";
				System.out.println("Waiting for the request");
				
				while(true)
				{
					//Accept the client request for connection
					Socket clientSocket = serverSocket.accept();
					
					//Create stream to write data on network
					DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
					
					//Send the current date back to client
					outputStream.writeUTF(text1);
					
					// close the socket
					clientSocket.close();
					
				} // close is not necessary cuz code is unreachable
			}
			catch (IOException ioe)
			{
				if(serverSocket != null)
					serverSocket.close();
				
				ioe.printStackTrace();
			}
	}
}
