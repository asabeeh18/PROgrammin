
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class LaLiga
{

    public static void main(String[] args) throws Exception
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        HashMap<String, Integer> h = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            String s[] = r.readLine().split(" ");
            int a = Integer.parseInt(s[1]), b = Integer.parseInt(s[3]);
            if (a > b)
            {
                if (h.containsKey(s[0]))
                {
                    h.put(s[0], h.get(s[0]) + 3);
                } else
                {
                    h.put(s[0], 3);
                }
                if (!h.containsKey(s[2]))
                {
                    h.put(s[2], 0);
                }
            } else if (a < b)
            {
                if (h.containsKey(s[2]))
                {
                    h.put(s[2], h.get(s[2]) + 3);
                } else
                {
                    h.put(s[2], 3);
                }
                if (!h.containsKey(s[0]))
                {
                    h.put(s[0], 0);
                }
            } else
            {
                if (h.containsKey(s[0]))
                {
                    h.put(s[0], h.get(s[0]) + 1);
                } else
                {
                    h.put(s[0], 1);
                }
                if (h.containsKey(s[2]))
                {
                    h.put(s[2], h.get(s[2]) + 1);
                } else
                {
                    h.put(s[2], 1);
                }
            }
        }

        //Copied
        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(h.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,Entry<String, Integer> o2)
            {
                int c=o2.getValue().compareTo(o1.getValue());
                if(c==0)
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return c;
            }
        });
        for (Entry<String, Integer> entry : list)
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
