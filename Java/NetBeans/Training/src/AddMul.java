//http://www.codechef.com/JULY15/problems/ADDMUL
import java.util.*;
class AddMul
{
	static int qs,qe,n,v;
	static int[] st,add,mul;
	static int getMid(int s, int e) {  return s + (e -s)/2;  }
	
	static void lazyAdd()
	{
		// Check for erroneous input values
		if (qs < 0 || qe > n-1 || qs > qe)
		{
			System.out.println("Invalid Input");
		}
		
		st[0]=st[0]+lazyAddUtil( 0, n-1, 0);
	}
	
	static int lazyAddUtil( int ss, int se, int index)
	{
		if (qs <= ss && qe >= se)
                {
                    add[index]=0;
                    st[index]+=v*(se-ss+1);
                    return st[index/2]+v*(se-ss+1);
                }
		
		// If segment of this node is outside the given range
		if (se < qs || ss > qe)
        return 0;
		
		// If a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		st[index]=lazyAddUtil( ss, mid, 2*index+1)+
		lazyAddUtil(mid+1, se, 2*index+2);
		return st[index];
	}
	
	
	static int getSumUtil( int ss, int se, int index)
	{
		if (qs <= ss && qe >= se)
        return st[index];//+add[index];
		
		/* 
		if(mul[index]!=1)
		{	mul[2*index+1]=mul[index];
		mul[2*index+2]=mul[index];
		mul[index]=1;
		}
		 */
		 
		// If segment of this node is outside the given range
		if (se < qs || ss > qe)
        return 0;
		if(add[index]!=0)
		{
			//st[index]=st[index]+add[index]*(se-ss+1);
			add[2*index+1]=add[index];
			add[2*index+2]=add[index];
			add[index]=0;
		}
		// If a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		return getSumUtil( ss, mid, 2*index+1) +
		getSumUtil(mid+1, se, 2*index+2);
	}
	
	static int getSum()
	{
		// Check for erroneous input values
		if (qs < 0 || qe > n-1 || qs > qe)
		{
			System.out.println("Invalid Input");
			return -1;
		}
		
		return getSumUtil( 0, n-1, 0);
	}
	
	static int constructSTUtil(int arr[], int ss, int se, int si)
	{
		// If there is one element in array, store it in current node of
		// segment tree and return
		if (ss == se)
		{
			st[si] = arr[ss];
			return arr[ss];
		}
		
		// If there are more than one elements, then recur for left and
		// right subtrees and store the sum of values in this node
		int mid = getMid(ss, se);
		st[si] =  constructSTUtil(arr, ss, mid, si*2+1) +
		constructSTUtil(arr, mid+1, se, si*2+2);
		return st[si];
	}
	

	static void constructST(int arr[])
	{
		// Allocate memory for segment tree
		int x = (int)(Math.ceil(Math.log(n)/Math.log(2))); //Height of segment tree
		int max_size = 2*(int)Math.pow(2, x) - 1; //Maximum size of segment tree
		st = new int[max_size];
		add= new int[max_size];
		mul= new int[max_size];
		Arrays.fill(mul,1);
		// Fill the allocated memory st
		constructSTUtil(arr, 0, n-1, 0);
		
		// Return the constructed segment tree
		
	}
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		n=r.nextInt();
		int q=r.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=r.nextInt();
		constructST(arr);
		int ch; //x,y is qs qe
		while(q-->0)
		{
			ch=r.nextInt();
			qs=r.nextInt();
			qe=r.nextInt();
			if(ch==1)
			{
				v=r.nextInt();
				lazyAdd();
			}
			else if(ch==2)
			{
				v=r.nextInt();
				//lazyMul();
				//also mul d num in lasyadd tree
			}
			else if(ch==3)
			{
				//lazyMul(0);
				v=r.nextInt();
				lazyAdd();
			}
			else if(ch==4)
			{
				System.out.println(getSum());
			}
		}
	}
}