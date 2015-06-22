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
			while(true)
			{
				//str = Br.readLine();
				//Dp = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),2000);
				Dp=new DatagramPacket(buff,1024);
				Sock.receive(Dp);
				str=new String(Dp.getData(),0,Dp.getLength());
				
				String c[]=str.split("\\&");
				int a=Integer.parseInt(c[0]);
				int b=Integer.parseInt(c[1]);
				str=(a+b)+"";
				Dp = new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("localhost"),2000);
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
			byte buff[] = new byte[1024];
			System.out.println("Client ready...");
			while(true)
			{ 
				System.out.println("Enter NUmbers: ");
				
				int a=Integer.parseInt(Br.readLine());
				int b=Integer.parseInt(Br.readLine());
				str=a+"&"+b;
				
				Dp = new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("localhost"),1000);
				Sock.send(Dp);
				Dp=new DatagramPacket(buff,1024);
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
