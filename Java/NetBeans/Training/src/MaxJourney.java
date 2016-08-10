
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MaxJourney {

    static int mDist[];
    //High Recoil
    static ArrayList<Set<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    Set<Integer> ids = new HashSet<>();

    private static City dfsWooHoo(HashMap<Integer, Set> child, City origin, int dad)
    {
        visited[dad] = true;
        City du = new City(origin.id, origin.dist);
        City dd = new City(dad, 0), d;
        Iterator<Integer> id = child.get(dad).iterator();
        while (id.hasNext())
        {

            int nx = id.next();
            if (visited[nx])
            {
                continue;
            }
            d = dfsWooHoo(child, new City(origin.id, origin.dist + 1), nx);
            if (d.dist > dd.dist)
            {
                Set<Integer> temp = new HashSet<>();
                temp.add(d.id);
                list.add(dad, temp);
                dd = d;
            } else if (dd.dist == d.dist)
            {
                Set<Integer> temp = list.get(dad);
                temp.add(d.id);
                list.add(dad, temp);
            }
        }
        if (du.dist > dd.dist)
        {
            Set<Integer> temp = new HashSet<>();
            temp.add(du.id);
            list.add(dad, temp);
        } else if (du.dist == dd.dist)
        {
            Set<Integer> temp = list.get(dad);
            temp.add(du.id);
            list.add(dad, temp);
        }
        d.dist++;
        return d;
    }

    static class City {

        int id = 0, dist = 0;

        City(int id, int dist)
        {
            this.id = id;
            this.dist = dist;
        }
    }

    public static void main(String ar[]) throws IOException
    {
        int x, y;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String[] s = (r.readLine()).split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        visited = new boolean[n + 1];
        HashMap<Integer, Set> child = new HashMap<>();

        for (int i = 1; i < n; i++)
        {
            s = (r.readLine()).split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            adder(child, x, y);
            adder(child, y, x);
        }
        //Preprocess
        City now = new City(1, 0);
        visited[1] = true;
        dfsWooHoo(child, now, 1);

        int v, k;
        for (int i = 0; i < m; i++)
        {
            s = (r.readLine()).split(" ");
            v = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);

        }
    }

    static void adder(HashMap<Integer, Set> child, int x, int y)
    {
        Set<Integer> id = new HashSet<>();
        if (child.containsKey(x))
        {
            id = child.get(x);
            if (id.add(y))
            {
                child.put(x, id);
            }
        } else
        {
            id.add(y);
            child.put(x, id);
        }
    }
}
