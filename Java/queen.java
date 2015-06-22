//Queen Problem
import java.util.*;
class Queen
{
        static int col[]=new int[8];
        static Scanner src=new Scanner(System.in);
    static void fill(int a,int b,int chess[][])
    {
        col[a]=-1;
        for(int i=0;i<8;i++)    //Hz and VT
        {
            if(a!=i && chess[a][i]!=1)
				chess[a][i]-=1;
				
            if(b!=i && chess[i][b]!=1;)
                chess[i][b]-=1;
        }
        //Diagonal
        int x=a-1,y=b-1;
        while(x>0 && y>0)  
            chess[--x][--y]-=1;
        x=a;
        y=b;
        while(x<7 && y<7)  
            chess[++x][++y]-=1; 
    }
    static void unfill(int r,int c,int chess[][])
    {   
        col[c]=0;
        for(int i=0;i<8;i++)
        {
            if(i!=c)    
                chess[i][c]+=1;
            if(i!=r)
                chess[r][i]+=1;
        }   
        //Diagonal
        int a=r;
        int b=c;
        while(a>0&&b>0) 
            chess[--a][--b]+=1;
        a=r;
        b=c;
        while(a<7 && b<7)  
            chess[++a][++b]+=1; 
    }
    static int inserter(int i,int r,int chess[][])
    {
        for(int j=r;j<8;j++)
            if(chess[j][i]==0)
            {
                chess[j][i]=1;
                fill(j,i,chess);
                return j;
            }   
        return -1;  
    }       
    static int solv7(int i,int r,int chess[][])
    {
        int j;
        if(i==8)
            return 99;  //World at peace
        if(col[i]==-1)// 1 such case(1st case only)
            j=8;    //solv7(i+1,0);
        else
            j=inserter(i,r,chess);
        if(j==-1)   //NOn insertion Column GO BACK!
            return -1; 
        else    //inserted normally
        {
            int v=solv7(i+1,0,chess);
            if(v==-1)
            {
                unfill(j,i,chess);
                v=solv7(i,r+1,chess);
                if(v==-1)
                    return -1;
                else return 0;  //<-----------------I LEFT HERE!
            }   
        }
        return 1;
        
    }   
        
    public static void main(String args[])
    {
        //0=MOVABLE -1=NON-MOVABLE 1=QUEEN
        int chess[][]=new int [8][8];//initially all 0
    
    
        System.out.println("Enter x,y co-ords of initial Queen poz");
        int x=src.nextInt();
        int y=src.nextInt();
        chess[x][y]=1;
        fill(x,y,chess);
        //Real Program Starts
        solv7(0,0,chess);
		//print check
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(chess[i][j]>0)
					System.out.print("Q ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}	
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(chess[i][j]>0)
					System.out.print(i+"+"+j+"  ");	
    }
}	