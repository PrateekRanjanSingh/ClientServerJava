import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Client {
  public static void main(String args[]) throws Exception {
    Random rand = new Random();
    int ar[] = new int[240];
    for (int i = 0; i < 240; i++) {
      int n = rand.nextInt(3);
      n++;
      ar[i] = n;
    }
    Thread t1 = new Thread(() -> {
      try {
        Socket sock = new Socket("127.0.0.1", 5000);
        String message1 = "Accept Best Wishes, Serverji";
        String s1 = " ";
        for(int i = 0;i<120;i++)
        {
          s1 = s1 + ar[i] + ",";
        }
        OutputStream ostream = sock.getOutputStream();                 
        DataOutputStream dos = new DataOutputStream(ostream);
        dos.writeBytes(s1);
        dos.close();                            
        ostream.close();   
        InputStream istream = sock.getInputStream();  
        BufferedReader dstream = new BufferedReader(new InputStreamReader(istream));
        String message2 = dstream.readLine();
        System.out.println(message2);
        sock.close();
      } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
     }); 
     
     Thread t2 = new Thread(() -> {
      try {
        Socket sock = new Socket("127.0.0.1", 5001);
        String message1 = "Accept Best Wishes, Serverji";
        String s1 = " ";
        for(int i = 120;i<240;i++)
        {
          s1 = s1 + ar[i] + ",";
        }
        OutputStream ostream = sock.getOutputStream();                 
        DataOutputStream dos = new DataOutputStream(ostream);
        dos.writeBytes(s1);
        dos.close();                            
        ostream.close();   
        sock.close();
      } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
     });
     t1.start();
     //t2.start();
     t1.join();
     //t2.join();
    //  String message1 = "Accept Best Wishes, Serverji";
    //  String s1 = " ";
    //  for(int i = 0;i<240;i++)
    //  {
    //    s1 = s1 + ar[i] + ",";
    //  }

    //  OutputStream ostream = sock.getOutputStream();                 
    //  DataOutputStream dos = new DataOutputStream(ostream);
    //  dos.writeBytes(s1);
    //  dos.close();                            
    //  ostream.close();   
    //  sock.close();
  }
}