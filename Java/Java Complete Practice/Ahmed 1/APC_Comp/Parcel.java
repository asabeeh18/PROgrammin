package APC_Comp;
import java.io.*;
class Parcel
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    void send() throws IOException
    {
        System.out.println("Enter the weight(kg) of the parcel");
        double w=Double.parseDouble(br.readLine());
        
        if(w==1)
        {
            System.out.println("Your amount is Rs.25 ");
        }
        if(w>1)
        {
            double n=w-1;
            double r=n*20;
            double s=r+25;
            System.out.println("Your amount is Rs. "+s);
        }
    }
}
        