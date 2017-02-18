/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes

import java.util.*;
import java.math.BigInteger;
class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        */
        Scanner r = new Scanner(System.in);
        int t = r.nextInt();
        r.nextLine();
        while(t-->0)
        {
            BigInteger a=new BigInteger(r.nextLine());
            BigInteger b=new BigInteger(r.nextLine());
            System.out.println(a);
            System.out.println(b);
            System.out.println(a.add(b));
        }
        //System.out.println("Hello World!");
    }
}
