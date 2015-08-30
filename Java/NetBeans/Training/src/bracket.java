import java.util.Scanner;
public class bracket
{
	
	static char p[];
	static int n;
	
	static int ST=-1;
	static int popS()
	{
		if(ST>-1)
		{
			ST--;
			return 1;
		}
		return 0;
	}
	static void pushS()
	{
		ST++;
	}
	static int maiin(int i) //i is '<'
	{
		
		i+=2;
		while(i<n && p[i]!='>')
		{
			if(p[i]=='{')
			pushS();
			else if(p[i]=='}')
			{
				if(popS()==0)
				return 0;
			}
			else if(p[i]=='P')
			{}
			else
				return 0;
			i+=2;
		}
		if(ST==-1 && p[i]=='>')
			return i;
		return 0;
	}
	static int userdef(int i) //i is '<'
	{
		int poi=0;
		i+=2;
		while(i<n && p[i]!=')')
		{
			if(p[i]=='{')
			pushS();
			else if(p[i]=='}')
			{
				if(popS()==0)
				return 0;
			}
			else if(p[i]=='P')
			{
				poi++;
				if(poi>100)
					return 0;
			}
			else
				return 0;
			i+=2;
		}
		if(ST==-1 && p[i]==')')
			return i;
		return 0;
	}
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int t=r.nextInt();
		String temp123=r.nextLine();
		while(t-->0)
		{
			int status=0;
			int i=0;
			int mainC=0;
			boolean printed=false;
			p=(r.nextLine()).toCharArray();
			n=p.length;
			//System.out.println(p);
			if(p[0]=='{' && p[n-1]=='}')
			{
				i+=2;
				while(i!=n-1)
				{				
					status=0;
					switch(p[i])
					{
						case '<':	if(mainC==1)
									{
										status=0;
										break;
									}
									status=maiin(i);
                                    i=status;
									mainC=1;
                                    break;
						case '(': 	status=userdef(i);
									i=status;
									break;
						case 'P':status=1;
                                                
									break;
					}
					if(status<1)
					{
						System.out.println("Compilation Errors");
						printed=true;
						break;
					}
					i+=2;
				}
				if(status>0 && mainC==1)
				{
					System.out.println("No Compilation Errors");
					printed=true;
				}
				else if(!printed)
				{
					System.out.println("Compilation Errors");
					printed=true;
				}
			}
			else
			{
				System.out.println("Compilation Errors");
				printed=true;
			}
			if(!printed)
			{
				System.out.println("No Compilation Errors");
				
			}
			
		}
		
	}
}