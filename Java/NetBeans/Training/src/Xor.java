
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Map.Entry;
import java.util.regex.*;

public class Xor
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        int[] x = new int[n];
        long c = 0;
        for (int s_i = 0; s_i < n; s_i++)
        {
            s[s_i] = in.nextInt();
            if (s_i == 0)
            {
                x[s_i] = s[s_i];
            } else
            {
                x[s_i] = x[s_i - 1] ^ s[s_i];
            }
        }
        // It is a losing position for the player whose turn it is if and only if n1 xor n2 xor .. xor nk = 0.
        for (int i = 0; i < n; i++)
        {
            x[i] = x[i] ^ x[n - 1];
        }
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (h.containsKey(x[i]))
            {
                int v = h.get(x[i]);
                h.put(x[i], v++);
            }
            else
            {
                h.put(x[i],1);
            }
        }
        for(Entry<Integer, Integer> e : h.entrySet()) 
        {
            int key = e.getKey();
            int v = e.getValue();
            c+=(v*(v-1)/2);
//            if(key==0)
//                c+=v;
        }
        for(int i:s)
        {
            if((i^x[n-1])==0)
                c++;
        }
        System.out.println(c);
        // Print the number of ways Alice can select the range to ensure she wins the game.
    }
}
