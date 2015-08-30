import java.util.*;

class EightPuzzle
{
	public static final int BOUND=10;
        public static int heuristic(int[][] box)
        {
            //int[][] data={{1,2,3},{8,-1,4},{7,6,5}};
            int[][] poz={{0,0},{0,0},{0,1},{0,2},{1,2},{2,2},{2,1},{2,0},{1,0}};
            int m=0;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                    if(box[i][j]!=-1)
                        m+=Math.abs(poz[box[i][j]][0]-i) + Math.abs(poz[box[i][j]][1]-j);
            }
            return m;
        }
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int[][][] box=new int[7][3][3];
		System.out.println("Enter Matrix -1 For blank ");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				box[0][i][j]=r.nextInt();
			}
		}
		//print(box[0]);					
		backtracker(box,0);
	}
	public static void print(int[][] data)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				System.out.print(data[i][j]+" ");
			System.out.println();
		}
	}
        public static int[][] mxCopy(int[][] box)
        {
            int[][] data=new int[3][3];
            for(int i=0;i<3;i++)
                    System.arraycopy(box[i],0,data[i],0,3);
               return data;
        }
	public static void backtracker(int[][][] box,int depth)
	{
		int[][] data;//=new int[3][3];
                        //box[depth];
                data=mxCopy(box[depth]);
                int h=heuristic(data);
                System.out.println("-----");
                print(data);
                if(lastState(data))
		{
			//print(data);
                        System.out.println("EQUAL!!!!!!");
                        System.exit(0);
			return;
		}
		if(member(data,box,depth-1))
		{
                        System.out.println("Discard above state: Already done");
			return;
		}
		
		if(depth>BOUND)
		{
                        System.out.println("Discard above state: BOUND EXCEEDED");
			return;
		}
		/*
		10 0,0  30 0,2 
		20 0,1  21 1,1 31 1,2 
		30 0,2
		12 22 32
                * 2 3 -1
                * 1 6 4
                * 8 7 5
		*/
		while(true)
                {
		int space=findSpace(data);
		if(space!=10 && space!=20 && space!=30)
		{
                        
			//box[depth+1]=up(data,space);
                        box[depth+1]=mxCopy(up(data,space));
                        if(heuristic(data)<h)
                            backtracker(box,depth+1);
                        else
                        {
                            space=findSpace(data);
                            down(data,space);
                        }
                     
		}
                space=findSpace(data);
		if(space!=12 && space!=22 && space!=32)
		{
                        
                      box[depth+1]=mxCopy(down(data,space));
			if(heuristic(data)<h)
                            backtracker(box,depth+1);
                        else
                        {
                            space=findSpace(data);
                            up(data,space);
                        }
                            
                        
                       
			
		}
                space=findSpace(data);
		if(space!=10 && space!=11 && space!=12)
		{
                        
			box[depth+1]=mxCopy(left(data,space));
                        if(heuristic(data)<h)
                            backtracker(box,depth+1);
                        else
                        {
                            space=findSpace(data);
                            right(data,space);
                        }    
                            
                        
                        
		}
                space=findSpace(data);
		if(space!=30 && space!=31 && space!=32)
		{
                        
			box[depth+1]=mxCopy(right(data,space));
                        if(heuristic(data)<h)
                            backtracker(box,depth+1);
                        else
                        {
                            space=findSpace(data);
                            left(data,space);
                        
                        }
                        
		}
                }
		
	}
	static boolean lastState(int box[][])
	{
		int[][] data={{1,2,3},{8,-1,4},{7,6,5}};
		if(isEqual(box,data))
			return true;
		return false;
	}
	static boolean member(int[][] data,int box[][][],int depth)
	{
		for(int i=0;i<depth;i++)
		{
			if(isEqual(data,box[i]))
				return true;
		}
		return false;
	}
	static boolean isEqual(int[][] data,int[][] box)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
				if(data[i][j]!=box[i][j])
					return false;
		}
		return true;
	}
	public static int findSpace(int[][] box)
	{
		//10 0,0 0 20 0,1 30 0,2 11 1,0 21 1,1 31 1,2 12 22 32
		//rows 0 1 2 then cols 10 20 30
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(box[i][j]==-1)
					return i+(j+1)*10;
		return -1;
	}
	//rules..Moves space
	public static int[][] up(int[][] box,int space)
	{
		int a=space%10;
		int b=(space-10)/10;
		box[a][b]=box[a-1][b];
		box[a-1][b]=-1;
		return box;
	}
	public static int[][] down(int[][] box,int space)
	{
		int a=space%10;
		int b=(space-10)/10;
		box[a][b]=box[a+1][b];
		box[a+1][b]=-1;
		return box;
	}
	public static int[][] left(int[][] box,int space)
	{
		int a=space%10;
		int b=(space-10)/10;
		box[a][b]=box[a][b-1];
		box[a][b-1]=-1;
		return box;
	}
	public static int[][] right(int[][] box,int space)
	{
		int a=space%10;
		int b=(space-10)/10;
		box[a][b]=box[a][b+1];
		box[a][b+1]=-1;
		return box;
	}
	
	
}