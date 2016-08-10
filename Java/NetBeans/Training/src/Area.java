import java.io.IOException;
import java.util.Scanner;
class Area
{
	public static void main(String ar[]) throws IOException
	{
		java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String s=r.readLine();//.split(" ");
		int t = Integer.parseInt(s);//, q = Integer.parseInt(s[1]);
        
		double x1,y1,x2,y2,x3,y3,a,b,c,area,p,carea;
                String o[];
		while(t-->0)
		{
                        o=r.readLine().split(" ");
			x1=sendInt(o[0]);
			y1=sendInt(o[1]);
			o=r.readLine().split(" ");
                        x2=sendInt(o[0]);
			y2=sendInt(o[1]);
			o=r.readLine().split(" ");
                        x3=sendInt(o[0]);
			y3=sendInt(o[1]);
			a=length(x1,y1,x2,y2);
			b=length(x1,y1,x3,y3);
			c=length(x3,y3,x2,y2);
			p=(a+b+c)/2;
			area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
			carea=(22.0/7)*(a*b*c*a*b*c)/(a+b+c)*(a+b-c)*(b+c-a)*(c+a-b);
			System.out.println(carea-area);
		}
	}
	public static double length(double x1,double y1,double x2,double y2)
	{
	
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
	public static double sendInt(String s)
	{
		char c=s.charAt(s.length()-1);
		double x1=Double.parseDouble(s.substring(0,s.length()-1));
		if(c=='W' || c=='S')
			x1=-x1;
		return x1;
	}
}