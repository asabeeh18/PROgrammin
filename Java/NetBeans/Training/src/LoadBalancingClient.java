import java.net.*;
import java.util.Scanner;
import java.io.*;

public class LoadBalancingClient {

    public static void main(String args[]) throws IOException
    {
        Scanner src = new Scanner(System.in);
        Socket ss;
        String ip = "localhost";
        int port = 8888;
        ss = new Socket(ip, port);
        System.out.println("Waiting for client on port " + ss.getLocalPort());
        DataInputStream in = new DataInputStream(ss.getInputStream());
        DataOutputStream out = new DataOutputStream(ss.getOutputStream());
        System.out.println("Enter 2 numbers");
        int a = src.nextInt();
        int b = src.nextInt();
        out.writeUTF(a + "&" + b);
        String ans = in.readUTF();
        System.out.println("Difference: " + ans);
        ss.close();
    }
}
