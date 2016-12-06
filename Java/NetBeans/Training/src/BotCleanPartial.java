
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BotCleanPartial {

    static boolean visited[][] = new boolean[5][5];
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static char boardReal[][];
    static BufferedWriter bw;

    static int bfsNearest(int r, int c, char[][] board)
    {
        for (int i = 0; i < 5; i++)
        {
            Arrays.fill(visited[i], false);
        }
        dq.clear();
        if (r != 0 && c != 0 && !visited[r - 1][c - 1])
        {
            dq.add(((r - 1) * 10 + c - 1));
        }
        if (r != 0 && !visited[r - 1][c])
        {
            dq.add(((r - 1) * 10 + c));
        }
        if (r != 0 && c != 4 && !visited[r - 1][c + 1])
        {
            dq.add(((r - 1) * 10 + c + 1));
        }
        if (c != 0 && !visited[r][c - 1])
        {
            dq.add(r * 10 + c - 1);
        }
        if (c != 4 && !visited[r][c + 1])
        {
            dq.add(r * 10 + c + 1);
        }
        if (r != 0 && c != 0 && !visited[r - 1][c - 1])
        {
            dq.add((r - 1) * 10 + c - 1);
        }
        if (r != 4 && !visited[r + 1][c])
        {
            dq.add((r + 1) * 10 + c);
        }
        if (c != 4 && r != 4 && !visited[r + 1][c + 1])
        {
            dq.add((r + 1) * 10 + c + 1);
        }

        while (!dq.isEmpty())
        {
            int a = dq.remove();
            r = a / 10;
            c = a % 10;
            visited[r][c] = true;
            if (board[r][c] == 'd')
            {
                return a;
            }
            if (r != 0 && c != 0 && !visited[r - 1][c - 1])
            {
                dq.add(((r - 1) * 10 + c - 1));
            }
            if (r != 0 && !visited[r - 1][c])
            {
                dq.add(((r - 1) * 10 + c));
            }
            if (r != 0 && c != 4 && !visited[r - 1][c + 1])
            {
                dq.add(((r - 1) * 10 + c + 1));
            }
            if (c != 0 && !visited[r][c - 1])
            {
                dq.add(r * 10 + c - 1);
            }
            if (c != 4 && !visited[r][c + 1])
            {
                dq.add(r * 10 + c + 1);
            }
            if (r != 0 && c != 0 && !visited[r - 1][c - 1])
            {
                dq.add((r - 1) * 10 + c - 1);
            }
            if (r != 4 && !visited[r + 1][c])
            {
                dq.add((r + 1) * 10 + c);
            }
            if (c != 4 && r != 4 && !visited[r + 1][c + 1])
            {
                dq.add((r + 1) * 10 + c + 1);
            }
        }
        return -1;
    }

    static void reset(int posr, int posc, char[][] board)
    {
        int r, c;
        //11 13 33 31
        int[][] points = new int[][]
        {
            {
                1, 1
            },
            {
                1, 3
            },
            {
                3, 3
            },
            {
                3, 1
            },
        };
        double min = Double.MAX_VALUE, dist, xdist, ydist;
        int index = 0;
        for (int i = 0; i < 4; i++)
        {
            xdist = Math.abs(posr - points[i][0]);
            ydist = Math.abs(posc - points[i][1]);
            dist = Math.sqrt(xdist * xdist + ydist * ydist);
            if (min > dist)
            {
                min = dist;
                index = i;
            }
        }
        r = points[index][0];
        c = points[index][1];
        if (posr > r)
        {
            System.out.println("UP");
        } else if (posr < r)
        {
            System.out.println("DOWN");
        } else if (posc < c)
        {
            System.out.println("RIGHT");
        } else if (posc > c)
        {
            System.out.println("LEFT");
        }

    }

    static void next_move(int posr, int posc, char[][] board)
    {
        int a = bfsNearest(posr, posc, board);
        if (a == -1)
        {
            boolean flag = false;
            int index = 0;
            //define a clockwise path
            int[][] points = new int[][]
            {
                {
                    1, 1
                },
                {
                    1, 2
                },
                {
                    1, 3
                },
                {
                    2, 3
                },
                {
                    3, 3
                },
                {
                    3, 2
                },
                {
                    3, 1
                },
            };
            System.err.println("NOT FOUND");
            
            //check if bot at one of predefined paths
            for (int i = 0; i < points[0].length; i++)
            {
                if (posr == points[i][0] && posc == points[i][1])
                {
                    flag = true;
                    index = i;
                    break;
                }
            }
            if (!flag)
            {
                reset(posr, posc, board);
            } 
            else
            {
                //move clockwise
                int r = points[index + 1][0];
                int c = points[index + 1][1];
                if (posr > r)
                {
                    System.out.println("UP");
                } else if (posr < r)
                {
                    System.out.println("DOWN");
                } else if (posc < c)
                {
                    System.out.println("RIGHT");
                } else if (posc > c)
                {
                    System.out.println("LEFT");
                }
            }
        } 
        //move towards dirty
        else
        {
            int r = a / 10, c = a % 10;
            if (board[posr][posc] == 'd')
            {
                System.out.println("CLEAN");
                board[posr][posc]='-';
            } else if (posr > r)
            {
                System.out.println("UP");
            } else if (posr < r)
            {
                System.out.println("DOWN");
            } else if (posc < c)
            {
                System.out.println("RIGHT");
            } else if (posc > c)
            {
                System.out.println("LEFT");
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        //CHeck if old file exists
        try (BufferedReader br = new BufferedReader(new FileReader(new File("board"))))
        {
            String s;
            boardReal=new char[5][5];
            for (int i = 0; i < 5; i++)
            {
                s=br.readLine();
                for(int j=0;i<5;j++)
                {
                    boardReal[i][j] = s.charAt(j);
                }
                
            }
            br.close();
        }
        //or else create it
        catch (FileNotFoundException e)
        {
            boardReal=new char[5][5];
            for (int i = 0; i < 5; i++)
            {
                for(int j=0;j<5;j++)
                {
                    boardReal[i][j] = 'o';
                }
                
            }
        }
        int[] pos = new int[2];
        char board[][] = new char[5][5];
        for (int i = 0; i < 2; i++)
        {
            pos[i] = in.nextInt();
        }
        for (int i = 0; i < 5; i++)
        {
                String s=in.next();
                for(int j=0;j<5;j++)
                {
                    board[i][j] = s.charAt(j);
                }
        }

        //put new input in the old i/p collected so far
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (boardReal[i][j]=='o' && board[i][j]!='o')
                {
                    boardReal[i][j]=board[i][j];
                }
            }
        }

        //write ti file for next time
        bw = new BufferedWriter(new FileWriter(new File("boardw")));
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                bw.write(boardReal[i][j]);
            }
            bw.write("\n");
        }
        bw.close();
        next_move(pos[0], pos[1], boardReal);
    }
}
