import java.util.Scanner;
class Area
{
	public static void main(String ar[])
	{
		java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String s=r.readLine();//.split(" ");
		int t = Integer.parseInt(s);//, q = Integer.parseInt(s[1]);
        char c;
		double x1,y1,x2,y2,x3,y3,a,b,c,area,p;
		while(t-->0)
		{
			x1=sendInt(r.read());
			y1=sendInt(r.read());
			x2=sendInt(r.read());
			y2=sendInt(r.read());
			x3=sendInt(r.read());
			y3=sendInt(r.read());
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
		char c=s.charAt(s.length-1);
		int x1=Double.parseDouble(s.substring(0,s.length()-1));
		if(c=='W' || c=='S')
			x1=-x1;
		return x1;
	}
}