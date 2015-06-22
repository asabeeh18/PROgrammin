
//Client end:
import java.net.*;
import java.io.*;
import java.util.*;
 class Client02
{
 public static void main(String[] ar)
 {
  int serverPort = 6666; 
 String address = "127.0.0.1"; 
 try
 {
  InetAddress ipAddress = InetAddress.getByName(address); 
  System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
  Socket socket = new Socket(ipAddress, serverPort); 
  System.out.println("Server found");    
  InputStream sin = socket.getInputStream();
  OutputStream sout = socket.getOutputStream();
  DataInputStream in = new DataInputStream(sin);
  DataOutputStream out = new DataOutputStream(sout);   
  Scanner src=new Scanner(System.in);
  String num1 = null;
  String num2 = null;
  String line = null;
  System.out.println();
  while(true)
  {
   line=in.readUTF();
   System.out.println(line);
   System.out.println("Enter 1st number");
   num1 = src.nextLine(); 
	out.writeUTF(num1); 
   out.flush(); 
    line = in.readUTF(); 
    System.out.println("Server : " + line);
    System.out.println("Continue");
    System.out.println();
   }
  }
  catch(Exception x)
  {
   x.printStackTrace();
  }
 }
}
