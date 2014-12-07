//Hamming
import java.util.*;
class Ham
{
	public static void main(String args[])
	{
		int bit=-1,p1,p2,p3;
		int u[]=new int[4];
		Scanner src=new Scanner(System.in);
		System.out.println("Enter Data to send");
		int d=Integer.parseInt(src.nextLine());
		int a=d;
		for(int i=0;i<4;i++,a/=10)
			u[i]=a%10;
		p1=(u[0]+u[2]+u[3])%2;
		p2=(u[0]+u[1]+u[3])%2;		
		p3=(u[2]+u[1]+u[0])%2;
		
		String str=""+p1+p2+u[3]+p3+u[2]+u[1]+u[0];
		System.out.println("Sent String: "+str);
		System.out.println("Enter received data");
		String s=(src.nextLine());
		char c[]=s.toCharArray();
		p1=(int)(c[0]+c[2]+c[4]+c[6])-4*48;
		p2=(int)(c[1]+c[2]+c[5]+c[6])-4*48;
		p3=(int)(c[3]+c[4]+c[5]+c[6])-4*48;
		p1%=2;
		p2%=2;
		p3%=2;
		System.out.println(p1+" "+p2+" "+p3);
		bit=1*p1+2*p2+4*p3-1;
		if(bit==-1)
			System.out.println("NO ERROR");
		else
		{
			System.out.println("ERROR in bit: "+bit);
			c[bit]=(c[bit]==0)?'1':'0';
			s=new String(c);
			System.out.println("Correct: "+s);
		}
	}
}