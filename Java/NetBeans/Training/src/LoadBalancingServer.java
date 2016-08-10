import java.net.*;
import java.io.*;

public class LoadBalancingServer {

    public static void main(String args[]) throws IOException
    {
        ServerSocket ss;
        String ip = "localhost";
        int port = 8888;
        int i = 0;
        while (true)
        {
            ss = new ServerSocket(port);
            System.out.println("Waiting for client on port " + ss.getLocalPort());
            Socket server = ss.accept();
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());

            if (i > 3)
            {
                System.out.println("Server Full Forwarding...");
                int port1 = 8889;
                Socket ss1;
                ss1 = new Socket(ip, port1);
                DataInputStream in1 = new DataInputStream(ss1.getInputStream());
                DataOutputStream out1 = new DataOutputStream(ss1.getOutputStream());
                out1.writeUTF(in.readUTF());
                out.writeUTF(in1.readUTF());
                System.out.println("Done");
                server.close();
                ss.close();

                continue;
            }
            i++;
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            String[] nos = (in.readUTF().split("&"));
            int a = Integer.parseInt(nos[0]);
            int b = Integer.parseInt(nos[1]);

            System.out.println("Server");
            a = a - b;
            out.writeUTF(a + "");
            System.out.println("Done");
            server.close();
            ss.close();
        }
    }
}
