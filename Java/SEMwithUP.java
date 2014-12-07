import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.util.*;
class SEM
{
	public static double numDetect(String eq,int i)
	{
		int j=i;
		i--;
		while(eq.charAt(i)>='0' && eq.charAt(i)<='9')
			i--;
		i++;
		return Double.parseDouble(eq.substring(i,j));
	}	
	public static double solve(String eq)
	{
		for(int i=0;i<eq.length();i++)
			if(eq.charAt(i)=='^')
			{
				if(eq.charAt(i-1)==')')
					search opening brace....
				else
				{
					double db=numdetect(eq,i);
					Math.pow(
			}
		
		
		
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String foo = "4^6";
		System.out.println(engine.eval(foo));
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner src=new Scanner(System.in);
		String eq=src.nextLine();
		solve(eq);
		
    } 
}