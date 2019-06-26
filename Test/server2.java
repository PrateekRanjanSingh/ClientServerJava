import java.net.*;  
import java.io.*;  
class server2{  
public static void main(String args[])throws Exception{  
ServerSocket ss=new ServerSocket(5001);

while (true)
{
    Socket s=ss.accept();  
    DataInputStream din=new DataInputStream(s.getInputStream());  
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
    String str ="",str2="";
    str = din.readUTF();
    System.out.println(str);
    int a = 0;
    for(int i = 0;i<60;i++)
    {
    if(str.charAt(i)=='1') a++;
    }
    str2 = "" + a;
    dout.writeUTF(str2);
    // dout.flush();
    // din.close(); 
    // s.close();  
    // ss.close(); 
} 
}}

// String str="",str2="";  
// while(!str.equals("stop")){  
// str=din.readUTF();  
// System.out.println("client says: "+str);  
// str2=br.readLine();  
// dout.writeUTF(str2);  
// dout.flush();  
// } 