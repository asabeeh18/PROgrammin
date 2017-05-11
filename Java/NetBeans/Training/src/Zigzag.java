import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Zigzag {

    static int check(ArrayList<Integer> a)
    {
        char ps='x',s='x';
        for(int i=0;i<a.size()-1;i++)
        {
            if(a.get(i)>a.get(i+1))
            {
                if(s=='l')
                {
                    return i+1;
                }
                else
                    s='l';
            }
            else if(a.get(i)<a.get(i+1))
            {
                if(s=='g')
                {
                    return i+1;
                }
                else
                    s='g';
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> a=new ArrayList<>();
        for(int a_i=0; a_i < n; a_i++){
            a.add(in.nextInt());
        }
        
        // Return the minimum number of elements to delete to make the array zigzag
        
        int x=-10;
        while(x!=-1)
        {
            x=check(a);
            if(x!=-1)
            {
                a.remove(x);    
            }
            System.out.println(a);
        }
        System.out.println(n-a.size());
    }
}
