import java.util.*;

public class BotClean 
{
    static boolean visited[][]=new boolean[5][5];
    static ArrayDeque<Integer> dq=new ArrayDeque<>(); 
    static int bfsNearest(int r,int c,String[] board)
    {
        for(int i=0;i<5;i++)
           Arrays.fill (visited[i],false);
        dq.clear();
        if(r!=0 && !visited[r-1][c])
             dq.add(((r-1)*10+c));
        if(c!=4 && !visited[r][c+1])
            dq.add(r*10+c+1);
        if(r!=4 && !visited[r+1][c])
            dq.add((r+1)*10+c);
        if(c!=0 && !visited[r][c-1])
            dq.add(r*10+c-1);
            
        while(!dq.isEmpty())
        {
            int a=dq.remove();
            r=a/10;
            c=a%10;
            visited[r][c]=true;
            if(board[r].charAt(c)=='d')
            {
               return a;
            }
            if(r!=0 && !visited[r-1][c])
                dq.add(((r-1)*10+c));
            if(c!=4 && !visited[r][c+1])
                dq.add(r*10+c+1);
            if(r!=4 && !visited[r+1][c])
                dq.add((r+1)*10+c);
            if(c!=0 && !visited[r][c-1])
                dq.add(r*10+c-1);
        }
        return -1; 
    }
    static void next_move(int posr, int posc, String[] board)
    {
        int a=bfsNearest(posr,posc,board);
        int r=a/10,c=a%10;
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
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
