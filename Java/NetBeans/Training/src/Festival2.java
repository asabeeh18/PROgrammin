import com.sun.javafx.scene.control.skin.AccordionSkin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

class Festival2 {

    BufferedReader r;
    boolean[] fest;
    int[][] grid;
	int[] dist;
    

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
        //fest[1] = true;
        bfs(1);
        while (q-- > 0)
        {
            //inputString=r.readLine().split(" ");
            a =q%2==0?1:2; //Integer.parseInt(inputString[0]);
            b = q+1;//Integer.parseInt(inputString[1]);
            if (a == 1)
            {
                try{
				bfs(b);
                }
                catch(NullPointerException e)
                {
                    System.out.println(a+":"+b+"\n");
                    e.printStackTrace();
                }
                //fest[b] = true;
            } 
            else
            {
                ;
                //start bfs with b.
                //System.out.println(dist[b]);
            }
        }
        System.out.println("EXIT");
    }

    public int bfs(int b)
    {
        ArrayDeque<Integer> cityQueue = new ArrayDeque<>();

        boolean[] visited = new boolean[grid.length];
        int dis[]=new int[dist.length];
        dis[b]=0;
        cityQueue.add(b);
        while (!cityQueue.isEmpty())
        {
            int city = cityQueue.remove();
            
			dist[city]=dis[city];
            
            /*
			//Found!!
			if (fest[city.id])
            {
                return city.dist;
            }
			*/
            //Q neighbours
			
            for (int adj : grid[city])
            {
                if (visited[adj])
                {
                    continue;
                }
				visited[adj] = true;
				if(dist[adj]<=dis[city]+1)
					continue;
				
                cityQueue.add(adj);
                dis[city]++;
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
            //String s[]=r.readLine().split(" ");
            cityA =i;//Integer.parseInt(s[0]);
            cityB =i+1;//Integer.parseInt(s[1]);
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