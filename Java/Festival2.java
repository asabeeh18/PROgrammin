import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Festival2 {

    BufferedReader r;
    boolean[] fest;
    int[][] grid;
	int[] dist;
    class City 
    {
        int id, dist;
        public City(int id, int dist)
        {
            this.id = id;
            this.dist = dist;
        }
    }

    public Festival2(BufferedReader r)
    {
        this.r = r;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        new Festival2(r).inputAndProcess();
    }

    public void inputAndProcess() throws IOException
    {
        String[] inputString = r.readLine().split(" ");
        int a, b;
        int n = Integer.parseInt(inputString[0]);
        int q = Integer.parseInt(inputString[1]);
		
        grid = createGrid(n - 1);
        fest = new boolean[n + 1];
        dist=new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		//start PROCESS >.>
        fest[1] = true;
        while (q-- > 0)
        {
            inputString=r.readLine().split(" ");
            a = Integer.parseInt(inputString[0]);
            b = Integer.parseInt(inputString[1]);
            if (a == 1)
            {
				bfs(b);
                //fest[b] = true;
            } 
            else
            {
                //start bfs with b.
                System.out.println(dist[b]);
            }
        }
    }

    public int bfs(int b)
    {
        ArrayDeque<City> cityQueue = new ArrayDeque<>();

        boolean[] visited = new boolean[grid.length];
        City put = new City(b, 0);
        cityQueue.add(put);
        while (!cityQueue.isEmpty())
        {
            City city = cityQueue.remove();
            
			dist[city.id]=city.dist;
            
            /*
			//Found!!
			if (fest[city.id])
            {
                return city.dist;
            }
			*/
            //Q neighbours
			
            for (int adj : grid[city.id])
            {
                if (visited[adj])
                {
                    continue;
                }
				visited[adj] = true;
				if(dist[adj]<=city.dist+1)
					continue;
				
                cityQueue.add(new City(adj, city.dist + 1));
            }
        }
        return -1;
    }

    public int[][] createGrid(int n) throws IOException
    {
        int cityA, cityB;
        int edge[][] = new int[n + 1][2];
        int graph[][] = new int[n + 2][];
        int[] neighbourCount = new int[n + 2];
        for (int i = 1; i <= n; i++)
        {
            String s[]=r.readLine().split(" ");
            cityA =Integer.parseInt(s[0]);
            cityB =Integer.parseInt(s[1]);
			if(cityA==cityB)    //havent mentioned anything like this
              continue;
            neighbourCount[cityA]++;
            neighbourCount[cityB]++;
            edge[i][0] = cityA;
            edge[i][1] = cityB;
        }
        for (int i = 1; i < neighbourCount.length; i++)
        {
            graph[i] = new int[neighbourCount[i]];
        }
        neighbourCount = new int[n + 2];
        for (int i = 1; i < edge.length; i++)
        {
            cityA = edge[i][0];
            cityB = edge[i][1];
            graph[cityA][neighbourCount[cityA]++] = cityB;
            graph[cityB][neighbourCount[cityB]++] = cityA;
        }
        return graph;
    }
}