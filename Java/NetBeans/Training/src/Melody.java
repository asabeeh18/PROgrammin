import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Melody {
    static char v[]={'a','e','i','o','u'};
    static char c[]={'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','z'};
    static int n;
    static void vowel(int i,char s[])
    {
        if(i==n)
        {
            System.out.println(s);
            return;
        }
        for(char r:v)
        {
            s[i]=r;
            cons(i+1,s);
        }
    }
    static void cons(int i,char s[])
    {
        if(i==n)
        {
            System.out.println(s);
            return;
        }
        for(char r:c)
        {
            s[i]=r;
            vowel(i+1,s);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        char s[]=new char[n];
        vowel(0,s);
        cons(0,s);
    }
}
