//UDPCAPS
import java.io.*;	
import java.net.*;
class UdpServer
{
	 public static void main(String arg[])
	{
		String str;
		byte buff[] = new byte[1024];
		try
		{ 
			
			DatagramSocket Sock;
			Sock = new DatagramSocket(1000);
			DatagramPacket Dp;
			System.out.println("Enter the data..... Enter 'exit' to stop");
			while(true)
			{
				//str = Br.readLine();
				//Dp = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),2000);
				Dp=new DatagramPacket(buff,1024);
				Sock.receive(Dp);
				str=new String(Dp.getData(),0,Dp.getLength());
				str=str.toUpperCase();
				System.out.println(str);
				Dp = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),2000);
				Sock.send(Dp);
				if(str.equals("exit")) 
				break;
			}
			Sock.close();
		}
		catch(Exception e) { }
	}
}

class UdpClient
{
	public static void main(String arg[])
	{ 
		String str;
		DatagramSocket Sock;
		DatagramPacket Dp;
		BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			Sock = new DatagramSocket(2000);	//port
			//byte buff[] = new byte[1024];
			System.out.println("Client ready...");
			while(true)
			{ 
				System.out.println("Enter String: ");
				str=Br.readLine();
				Dp = new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("localhost"),1000);
				Sock.send(Dp);
				Sock.receive(Dp);
				str = new String(Dp.getData(),0,Dp.getLength());	//String(byte[] bytes, int offset, int length)
				System.out.println(str);
				if(str.equals("exit")) 
					break;
			}
			Sock.close();
		} 
		catch(Exception e){
			System.out.println("Connection failure..."); 
		}
		finally{
			System.out.println("Server Disconnected...");
		}
	}
}
