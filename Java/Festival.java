import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Festival
{
	BufferedReader r;
	//int[] ;
	boolean[] fest;
	int[][] grid;
        class City
        {
            int id,dist;
            public City(int id,int dist)
            {
                this.id=id;
                this.dist=dist;
            }
            public City()
            {
            }
        }
	public static void main(String args[]) throws IOException
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		new Festival(r).inputAndProcess();
	}
	public Festival(BufferedReader r)
	{
		this.r=r;
	}
	public void inputAndProcess() throws IOException
	{
		String s[]=r.readLine().split(" ");
		int a,b;
		int n=Integer.parseInt(s[0]);
		int q=Integer.parseInt(s[1]);
		grid=createGrid(n-1);
		
		fest=new boolean[n+1];
		
		//start PROCESS >.>
		fest[1]=true;
		while(q-->0)
		{
			s=r.readLine().split(" ");
			a=Integer.parseInt(s[0]);
			b=Integer.parseInt(s[1]);
			if(a==1)
			fest[b]=true;
			else
			{
                            //start bfs with b.
                            System.out.println(bfs(b));
			}
		}
	}
	public int bfs(int b)
	{
		ArrayDeque<City> q=new ArrayDeque<>();
		City put=new City();
                boolean[] visited=new boolean[grid.length];
                
		put.dist=0;
		put.id=b;
		q.add(put);
		while(!q.isEmpty())
		{
			City city=q.remove();
                        visited[city.id]=true;
                        
			//Found!!
			if(fest[city.id])
                            return city.dist;
			//Q neighbours
			for(int adj: grid[city.id])
			{
				if(visited[adj])
                                    continue;
				q.add(new City(adj,city.dist+1));
			}
		}
                return -1;
	}
	public int[][] createGrid(int n) throws IOException
	{
		int a,b;
		int edge[][]=new int[n+1][2];
		int graph[][]=new int[n+2][];
		int ctr[]=new int[n+2];
		for(int i=1;i<=n;i++)
		{
			String s[]=r.readLine().split(" ");
			a=Integer.parseInt(s[0]);
			b=Integer.parseInt(s[1]);
			if(a==b)
                            continue;
			ctr[a]++;
			ctr[b]++;
			edge[i][0]=a;
			edge[i][1]=b;
		}
		for(int i=1;i<ctr.length;i++)
		{
			graph[i]=new int[ctr[i]];
		}
	ctr=new int[n+2];
	for(int i=1;i<edge.length;i++)
	{
		a=edge[i][0];
		b=edge[i][1];
		graph[a][ctr[a]++]=b;
		graph[b][ctr[b]++]=a;
	}
	return graph;
	}	
}