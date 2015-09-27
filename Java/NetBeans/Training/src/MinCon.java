
import java.io.IOException;

//https://www.codechef.com/problems/CD1IT5

class MinCon {

    public static int[] a, rank, max;
    public static int min = 0;

    public static int find(int x, int w)
    {
        if (a[x] != x)
        {
            a[x] = find(a[x], w + max[x]);
            max[x] = 0;
        } else
        {
            max[x] += w;
        }
        //System.out.println(x);
        return a[x];
    }

    public static void merge(int x, int y)
    {
        int xx = find(x, 0), yy = find(y, 0);
        if (xx == yy)
        {
            return;
        }
        //System.out.println(yy+":"+xx);
        if (rank[xx] > rank[yy])
        {
            int t = xx;
            xx = yy;
            yy = t;
            
        }
        if (rank[xx] == rank[yy])
        {
            rank[yy]++;
        }
        a[xx] = yy;
        max[yy] += max[xx];
        max[xx] = 0;
        //System.out.println(yy+":"+a[xx]);
    }

    public static void main(String ar[])throws IOException
    {
        java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String s[]=r.readLine().split(" ");
        int n = Integer.parseInt(s[0]), q = Integer.parseInt(s[1]);
        a = new int[n + 1];
        rank = new int[n + 1];
        max = new int[n + 1];
        s=r.readLine().split(" ");
        for (int i = 1; i <= n; i++)
        {
            a[i] = i;
            max[i] = Integer.parseInt(s[i-1]);

        }
        int x, y;
        max[0] = Integer.MAX_VALUE;
        int min_old=0;
        while (q-- > 0)
        {
            s=r.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            //if(s==0)
            merge(x, y);
            
            if (max[min] == 0 || min == 0 || max[min]>min_old)
            {
				for(int i=1;i<=n;i++)
				{
					if(max[i]!=0)
                                        {
                                            min=i;
                                            break;
                                        }
				}
                for (int i = min+1; i <= n; i++)
                {
                    if (max[i] != 0 && max[min] > max[i])
                    {
                        min = i;
                    }
                }
            }
            min_old=max[min];
            
            System.out.println(max[min]);
        }
        //System.out.println("|");
    }
}
