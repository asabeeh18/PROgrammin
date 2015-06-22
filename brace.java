import java.util.*;
class Solution
{
public static int l,p;
public static char c;
public static int d,i,m=0,t;

public static int looper(int i,String str,char s)
{
	int j,brac=0;
//	i++;
	for(j=i+1;j<l-1;j++)
	{
		if(str.charAt(j)=='{')
			brac++;
		else if(str.charAt(j)=='}' && brac>0)
			brac--;
		
		else if(str.charAt(j)==s && brac==0)
			return j;
		else if(str.charAt(j)=='P')
			p++;
		else if(str.charAt(i)==' ');
		else
			return -1;
	}
	return -1;
}

public static int solve()
{
		p=0;
		m=0;
		Scanner src=new Scanner(System.in);
		String str=src.nextLine();
		//fgets(str,1000, stdin);
		
    /* Remove trailing newline, if there. 
    if ((strlen(str)>0) && (str[strlen (str) - 1] == '\n'))
        str[strlen (str) - 1] = '\0';
*/
		l=str.length();
		//System.out.println("%s",str);
		if(str.charAt(l-1)=='}' && str.charAt(0)=='{')
		{
			for(i=1;i<l-1;i++)
			{
				switch(str.charAt(i))
				{
					case '<':   m++;
								if(m==2)
								{
									return 0;
								}
								else
								{
									d=looper(i,str,'>');
									if(d==-1)
									{
	//									System.out.println("Compilation Errors");
										return 0;
									}
									else
										i=d;
								}
								break;
					case '(':
								d=looper(i,str,')');
								if(d==-1)
								{
		//							System.out.println("Compilation Errors");
									return 0;
								}
								else
									i=d;
								break;
					case ' ': break;
					case 'P': p++;
								if(p>100)
								{
			//						System.out.println("Compilation Errors");
									return 0;
								}
								break;
					default: //System.out.println("Compilation Errors");
							return 0;
				}

			}
		}
		else
		{
		//	System.out.println("Compilation Errors");
			return 0;
		}
		//System.out.println("No Compilation Errors");
		if(m!=1)
			return 0;
		return 1;
}
public static void main(String args[])
{
	int t;
	
	Scanner src=new Scanner(System.in);
	t=src.nextInt();
	while(t--!=0)
	{
		if(solve()==1)
			System.out.println("No Compilation Error");
		else
			System.out.println("Compilation Errors");
	}
}
}