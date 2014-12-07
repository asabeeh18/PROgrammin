//abad abgd
class Shreya
{
	public static void main(String args[])
	{
		int k=0;
		for(int a=0;a<10;a=a+8)
			for(int b=0;b<10;b++)
				for(int d=0;d<10;d++)
					for(int g=0;g<10;g++)
						if(a!=b && b!=d && a!=d && a!=g && b!=g && g!=d)
						{
							System.out.println(a+""+b+""+a+""+d+" "+a+""+b+""+g+""+d);
							k++;
						}
						System.out.println(k);	
	}
}	
