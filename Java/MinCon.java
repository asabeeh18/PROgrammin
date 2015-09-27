
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
            t = x;
            x = y;
            y = t;
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
        while (q-- > 0)
        {
            s=r.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            //if(s==0)
            merge(x, y);
            if (max[min] == 0 || min == 0)
            {
				for(int i=1;i<=n;i++)
				{
					if(max[i]!=0)
						min=i;
				}
                for (int i = min+1; i <= n; i++)
                {
                    if (max[i] != 0 && max[min] > max[i])
                    {
                        min = i;
                    }
                }
            }
            System.out.println(max[min]);
        }
        //System.out.println("|");
    }

	//===HEAP-=====
	private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int FRONT = 1;
	
		maxsize=n;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
 
    private int parent(int pos)
    {
        return pos / 2;
    }
 
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
        { 
            return true;
        }
        return false;
    }
 
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    private void minHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( Heap[pos] > Heap[leftChild(pos)]  || Heap[pos] > Heap[rightChild(pos)])
            {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
 
    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }	
    }
 
    public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i] 
                + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        } 
    }
 
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            minHeapify(pos);
        }
    }
 
    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; 
        minHeapify(FRONT);
        return popped;
    }
 
}
