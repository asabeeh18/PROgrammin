//http://www.codechef.com/problems/TAUT
public class BTnode
{
    public BTnode left=null;
    public BTnode right=null;
	public BTnode parent=null;
    public int data;
	public boolean oper;
    public BTnode(int data,boolean oper)
    {
        this.data=data;
		this.oper=oper;
    }
	public BTnode(int data)
    {
        this.data=data;
		if(data<'a')
			oper=true;
    }
    public void getNode()
    {
        return data;
    }
}
class Solution
{
	int q=0;
	BTnode leftmost;
    public static void main(String ar[])
    {
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
			char[] pre=r.readLine().toCharArray();
			BTnode root = new BTnode(pre[q++]);
			createChild(root);
		}
		/*
		C - and 
		D - or
		I - implies
		E - if, and only if
		N - not
		*/
		D
	   /\
	  a  N
	     /
		a
		
		
		
		C
	   T T
	   
	   !I
	   F T
	   
	   
    }
	public static void createChild(BTnode root)
	{
		BTnode node=new BTnode(pre[q++]);
		
			
		root.left=node;
		root.left.parent=root;
		leftmost=root.left;
		if(node.oper) 
			createChild(root.left);
		if(root.data!='N')
		{
			node=new BTnode(pre[q++]);
			root.right=node;
			root.right.parent=root;
			if(node.oper)
				createChild(root.right);
		}
	}
}