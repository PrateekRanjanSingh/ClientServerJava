import java.net.*;
import java.util.*;
import java.io.*;

class count{
	int c;
	public count()
	{
	}
	public void increment(int i)
	{
		c += i;
	}
}

class client{  
public static void main(String args[])throws Exception{
   
Random rand = new Random();
int ar[] = new int[240];
for (int i = 0; i < 240; i++) {
	int n = rand.nextInt(3);
	n++;
	ar[i] = n;
}
count nn = new count();
Thread t1 = new Thread(()->{
	try {
		Socket s=new Socket("server",5000);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		String s1 = " ";
		for(int i = 0;i<120;i++)
		{
			s1 = s1 + ar[i] + ",";
		}
		dout.writeUTF(s1);
		dout.flush();
		String str2 = "";
		str2 = din.readUTF();
		System.out.println("Hi from thread 1 --> " + str2);
		nn.increment(Integer.parseInt(str2));
		dout.close();  
		s.close();
	} catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
});

Thread t2 = new Thread(()->{
	try {
		Socket s=new Socket("server2",5001);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1 = " ";
		for(int i = 120;i<240;i++)
		{
			s1 = s1 + ar[i] + ",";
		}
		dout.writeUTF(s1);
		dout.flush();
		String str2 = "";
		str2 = din.readUTF();
		System.out.println("Hi from thread 2 --> " + str2);
		nn.increment(Integer.parseInt(str2));
		dout.close();  
		s.close();
	} catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
});

t1.start();
t2.start();
t1.join();
t2.join();
System.out.println(nn.c);
}}



// String str="",str2="";  
// while(!str.equals("stop")){  
// str=br.readLine();  
// dout.writeUTF(str);  
// dout.flush();  
// str2=din.readUTF();  
// System.out.println("Server says: "+str2);  
// } 