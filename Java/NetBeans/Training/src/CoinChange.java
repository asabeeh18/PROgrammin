//https://www.hackerrank.com/challenges/ctci-coin-change
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange
{

    /**
     * duplicacy issues
    public static long makeChange(int[] coins, int money)
    {
        if (money < 0)
        {
            return 0;
        }

        if (makeV[money])
        {
            return make[money];
        }

        long sum = 0;
        for (int i : coins)
        {
            sum += makeChange(coins, money - i);
        }
        make[money] = sum;
        makeV[money] = true;
        return sum;
    }
    **/
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
    
        int coins[] = new int[m];
        long box[]=new long[n+1];
        for (int coins_i = 0; coins_i < m; coins_i++)
        {
            coins[coins_i] = in.nextInt();
        }
//        long make[];
//        boolean makeV[];  
        Arrays.sort(coins);
//
//        make = new long[n + 1];
//        makeV = new boolean[n + 1];
//        Arrays.fill(makeV, false);
//        make[0] = 1;
//        makeV[0] = true;
//        make[coins[0]] = 1;
//        makeV[coins[0]] = true;
        box[0]=1;
        for(int i=0;i<m;i++)
        {
            int coin=coins[i];
            for(int j=coin;j<=n;j++)
            {
                box[j]+=box[j-coin];
            }
        }
        System.out.println(box[n]);
    }
}
