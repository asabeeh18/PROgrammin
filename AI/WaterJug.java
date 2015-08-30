import java.util.*;

public class WaterJug
{
	public static void main(String args[])
	{
	 	Scanner src = new Scanner(System.in);
    System.out.println("Enter maximum capacity of the two jugs:");
    int jug_a = src.nextInt();
    int jug_b = src.nextInt();
    int a=jug_a;
    int b=jug_b;
    int c = 0;
    while(a % b !=0)
    { 
    	int t=a;
    	a=b;
    	b=a % t;
    }
    System.out.println("Enter goal state of first jug:");
    int g=src.nextInt();
    while(g % b ==0)
    {
    	System.out.println("Goal state cannot be reached!");
    	System.out.println("Enter goal state of first jug:");
    	g=src.nextInt();
    }
    System.out.println("Enter the intial state of the first jug:");
    int x=src.nextInt();
    if(x==g)
    {
    	System.out.println("Goal state already achieved :)");
    	return;
    }
    while(x>jug_a || x<0)
    {
     System.out.println("Incorrect entry!!");
     System.out.println("Enter the intial state of the first jug:");
     x=src.nextInt();
    }
    System.out.println("Enter the intial state of the second jug:");
    int y=src.nextInt();
    while(y>jug_b || y<0)
    {
     System.out.println("Incorrect entry!!");
     System.out.println("Enter the intial state of the second jug:");
     y=src.nextInt();
    }
		while(x!=g)
		{ 		  
			f1:if(x==0 && y==0)
					{
						System.out.println("Start with: 1. First jug 2. Second jug");
						c = src.nextInt();
						if(c==1)
						{
							x=jug_a;
							//System.out.println(x+" "+y);
							break f1;
						}
						else if (c==2)
									{
										y=jug_b;
										//System.out.println(x+" "+y);
										break f1;
									}
								else 
								{
									System.out.println("Wrong choice!");
									return;
								}
					} 
			f2:if(y==jug_b && x==0)
					{
						x=0;
						System.out.println(x+" "+y);
						c=2;
						break f2;
					}
				 else if(x==jug_a && y==0)
							{
								y=0;
								System.out.println(x+" "+y);
								c=1;
								break f2;
							}
							else if(y==jug_b && x==0)
										{
											x=0;
											System.out.println(x+" "+y);
											c=2;
											break f2;
										}
			f3:if(y>0 && x!=jug_a)
					{
						if(x+y<jug_a)
						{
							x=x+y;
							y=0;
							System.out.println(x+" "+y);
							break f3;
						}
						else if(x+y>jug_a)
									{
										y=y-(jug_a-x);
										x=jug_a;
										System.out.println(x+" "+y);
										break f3;
									}
									else if(x!=jug_a)
												{
												 if(c==1)
												 {
													y=0;
													System.out.println(x+" "+y);
													break f3;
												 }
												 if(c==2)
												 {
												  x=jug_a;
												  System.out.println(x+" "+y);
													break f3;
												 }
												}
					}
			f4:if(x>0 && y!=jug_b)
					{
						if(x+y<jug_b)
						{
							y=x+y;
							x=0;
							System.out.println(x+" "+y);
							break f4;
						}
						else if(x+y>jug_b)
									{
									 if(c==1)
									 {
										x=x-(jug_b-y);
										y=jug_b;
										System.out.println(x+" "+y);
										break f4;
									 }
									 if(c==2)
									 {
										x=0;
										System.out.println(x+" "+y);
										break f4;
									 }							 
									}
									else if(y!=jug_b)
												{
												 if(c==1)
												 {
													x=0;
													System.out.println(x+" "+y);
													break f4;
												 }
												 if(c==2 && x!=jug_a)
												 {
												  y=jug_b;
												  System.out.println(x+" "+y);
													break f4;
												 }
												}
					}
			f5:if(y<jug_b && x!=jug_a && x!=0)
					{
						y=jug_b;
						System.out.println(x+" "+y);
						break f5;
					}
					else if(x<jug_a && y!=jug_b && y!=0)
								{
								 if(c==2)
								 {
								  x=y;
								  y=0;
								  System.out.println(x+" "+y);
								  break f5;
								 }
								 if(c==1)
								 {
									x=jug_a;
									System.out.println(x+" "+y);
									break f5;
								 }
								}
		}
		System.out.println("Final state:"+x+" "+y);
  }
}

    
