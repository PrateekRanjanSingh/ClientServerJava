import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataInputStream;

public class Server2
{
   public static void main(String args[]) throws Exception
   {
     ServerSocket sersock = new ServerSocket(5001); 
     System.out.println("server is ready");  //  message to know the server is running
     while(true)
     {
      Socket sock = sersock.accept();
      InputStream istream = sock.getInputStream();  
      BufferedReader dstream = new BufferedReader(new InputStreamReader(istream));
      String message2 = dstream.readLine();
      String ar[] = message2.split(",");
      for(int i = 0;i<60;i++)
      {
        System.out.println(ar[i]);
      }
      System.out.println(ar);
     }                                                                                           
     //dstream .close(); istream.close(); sock.close(); sersock.close();
  }
}