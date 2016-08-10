import java.util.Scanner;
import java.util.Stack;
class BracketCorrect
{
    public static void main(String ar[])
    {
        Scanner r=new Scanner(System.in);
        System.out.println(""+correctIt(r.nextLine()));
    }
    public static String correctIt(String ss)
    {
        final char sopen='(',sclose=')',copen='{',cclose='}',qopen='[',qclose=']';
        String result="";
        Stack<Character> s=new Stack<>();
        for(int i=0;i<ss.length();i++)
        {
            
            char c=ss.charAt(i);
            if(c==sopen | c==qopen | c==copen)
            {
                s.push(c);
                result+=c;
            }
            else if(!s.isEmpty())
            {
                if(c==sclose)
                {
                    if(s.pop()==sopen)
                        result+=sclose;
                }
                if(c==cclose)
                {
                    if(s.pop()==copen)
                        result+=cclose;
                }
                if(c==qclose)
                {
                    if(s.pop()==qopen)
                        result+=qclose;
                }
            }
            
        }
        if(!s.isEmpty())           
        {
            while(!s.isEmpty())
            {
                char c=s.pop();
                if(c==sopen)
                {
                    result+=sclose;
                }
                if(c==copen)
                {
                    
                        result+=cclose;
                }
                if(c==qopen)
                {
                    
                        result+=qclose;
                }
            }
        }
        return result;
    }
}