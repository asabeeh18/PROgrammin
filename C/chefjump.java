import java.util.*;
class Main
{
public static void main(String args[])
{
	Scanner src=new Scanner(System.in);
	long a,i,k;
	a=src.nextLong();
	for(i=0,k=1;i!=a && i<a && k!=a;i++,k+=6)
	{
		if(i*3==a)
			break;
		if(k==a)
			break;
	}	
	if(i*3==a)
		System.out.println("yes");
	else
		System.out.println("no");
		
}		
}