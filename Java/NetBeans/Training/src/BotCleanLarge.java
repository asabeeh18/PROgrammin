import java.util.*;
public class BotCleanLarge
{
    static boolean visited[][];
    static int dimr,dimc;
    static ArrayDeque<Integer> dq=new ArrayDeque<>(); 
    static int bfsNearest(int r,int c,String[] board)
    {
        for(int i=0;i<visited[0].length;i++)
           Arrays.fill(visited[i],false);
        dq.clear();
        if(r!=0 && !visited[r-1][c])
             dq.add(((r-1)*100+c));
        if(c!=dimc && !visited[r][c+1])
            dq.add(r*100+c+1);
        if(r!=dimr && !visited[r+1][c])
            dq.add((r+1)*100+c);
        if(c!=0 && !visited[r][c-1])
            dq.add(r*100+c-1);
            
        while(!dq.isEmpty())
        {
            int a=dq.remove();
            r=a/100;
            c=a%100;
            visited[r][c]=true;
            if(board[r].charAt(c)=='d')
            {
               return a;
            }
            if(r!=0 && !visited[r-1][c])
                dq.add(((r-1)*100+c));
            if(c!=dimc && !visited[r][c+1])
                dq.add(r*100+c+1);
            if(r!=dimr && !visited[r+1][c])
                dq.add((r+1)*100+c);
            if(c!=0 && !visited[r][c-1])
                dq.add(r*100+c-1);
        }
        return -1; 
    }
    static void next_move(int posr, int posc, int dimh, int dimw,String[] board)
    {
        int a=bfsNearest(posr,posc,board);
        int r=a/100,c=a%100;
        if(board[posr].charAt(posc)=='d')
            System.out.println("CLEAN");
        else if(posr>r)
            System.out.println("UP");
        else if(posr<r)
            System.out.println("DOWN");
        else if(posc<c)
            System.out.println("RIGHT");
        else if(posc>c)
            System.out.println("LEFT");
    }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        int [] dim = new int[2];
        
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        visited=new boolean[dim[0]][dim[1]];
        dimr=dim[0]-1;
        dimc=dim[1]-1;
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}
