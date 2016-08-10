import java.net.*;
import java.io.*;

public class LoadBalancingServer1 {

    public static void main(String args[]) throws IOException
    {
        ServerSocket ss;
        //String ip="localhost";
        int i = 0;
        while (true)
        {
            int port = 8889;
            ss = new ServerSocket(port);
            System.out.println("Waiting for client on port " + ss.getLocalPort());

            Socket server = ss.accept();
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
		    String[] nos = (in.readUTF().split("&"));
            int a = Integer.parseInt(nos[0]);
            int b = Integer.parseInt(nos[1]);

            System.out.println("Load Sharing Server");
            a = a - b;
            out.writeUTF(a + "");
            System.out.println("Done");
            server.close();
            ss.close();
        }
    }
}