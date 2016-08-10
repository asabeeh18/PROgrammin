// :| did i really do this? :| i shud hav comeup wiht bttr names to learn Inheritance and Exception :| anyways it's probably a courtesy of ykh
//SUPER Exception Handling
/* Used finally,try-catch,nested try catch,throw,throwa
Manually Created an Exception*/
import java.util.*;
import java.io.*;
class PaagalpanException extends Exception
{
	public String toString()
	{
		return "Paagal Exception Found";
	}
}
class TryPaagal
{
	public void baka(int b)
	{
		try
		{
			if(b==1)
				throw new PaagalpanException();
			else
			{
				System.out.println("Every Paagal Says so! :P ");
				System.out.println("Again R U a Paagal??\n1.YES\n2.NO");
				int n=(new Scanner(System.in)).nextInt();
				try{
				if(n==1)
					throw new PaagalpanException();
				else
					System.out.println("wu..t AGAIN!??!!! D.I.E");
					int q=3/0;
				}
				catch(ArithmeticException e){}	
				return;
			}	
		}
		catch(PaagalpanException p)
		{
			System.out.println(p);
			return;
		}
		finally
		{
			System.out.println("YOU r Still a Paagal");
		}
	}
}
class Paagal
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		TryPaagal tp=new TryPaagal();
		System.out.println("R U a Paagal??\n1.YES\n2.NO");
		tp.baka(Integer.parseInt(br.readLine())) ;
	}
}