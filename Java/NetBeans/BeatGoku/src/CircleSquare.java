import java.util.*;

public class CircleSquare
{

    static int x1, y1, x2, y2, x3, y3, x4, y4, circleX, circleY, w, h, r;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        w = in.nextInt();
        h = in.nextInt();
        circleX = in.nextInt();
        circleY = in.nextInt();
        r = in.nextInt();
        x1 = in.nextInt();
        y1 = in.nextInt();
        x3 = in.nextInt();
        y3 = in.nextInt();

        // your code goes here
        double xc = (x1 + x3) / 2.0;
        double yc = (y1 + y3) / 2.0;    // Center point
        double xd = (x1 - x3) / 2.0;
        double yd = (y1 - y3) / 2.0;    // Half-diagonal

        x2 = (int) (xc + yd);
        y4 = (int) (yc + xd);    // Third corner
        x4 = (int) (xc - yd);
        y2 = (int) (yc - xd);    // Fourth corner
        System.out.println(x2+"-"+y2+","+x4+"-"+y4);
//        y1=-y1;
//        y2=-y2;
//        y3=-y3;
//        y4=-y4;
//        circleY=-circleY;
        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                if (square(j, i))
                {
                    if (circle(j, i))
                        System.out.print("$");
                    else
                        System.out.print("#");
                } 
                else if (circle(j, i))
                {
                    System.out.print("@");
                }
                else
                {
                    System.out.print(".");
                }    
            }
            System.out.println();
        }
    }

    private static boolean square(int x, int y)
    {
        int bax, bay, dax, day;
        bax = x2 - x1;
        bay = y2 - y1;
        dax = x4 - x1;
        day = y4 - y1;

        if ((x - x1) * bax + (y - y1) * bay < 0.0)
        {
            return false;
        }
        if ((x - x2) * bax + (y - y2) * bay > 0.0)
        {
            return false;
        }
        if ((x - x1) * dax + (y - y1) * day < 0.0)
        {
            return false;
        }
        if ((x - x4) * dax + (y - y4) * day > 0.0)
        {
            return false;
        }
        return true;
    }

    private static boolean circle(int i, int j)
    {
        return (i - circleX) * (i - circleX) + (j - circleY) * (j - circleY) <= r * r;
    }
}
