import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Iterator;
class TIC
{
        City[] c;
	class City
	{
		ArrayList<Integer> adj=new ArrayList<>();
		boolean fest=false;
	}
        
	public static void main(String ar[])
	{
		
                TIC tic=new TIC();
		tic.everythin();
	}
        public void everythin()
        {
                Scanner r=new Scanner(System.in);
                int n,m;
		n=r.nextInt();
		m=r.nextInt();
		c=new City[n+1];
                for(int i=0;i<c.length;i++)
                {
                    c[i]=new City();
                }
		for(int i=1;i<n;i++)
		{
                        int a=r.nextInt();
                        int b=r.nextInt();
			c[a].adj.add(b);
                        c[b].adj.add(a);
		}
                System.out.println("Input Done");
                c[1].fest=true;
                for(int i=0;i<m;i++)
                {
                    if(r.nextInt()==1)
                    {
                        c[r.nextInt()].fest=true;
                    }
                    else
                    {
                        System.out.println(bfs(r.nextInt()));
                    }
                }
        }
        class NewCity
        {
            int dist=0;
            int n;
        }
        public int bfs(int a)
        {
            ArrayDeque<NewCity> q=new ArrayDeque<>();
            NewCity now=new NewCity();
            now.dist=0;
            now.n=a;
            q.add(now);
            while(!q.isEmpty())
            {
                NewCity cur=q.remove();
                
                if(c[cur.n].fest)
                    return cur.dist;
                Iterator<Integer> tor=c[cur.n].adj.iterator();
                while(tor.hasNext())
                {
                    NewCity ins=new NewCity();
                    ins.n=tor.next();
                    if(cur.n==ins.n)
                        continue;
                    ins.dist=cur.dist+1;
                    q.add(ins);
                }
            }
            return -1;
        }
}