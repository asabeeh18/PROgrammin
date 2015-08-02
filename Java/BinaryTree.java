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
    public static void main(String ar[])
    {
		char[] pre=r.readLine().toCharArray();
		BTnode root = new BTnode(pre[0]);
		createChild(root);
    }
	createChild(BTnode root)
	{
		BTnode node=new BTnode(pre[i++]);
		
			
		root.left=node;
		root.left.parent=root;
		if(node.oper) 
			createChild(root.left);
		if(root.data!='N')	//ONLY one child node 
		{
			node=new BTnode(pre[i++]);
			root.right=node;
			root.right.parent=root;
			if(node.oper)
				createChild(root.right);
		}
	}
}