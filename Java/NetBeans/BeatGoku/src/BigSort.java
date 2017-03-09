import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigSort {
        String[] te={"sd","sd"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        Arrays.sort(unsorted,new Comparator<String>(){
    @Override
    public int compare(String x, String y) {
        if(x.length()<y.length())
            return -1;
        else if(x.length()>y.length())
            return 1;
        return x.compareTo(y);
    }
});
        for(String i:unsorted)
            {
            System.out.println(i);
        }
        // your code goes here
    }
}
