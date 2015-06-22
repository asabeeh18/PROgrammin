//Equation Solver
import java.util.*;
class SolveEq
{
	public static int operPrio(Object c)
	{
		if(c=='+' || c=='-')
			return 1;
		else if(c=='*' || c=='/')
			return 2;
		else if(c=='%')
			return 3;
		else if(c=='^')
			return 4;
		else return 0;
	}
	public static int operPrio(char c)
	{
		if(c=='+' || c=='-')
			return 1;
		else if(c=='*' || c=='/')
			return 2;
		else if(c=='%')
			return 3;
		else if(c=='^')
			return 4;
		else return 0;
	}
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		Stack stk=new Stack();
		stk.push(new Character(','));
		String eq=src.nextLine();
		String post="";
		
		//System.out.println(Integer.parseInt(eq));
		for(int i=0;i<eq.length();i++)
		{
			System.out.println(i);
			System.out.println(post);
			if(eq.charAt(i)>='0' && eq.charAt(i)<='9')
				post+=eq.charAt(i);	
			else if(operPrio(eq.charAt(i))>0)
			{	
				while(stk.peek()!=',' && operPrio(stk.peek())<operPrio(eq.charAt(i)))
					post+=stk.pop()+"";
				stk.push(new Character(eq.charAt(i)));
			}
			else if(eq.charAt(i)=='(')
				stk.push(eq.charAt(i));
			else
			{
				while(stk.peek()!=')')
					post+=stk.pop()+"";
				stk.pop();
			}	
		}
		System.out.println(post);
	}
}	