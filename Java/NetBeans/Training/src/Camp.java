import java.util.*;
class Camp
{
	static int inf=9999999;
	static boolean visited[][];
	static int cur_per;
	static int di,dj;
        static int status=0;
	public static void main(String ar[])
	{
        //int x=Integer.parseInt("123.43");
        Stack<Stack<Stack>> s=new Stack<>();
        s.add(s);
        
//this becomes a mess?
        System.out.println(s.peek().peek().size()+"");
        Scanner r=new Scanner(System.in);
		int h=r.nextInt();
		int w=r.nextInt();
		r.nextLine();
		visited=new boolean[h][w];
		char ip[];
		int p=-1;
		char[][] grid=new char[h][w];
		int[][] person=new int[3][2];
		for(int i=0;i<h;i++)
		{
			
			ip=(r.nextLine()).toCharArray();
			for(int j=0;j<2*w;j+=2)
			{
				if(ip[j]=='s')
				{
					person[++p][0]=i;
					person[p][1]=j/2;
					grid[i][j/2]='-'; //- is open
				}
				else if(ip[j]=='w')
				{
					grid[i][j/2]='w'; //w is close
				}
				else if(ip[j]=='d')
				{
					grid[i][j/2]='d'; //destination;
					di=i;
					dj=j/2;
				}
				else if(ip[j]=='-')
				{
					grid[i][j/2]='-';
				}
			}
			
		}
                int useless=r.nextInt();
		//IP DONE
                char[][] copy_grid=new char[h][w];
                
		for(int i=0;i<=p;i++)
		{
			cur_per=i;
                         clean(copy_grid,grid);
			bfs(copy_grid,person[i][0],person[i][1]);
                        System.out.println();
		}
		printGrid(grid);
	}
	public static void bfs(char[][] grid,int i,int j)
	{
		if(i>=grid.length || j>=grid[0].length || i<0 || j<0)
			return;
		
		if(visited[i][j])
			return;
		visited[i][j]=true;
		grid[i][j]=(char)(cur_per+97);
		int heu_now=heu(i,j,grid);
		if(heu_now==0)
		{
                        grid[i][j]='d';
			printGrid(grid);
                        status=1;
                        return;
		}
		int a[]=new int[8];
		//CAlc heu
		a[0]=heu(i-1,j,grid);
		a[1]=heu(i+1,j,grid);
		a[2]=heu(i,j+1,grid);
		a[3]=heu(i,j-1,grid);
		a[4]=heu(i+1,j+1,grid);
		a[5]=heu(i-1,j-1,grid);
		a[6]=heu(i-1,j+1,grid);
		a[7]=heu(i+1,j-1,grid);
		boolean av[]=new boolean[8];
		//Arrays.sort(a);
		for(int k=0;k<8;k++)
		{
			k=min(a);
			if(!av[k])
			{
				//max(a);
                                a[k]=inf;
				switch(k)
				{
					case 0: bfs(grid,i-1,j);
							av[i]=true;
							break;
					case 1: bfs(grid,i+1,j);
							av[i]=true;
							break;
					case 2: bfs(grid,i,j+1);
							av[i]=true;
							break;
					case 3: bfs(grid,i,j-1);
							av[i]=true;
							break;
					case 4: bfs(grid,i+1,j+1);
							av[i]=true;
							break;
					case 5: bfs(grid,i-1,j-1);
							av[i]=true;
							break;
					case 6: bfs(grid,i-1,j+1);
							av[i]=true;
							break;
					case 7: bfs(grid,i+1,j-1);
							av[i]=true;
							break;
				}
                         }
                        
                                if(status==1)
                                    return;
		}
		grid[i][j]='-';
              
	}
	public static void printGrid(char[][] grid)
	{
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean allAv(boolean a[])
	{
		for(int i=0;i<a.length;i++)
			if(!a[i])
				return true;
		return false;
	}
	public static int heu(int i,int j,char[][] grid)
	{
		if(i>=grid.length || j>=grid[0].length || i<0 || j<0)
			return inf;
		if(grid[i][j]=='w')
			return inf;
		return Math.abs(i-di) + Math.abs(j-dj);
	}
        public static int min(int[] a)
        {
            int min=0;
            for(int i=1;i<a.length;i++)
            {
                if(a[i]<a[min])
                    min=i;
            }
            return min;
        }
        public static void clean(char copy[][],char grid[][])
        {
            for(int i=0;i<grid.length;i++)
            System.arraycopy(grid[i],0,copy[i],0,grid[0].length);
            for(int i=0;i<visited.length;i++)
            {
                for(int j=0;j<visited[0].length;j++)
                    visited[i][j]=false;
            }
            status=0;
        }
}