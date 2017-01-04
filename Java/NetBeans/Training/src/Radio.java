
import java.util.*;

public class Radio {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int x_i = 0; x_i < n; x_i++)
        {
            x[x_i] = in.nextInt();
        }
        
        Arrays.sort(x);
        
        int t = k, count = 0;//t is remaining length of radius count is no. of transmitters
        for (int i = 0; i < n; i++)
        {
            //for the last iteration
            if (i >= n - 1)
            {
                
                count++;
                continue;
            }
            
            //if remaining radio length can acoomodate next house
            if (t >= x[i + 1] - x[i])
            {
                //update remaining length
                t = t - (x[i + 1] - x[i]);
            } else
            {
                //else remaining length is 0 or next house cannot be accomodated, reset and inc transmitter
                t = k;
                count++;
                int j = i + 1;
                //the other side of transmitter
                while (j < n && (k >= x[j] - x[i]))
                {
                    j++;
                }
                //cause now we have to analuse from hosue j
                i = j - 1;
            }
        }
        System.out.println(count);
    }
}
