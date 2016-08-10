//https://arena.topcoder.com/#/u/practiceCode/1344/1281/1359/1/1344

class Surveyor {

    class Point {

        int x, y;

        public Point direction(char d, int len)
        {
            Point t=new Point();
            
            if (d == 'N')
            {
                t.y = y+len;
                t.x=x;
            } else if (d == 'E')
            {
                t.x = x+len;
                t.y=y;
            } else if (d == 'W')
            {
                t.x = x-len;
                t.y=y;
            } else if (d == 'S')
            {
                t.y = y-len;
                t.x=x;
            }

            return t;
        }
    }

    public int area(String d, int[] pts)
    {
        //N E W S
        int n = pts.length;
        Point start = new Point(),
                cur = new Point(),
                prev = new Point();

        //init
        start.x = 0;
        start.y = 0;
        cur = start.direction(d.charAt(0), pts[0]);
        int area = 0;

        //start
        for (int i = 1; i < n; i++)
        {
            Point temp = cur;
            cur = cur.direction(d.charAt(i), pts[i]);
            prev = temp;

            area += cross(start, prev, cur);
        }
        return Math.abs(area);
    }

    private int cross(Point a, Point b, Point c)
    {
        Point x = new Point(),
                y = new Point();
        x.x = a.x - b.x;
        x.y = a.y - b.y;
        y.x = a.x - c.x;
        y.y = a.y - c.y;

        return (x.x * y.y - x.y * y.x) / 2;

    }

    public static void main(String[] args)
    {
        // TODO code application logic here
        int[] a={20,200,30,100,20,30,10,70};
        (new Surveyor()).area("NESWNWSW",a);
    }

}
