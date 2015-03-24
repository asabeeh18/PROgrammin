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
			DatagramSocket serverSocket = new DatagramSocket(port);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String str = new String(receivePacket.getData());
			str=str.trim();
			System.out.println("RECEIVED: " + str);
			int n=Integer.parseInt(str);
			long f=1;
			for(int j=1;j<=n;j++)
			{
				f*=j;
			}
			
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			sendData = (f+"").getBytes();
			DatagramPacket sendPacket =
			new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}
		
		catch(Exception e)
		{
			System.out.println("Thread " +  port + " exiting."+e.toString());
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

