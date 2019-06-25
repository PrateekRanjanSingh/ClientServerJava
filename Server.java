import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Server
{
   public static void main(String args[]) throws Exception
   {
     ServerSocket sersock = new ServerSocket(5000); 
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
      OutputStream ostream = sock.getOutputStream();                 
        DataOutputStream dos = new DataOutputStream(ostream);
        dos.writeBytes("Hello Client Bhaisaab!!");
        dos.close();                            
        ostream.close();   
     }                                                                                           
     //dstream .close(); istream.close(); sock.close(); sersock.close();
  }
}