import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.util.*;
class mop
{
	public static void main(String args[])throws Exception
	{
	ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String foo = "";
		System.out.println(engine.eval(foo));
	}
}	