
//Server end:
import java.net.*;
import java.io.*;
 class Server02
{
  public static void main(String[] ar)
  {
   int port = 6666;
   try
   {
    ServerSocket ss = new ServerSocket(port);
    System.out.println("Waiting for a client...");
    Socket socket = ss.accept();
    System.out.println("Client found");
    System.out.println();
    InputStream sin = socket.getInputStream();
    OutputStream sout = socket.getOutputStream();
    DataInputStream in = new DataInputStream(sin);
    DataOutputStream out = new DataOutputStream(sout);
    String num1 = null;
    String num2 = null;
    while(true)
    {
    out.writeUTF("Enter a number");
    num1 = in.readUTF();
   // num2 = in.readUTF();
    System.out.println("String: " + num1);
    System.out.println("Capitalised: ");
    out.writeUTF("string = "+num1.toUpperCase());
    out.flush();
    System.out.println("Waiting for further commands");
    System.out.println();
   }
  }
  catch(Exception x)
  {
   x.printStackTrace();
  }
 }
}

 
