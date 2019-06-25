import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataInputStream;

public class Server
{
   public static void main(String args[]) throws Exception
   {
     ServerSocket sersock = new ServerSocket(5000); 
     System.out.println("server is ready");  //  message to know the server is running

     Socket sock = sersock.accept();               
                                                                                          
     InputStream istream = sock.getInputStream();  
     BufferedReader dstream = new BufferedReader(new InputStreamReader(istream));

     String message2 = dstream.readLine();
     System.out.println(message2);
     dstream .close(); istream.close(); sock.close(); sersock.close();
  }
}