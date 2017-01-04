
import java.util.*;

public class BotCleanPartial
{

    static boolean visited[][] = new boolean[5][5];
    static ArrayDeque<Integer> dq = new ArrayDeque<>();

    static String bfsNearest(int r, int c, String[] board)
    {
        //std values 1,0 11 12 13 23 33 32 31 30
        int[][] points = new int[][]
        {
            {
                1, 0
            },
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
            {
                3, 0
            }
        };
        for (int i = 0; i < points.length; i++)
        {
            if (r == points[i][0] && c == points[i][1])
            {
                break;
            }
            //last iteration...reset me
            if (i == points.length - 1)
            {
                if ((r == 0 || r == 4) && c == 3)
                {
                    //special case of corner
                    if (board[r].charAt(c + 1) == 'd')
                    {
                        return "RIGHT";
                    }
                    else
                    {
                        if (r == 4)
                        {
                            return "UP";
                        } else
                        {
                            return "DOWN";
                        }

                    }
                } else
                {
                    if (r == 4)
                    {
                        return "UP";
                    } else if (r == 0)
                    {
                        return "DOWN";
                    } else if (r == 2 && c < 3)
                    {
                        return "UP";
                    } else //if (c == 4 && r > 0 && r < 4)
                    {
                        return "LEFT";
                    }
                }
            }
        }
        //if r,c != std values
        //move up/down/left(right edge) to std r,c
        //if r,c is 0,3 check right before resetting
        //else
        //we are in standard position
        if (c == 3)
        {
            //for the turn
            for (int i = 1; i <= 3; i++)
            {
                if (board[i].charAt(c + 1) == 'd')
                {
                    return "RIGHT";
                }
            }
            //diagonals
            if (r == 1 || r == 3)
            {
                if (board[0].charAt(4) == 'd')
                {
                    return "UP";
                }
                if (board[4].charAt(4) == 'd')
                {
                    return "DOWN";
                }
            }
        }
        if (r != 3 && board[r - 1].charAt(c) == 'd')
        {
            return "UP";
        } else if (board[r + 1].charAt(c) == 'd')
        {
            return "DOWN";
        } //check for dirt nearby:up down right,diagonal(in corners)
        //move towards dirt
        //no dirt: GG
        else
        {
            if (r == 1 || r == 2)
            {
                if (c == 3)
                {
                    return "DOWN";
                }
                return "RIGHT";
            } else
            {
                return "LEFT";
            }

        }
    }

    static void next_move(int posr, int posc, String[] board)
    {
        if (board[posr].charAt(posc) == 'd')
        {
            System.out.println("CLEAN");
            return;
        }
        System.out.println(bfsNearest(posr, posc, board));
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] pos = new int[2];
        String board[] = new String[5];
        for (int i = 0; i < 2; i++)
        {
            pos[i] = in.nextInt();
        }
        for (int i = 0; i < 5; i++)
        {
            board[i] = in.next();
        }
        next_move(pos[0], pos[1], board);
    }
}
