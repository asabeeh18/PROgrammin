import java.net.*;  
import java.io.*;  
class RunnableDemo implements Runnable 
{
	int port;
	
	RunnableDemo( int port)
	{
		this.port = port;
	}
	public void run() {
		try{
			ServerSocket ss=new ServerSocket(port);  
			Socket s=ss.accept();  
			DataInputStream din=new DataInputStream(s.getInputStream());  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			
			String str="",str2="server Sends";  
			str=din.readUTF();  
			System.out.println("client says: "+str);  
			//   str2=br.readLine();  
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
		}
		
		catch(Exception e)
		{
			System.out.println("Thread " +  port + " exiting.");
		}
		
	}
	public void start ()
	{
		Thread t = new Thread (this, ""+port);
		t.start ();
	}
	
}


class Ser
{  
	public static void main(String args[])throws Exception
	{  
		RunnableDemo R1 = new RunnableDemo( 3333);
		RunnableDemo R2 = new RunnableDemo( 4444);

		R1.start();
	
		R2.start();
		
	}
	
}

