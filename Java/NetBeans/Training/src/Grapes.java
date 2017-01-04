
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://www.codechef.com/problems/COMM3
//Shameful Series: 8
class Grapes {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        
        while (t-- > 0) {
            String s[] = br.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            long k = Long.parseLong(s[1]);
            //in.nextLine();
            
            long a[] = new long[(int)n];
            
            s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(s[i]);
            }
            long sum = 0;
            for (long x : a) {
                long down = k * (x / k);
                long up = k * (1 + x / k);
                if(!(0 <= x && x <= 1000000000))
                    continue;
                //sum+=Math.min(x-down,up-x);
                sum += Math.min(x % k, k - x % k);
            }
            System.out.println(sum);

        }
    }
}