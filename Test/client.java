import java.net.*;
import java.util.*;
import java.io.*;

class client{  
public static void main(String args[])throws Exception{  
Socket s=new Socket("localhost",3333);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
// String str="",str2="";  
// while(!str.equals("stop")){  
// str=br.readLine();  
// dout.writeUTF(str);  
// dout.flush();  
// str2=din.readUTF();  
// System.out.println("Server says: "+str2);  
// }  
Random rand = new Random();
    int ar[] = new int[240];
    for (int i = 0; i < 240; i++) {
      int n = rand.nextInt(3);
      n++;
      ar[i] = n;
    }
    String s1 = " ";
    for(int i = 0;i<240;i++)
    {
      s1 = s1 + ar[i] + ",";
    }
  dout.writeUTF(s1);
  dout.flush();
  String str2 = "";
  str2 = din.readUTF();
  System.out.println(str2);
dout.close();  
s.close();  
}}  