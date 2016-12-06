//https://www.hackerrank.com/contests/101hack40/challenges/designer-pdf-viewer
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WordSelect {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=26;
        int h[] = new int[n];
        for(int i=0; i < n; i++){
            h[i] = in.nextInt();
        }
        String s = in.next();
        int maxH=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++)
        {
            if(h[((int)s.charAt(i)-(int)'a')]>maxH)
                maxH=h[((int)s.charAt(i)-(int)'a')];
        }
        System.out.println(s.length()*maxH);
    }
}
