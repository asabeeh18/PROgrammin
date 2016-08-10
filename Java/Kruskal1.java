import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Kruskal {
//src dest and weight
	class Edge
	{
		int src,dest,weight;
		public Edge(int src,int dest,int weight)
		{
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
		@Override
		public String toString()
		{
			return weight+"";
		}
	}
	public static void main(String ar[])
	{
		new Kruskal().kruskal();
	}
	public void kruskal()
	{
		Scanner r=new Scanner(System.in);
		System.out.println("number of edges");
		int n=r.nextInt();
		Edge[] e=new Edge[n];
		while(n-->0)
		{
			e[n]=new Edge(r.nextInt(),r.nextInt(),r.nextInt());
		}
		//sort in increasing
		Arrays.sort(e, new Comparator<Edge>(){
			public int compare(Edge a,Edge b)
			{
				return a.weight-b.weight;
			}
		});
		System.out.println(Arrays.deepToString(e));
	}
}
