import java.io.*;
class Game
{
public static void stick(int s)
{
for (int i=1;i<=4;i++)
{
for (int j=1;j<=s;j++)
{
System.out.print("| ");
}
System.out.println();
}
}
public static void main(String args[])throws IOException
{
Game.game();
}
public static void game()
{
try
{
int m=0,i=0,p=0,s=0;
for (i=1;i<=60;i++)
{
System.out.print("*");
Game.delay2();
}
System.out.println();
System.out.println(" WELCOME TO THE GAME! ");
System.out.println("RULE 1: YOU ONLY PICK 1-4 STICKS");
System.out.println("RULE 2: THE ONE WHO HAS TO PICK THE LAST STICK LOSES");
System.out.println();
InputStreamReader in=new InputStreamReader(System.in);
BufferedReader r=new BufferedReader(in);
System.out.print("WATCH DEMO? PRESS 1 TO WATCH or 0 TO PLAY:");
for (;;)
{
int ch=Integer.parseInt(r.readLine()); 
System.out.println();
if (ch==1)
{
Game.demo();
break;
}
else if (ch==0)
break;
else
{
System.out.println();
System.out.println("WRONG CHOICE");
System.out.print("PRESS 1 TO WATCH OR 0 TO PLAY:");
continue;
}
}
for (;;)
{
System.out.print("PRESS 1 TO PLAY WITH CPU OR 2 TO PLAY VS. ANOTHER PLAYER: ");
p=Integer.parseInt(r.readLine());
System.out.println();
if (p==1)
{
System.out.println("1. EASY MODE");
System.out.println("2. DIFFICULT MODE");
System.out.print("3. ENTER CHOICE: ");
for (;;)
{
m=Integer.parseInt(r.readLine());
if (m==1||m==2)
break;
else
{
System.out.println();
System.out.println("WRONG CHOICE");
System.out.print("ENTER CHOICE: ");
continue;
}
}
break;
}
else if (p==2)
break;
else
{
System.out.println();
System.out.println("WRONG CHOICE");
continue;
}
}
System.out.print("ENTER THE NO. OF STICKS YOU WANT TO PLAY WITH: ");
for (;;)
{
s=Integer.parseInt(r.readLine());
if (s<=0)
{
System.out.println();
System.out.println("ILLEGAL NO. OF STICKS");
System.out.print("ENTER THE NO. OF STICKS YOU WANT TO PLAY WITH: ");
continue;
}
else if (s>0&&s<=10)
{
System.out.println();
System.out.println("INSUFFICIENT NO. OF STICKS");
System.out.print("ENTER THE NO. OF STICKS YOU WANT TO PLAY WITH: ");
continue;
}
else
break;
}
System.out.println(); 
System.out.print("LOADING");
for (i=0;i<10;i++)
{
System.out.print(".");
Game.delay1();
}
System.out.println();
for(i=1;i<=60;i++)
{
System.out.print("*");
Game.delay2();
}
System.out.println();
if (p==1)
{
if (m==1)
Game.onePlayerEasy(s);
else if (m==2)
Game.onePlayerDiff(s);
}
else if (p==2)
Game.twoPlayers(s);
}
catch (Exception e)
{
System.out.println();
System.out.println();
System.out.println("Fatal Error! Program Will Restart!");
System.out.println();
System.out.println();
Game.game();
}
}
public static void demo()
{
int s=10,p1=0,p2=0,i=0;
for (i=0;i<20;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.print("DEMO");
for (i=0;i<20;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.println();
System.out.println("NO. OF STICKS: "+s);
Game.stick(s);
for (i=0;;i++)
{
p1=Game.rand();
if (s<=4)
{
if(s==4&&p1==4)
{
p1-=1;
}
else if(s==3)
{
if (p1==4)
p1-=2;
else if (p1==3)
p1-=1;
}
else if(s==2)
{
if (p1==4)
p1-=3;
else if(p1==3)
p1-=2;
else if(p1==2)
p1-=1;
}
else if(s==1)
{
System.out.println("Player 2 wins");
for (i=0;i<44;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.println();
break;
}
}
Game.delay();
System.out.println("No. of sticks picked by player 1: "+p1);
s-=p1; 
Game.stick(s);
if (s==1)
{
System.out.println("Player 1 wins");
for (i=0;i<44;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.println();
break;
}
p2=Game.rand();
if (s<=4)
{
if(s==4&&p2==4)
{
p2-=1;
}
else if(s==3)
{
if (p2==4)
p2-=2;
else if (p2==3)
p2-=1;
}
else if(s==2)
{
if (p2==4)
p2-=3;
else if(p2==3)
p2-=2;
else if(p2==2)
p2-=1;
}
else if(s==1)
{
System.out.println("Player 1 wins");
for (i=0;i<44;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.println();
break;
}
}
Game.delay();
System.out.println("No. of sticks picked by player 2: "+p2);
s-=p2;
Game.stick(s); 
if(s==1)
{
System.out.println("Player 2 wins");
for (i=0;i<44;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.println();
break;
}
}
}
public static void twoPlayers(int s)
{
try
{
InputStreamReader in=new InputStreamReader(System.in);
BufferedReader r=new BufferedReader(in);
int s1=s,c=0,cc=0,i=0;
Game.stick(s1);
for (i=0;;i++)
{
for (;;)
{
System.out.println("Player 1:");
System.out.print("Enter the no. of sticks to pick:");
c=Integer.parseInt(r.readLine()); 
if(c>=5||s1-c<1)
{
System.out.println();
System.out.println("Wrong choice!");
continue;
}
else
{
s1-=c;
break;
}
}
Game.stick(s1);
if (s1==1)
{
System.out.println("Player 1 Wins!");
for (i=0;i<60;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.println();
Game.exit();
}
for (;;)
{
System.out.println("Player 2:");
System.out.print("Enter no. of sticks to pick:");
cc=Integer.parseInt(r.readLine());
if(cc>=5||s1-cc<1)
{
System.out.println();
System.out.println("Wrong choice!"); 
continue;
}
else
{
s1-=cc;
break;
}
}
Game.stick(s1); 
if(s1==1)
{
System.out.println("Player 2 Wins!");
for (i=0;i<60;i++)
{
System.out.print("-");
Game.delay2();
}
System.out.println();
Game.exit();
}
}
}
catch (Exception e)
{
System.out.println();
System.out.println();
System.out.println("Fatal Error! Program Will Restart!");
System.out.println();
System.out.println();
Game.game();
} 
}
public static void onePlayerEasy(int s)
{
try
{
InputStreamReader in=new InputStreamReader(System.in);
BufferedReader r=new BufferedReader(in);
int s1=s,c=0,cc=0;
Game.stick(s1);
for (int i=0;;i++)
{
System.out.print("Enter the no. of sticks to pick:");
c=Integer.parseInt(r.readLine()); 
if (c>4||s1-c<1)
{
System.out.println();
System.out.println("Wrong choice! Enter again!");
continue;
}
else
s1-=c;
Game.stick(s1);
if (s1==1)
{
System.out.println("You Win!");
Game.exit();
}
System.out.println("Computer's Turn:");
cc=Game.rand();
if (s1<=4)
{
if(s1==4&&cc==4)
{
cc-=1;
}
else if(s1==3)
{
if (cc==4)
cc-=2;
else if (cc==3)
cc-=1;
}
else if(s1==2)
{
if (cc==4)
cc-=3;
else if(cc==3)
cc-=2;
else if(cc==2)
cc-=1;
}
else if(s1==1)
{
System.out.println("You win");
Game.exit();
}
}
Game.delay(); 
System.out.println("No. of sticks picked:"+cc);
s1-=cc;
Game.stick(s1); 
if(s1==1)
{
System.out.println("Computer Wins!");
Game.exit();
}
}
}
catch (Exception e)
{
System.out.println();
System.out.println();
System.out.println("Fatal Error! Program Will Restart!");
System.out.println();
System.out.println();
Game.game();
}
}
public static void onePlayerDiff(int s)
{
try
{
InputStreamReader in=new InputStreamReader(System.in);
BufferedReader r=new BufferedReader(in);
int s1=s,c=0,cc=0;
Game.stick(s1);
for (int i=0;;i++)
{
System.out.print("Enter the no. of sticks to pick:");
c=Integer.parseInt(r.readLine()); 
if (c>4||s1-c<0)
{
System.out.println();
System.out.println("Wrong choice! Enter again!");
continue;
}
else
{
s1-=c; 
if (c%2==0)
cc=Game.randOdd();
else
cc=Game.randEve();
}
Game.stick(s1);
if (s1==1)
{
System.out.println("You Win!");
Game.exit();
}
System.out.println("Computer's Turn:");
if (s1<13)
{
if (s1==5)
cc=4;
else if(s1==4)
{
cc=3;
}
else if(s1==3)
{
cc=2;
}
else if(s1==2)
{
cc=1;
}
else if(s1==1)
{
System.out.println("You win");
Game.exit();
}
else if(s1>4&&s1<10&&cc<=4)
{
cc=1;
}
else if(s1>=10)
{
if(c%2==0)
cc=1;
else 
cc=2;
}
}
Game.delay();
System.out.println("No. of sticks picked:"+cc);
s1-=cc;
Game.stick(s1); 
if(s1==1)
{
System.out.println("Computer Wins!");
Game.exit();
}
}
}
catch (Exception e)
{
System.out.println();
System.out.println();
System.out.println("Fatal Error! Program Will Restart!");
System.out.println();
System.out.println();
Game.game();
}
}
public static void exit()throws IOException
{
InputStreamReader in=new InputStreamReader(System.in);
BufferedReader r=new BufferedReader(in);
int i=0;
for (;;)
{
System.out.print("PRESS 1 TO PLAY AGAIN OR 0 TO EXIT : ");
int ans=Integer.parseInt(r.readLine());
if (ans==1)
Game.game();
else if (ans==0)
{
for (i=0;i<60;i++)
{
System.out.print("*");
Game.delay2();
}
System.exit(0);
}
else
{
System.out.println();
System.out.println("WRONG CHOICE");
continue;
} 
}
}
public static void delay()
{
for (int i=0;i<1000000000;i+=1);
}
public static void delay1()
{
for (int i=0;i<=50000000;i++);
}
public static void delay2()
{
for (int i=0;i<=5000000;i++);
}
public static int rand()
{
double t=0.0d;int n=0;
for (int i=0;;i++)
{
t=Math.random();
n=(int)(10.0*(t+Math.random()));
if (n>0&&n<=4)
{
return n;
}
}
}
public static int randEve()
{
double t=0.0d;int n=0;
for (int i=0;;i++)
{
t=Math.random();
n=(int)(10.0*(t+Math.random()));
if (n==2||n==4)
{
return n;
}
}
}
public static int randOdd()
{
double t=0.0d;int n=0;
for (int i=0;;i++)
{
t=Math.random();
n=(int)(10.0*(t+Math.random()));
if (n==1||n==3)
{
return n;
}
}
}
}