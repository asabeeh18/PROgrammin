import java.net.*;  
import java.io.*;  


class Ser
{  
	public static void main(String args[])throws Exception
	{
		DatagramSocket serverSocket = new DatagramSocket(3333);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		for(int i=0;i<2;i++)
		{
			
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
			System.out.println("Sent: " + f);
		}
	}
	
}

