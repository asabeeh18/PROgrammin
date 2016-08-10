
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigInput {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String s[]=r.readLine().split(" ");
        int t=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        int n=0,d;
        while(t-->0)
        {
            d=(Integer.parseInt(r.readLine())%k==0)?n++:0;
        }
        System.out.println(n);
    }
    
}
