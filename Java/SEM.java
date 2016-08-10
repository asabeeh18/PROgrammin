//MAths Eval #Jigar
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.util.*;
class SEM
{
	public static String fnctSolver(String eq,int i)throws Exception	//No support for braces in pre-post analysis YET!!
														//Using ^ and log				
	{
		int j=i,m=i;
		i--;
		while(i>-1 && i<eq.length() && ((eq.charAt(i)>='0' && eq.charAt(i)<='9') || eq.charAt(i)=='.'))
			i--;
		i++;
		double pre=solve(eq.substring(i,j));
		int k=i;	//k<--leftmost digit place
		i=j;
		//for named functions
		if((i+3)<eq.length() && eq.substring(i,i+3).equals("log"))
			i=i+3;
		else 
			i++;
		//calculate post digit	
		
		j=i;	
		while(i>-1 && i<eq.length() && ((eq.charAt(i)>='0' && eq.charAt(i)<='9') || eq.charAt(i)=='.'))
			i++;
		double post=solve(eq.substring(j,i));
		//****PRE-POST ANALYSIS****
		double result=0;
		if(eq.charAt(m)=='^')
			result=Math.pow(pre,post);
		else if((m+3)<eq.length() && (eq.substring(m,m+3)).equals("log"))
			result=pre*Math.log10(post);
		System.out.println(pre*Math.log10(post)+" "+result+" "+post);	
		return eq.substring(0,k)+result+eq.substring(i,eq.length());
	}
	public static double solve(String eq)throws Exception
	{
		for(int i=0;i<eq.length();i++)
		{
			if(eq.charAt(i)=='^')
			{
				eq=fnctSolver(eq,i);
				i=0;	
			}
			else if((i+3)<eq.length() && eq.substring(i,i+3).equals("log"))
			{
				eq=fnctSolver(eq,i);
				i=0;
			}
		}	
		
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		//String foo = "4^6";
		return ((Double)engine.eval(eq)).doubleValue();
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner src=new Scanner(System.in);
		String eq=src.nextLine();
		System.out.println(solve(eq));
		
    } 
}