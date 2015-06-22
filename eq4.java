import java.util.*;
public class Main
{
    public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		long test=src.nextlong();
		while(test-->0)
		{
			long te=src.nextlong();
			long d=1;
			long c=src.nextlong();
			long b=c*c;
			long a=c*c*c;
			long e=src.nextlong();
			long h=src.nextlong();
			long g=h*h;
			long f=h*h*h;
			long i=1;
			long j=src.nextlong();
			 long m=src.nextlong();
			long k=m*m*m;
			long l=m*m;
			long n=1;
			 long o=src.nextlong();
			 long r=src.nextlong();
			 long p=r*r*r;
			 long q =r*r;
			 long s=1;
			 long t=src.nextlong();
			double delta=((a*g*m*s)+(a*h*n*q)+(a*i*l*r)-(a*i*m*q)-(a*g*n*r)-(a*h*l*s)-(f*b*m*s)-(f*c*n*q)-(f*d*l*r)+(f*d*m*q)+(f*b*n*r)+(f*c*l*s)+(k*b*h*s)+(k*c*i*q)+(k*d*g*r)-(k*d*h*q)-(k*b*i*r)-(k*c*g*s)-(p*b*h*n)-(p*c*i*l)-(p*d*g*m)+(p*d*h*l)+(p*b*i*m)+(p*c*g*n));
			double wnum =((e*g*m*s)+(e*h*n*q)+(e*i*l*r)-(e*i*m*q)-(e*g*n*r)-(e*h*l*s)-(j*b*m*s)-(j*c*n*q)-(j*d*l*r)+(j*d*m*q)+(j*b*n*r)+(j*c*l*s)+(o*b*h*s)+(o*c*i*q)+(o*d*g*r)-(o*d*h*q)-(o*b*i*r)-(o*c*g*s)-(t*b*h*n)-(t*c*i*l)-(t*d*g*m)+(t*d*h*l)+(t*b*i*m)+(t*c*g*n));
			double aans = (wnum/delta);
			double xnum=((a*j*m*s)+(a*h*n*t)+(a*i*o*r)-(a*i*m*t)-(a*j*n*r)-(a*h*o*s)-(f*e*m*s)-(f*c*n*t)-(f*d*o*r)+(f*d*m*t)+(f*e*n*r)+(f*c*o*s)+(k*e*h*s)+(k*c*i*t)+(k*d*j*r)-(k*d*h*t)-(k*e*i*r)-(k*c*j*s)-(p*e*h*n)-(p*c*i*o)-(p*d*j*m)+(p*d*h*o)+(p*e*i*m)+(p*c*j*n));

			double bans = (xnum/delta);
			double ynum= ((a*g*o*s)+(a*j*n*q)+(a*i*l*t)-(a*i*o*q)-(a*g*n*t)-(a*j*l*s)-(f*b*o*s)-(f*e*n*q)-(f*d*l*t)+(f*d*o*q)+(f*b*n*t)+(f*e*l*s)+(k*b*j*s)+(k*e*i*q)+(k*d*g*t)-(k*d*j*q)-(k*b*i*t)-(k*e*g*s)-(p*b*j*n)-(p*e*i*l)-(p*d*g*o)+(p*d*j*l)+(p*b*i*o)+(p*e*g*n));
			double cans = (ynum/delta);
			double znum=((a*g*m*t)+(a*h*o*q)+(a*j*l*r)-(a*j*m*q)-(a*g*o*r)-(a*h*l*t)-(f*b*m*t)-(f*c*o*q)-(f*e*l*r)+(f*e*m*q)+(f*b*o*r)+(f*c*l*t)+(k*b*h*t)+(k*c*j*q)+(k*e*g*r)-(k*e*h*q)-(k*b*j*r)-(k*c*g*t)-(p*b*h*o)-(p*c*j*l)-(p*e*g*m)+(p*e*h*l)+(p*b*j*m)+(p*c*g*o));
			double dans = (znum/delta);
			
			//longegrate
			System.out.println(aans*te*te*te*te/4+bans*te*te*te/3+cans*te*te/2+dans*te);
			}
		}	
}			


