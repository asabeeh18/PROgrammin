import java.net.*;  
import java.io.*;  
class Ser
{  
	public static void main(String args[])throws Exception
	{  
		for(int i=0;i<2;i++)
		{
			ServerSocket ss=new ServerSocket(3333);  
			Socket s=ss.accept();  
			DataInputStream din=new DataInputStream(s.getInputStream());  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			
			String str="",str2="";  
			str=din.readUTF();  
			System.out.println("Client says: "+str);
			int n=Integer.parseInt(str);
			long f=1;
			for(int j=1;j<=n;j++)
			{
				f*=j;
			}
			
			dout.writeUTF(f+""); 
			dout.flush();
			din.close();  
			s.close();  
			ss.close();
			System.out.println("OUT");
		}
	}  
}

