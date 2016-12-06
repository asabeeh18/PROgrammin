import java.io.*;
import java.util.*;

public class BalloonGift {

    public static void main(String[] args) {
        
        Scanner r =new Scanner(System.in);
        int t=r.nextInt();
        while(t-->0)
        {
            int x=r.nextInt();
            int k=r.nextInt();
            r.nextLine();
            String s=r.nextLine();
            
            int sum=0;
            for(int i=0;i<x-1;i++)
            {
                int c=r.nextInt();
                sum+=s.charAt(i)=='B'?c:0;
            }
            if(sum>=k)
            {
                System.out.println("Meghana is Happy :)");
            }
            else
                System.out.println("Tihor is Sad :(");
        }
    }
}