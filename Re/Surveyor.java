//https://arena.topcoder.com/#/u/practiceCode/1344/1281/1359/1/1344
class Surveyor
{
	class Point
	{
		int x,y;
		public static Point direction(char d,int len,Point a)
		{
			if(d=='N')
				a.y+=len;
			else if(d=='E')
				a.x+=len;
			else if(d=='W')
				a.y-=len;
			else if(d=='S')
				a.y-=len;
			
			return a;
		}
	}
	public int area(String d, int[] pts)
	{
			//N E W S
			int n=pts.length;
			Point start=new Point(),
					cur=new Point(),
					prev=new Point();
			
			//init
			start.x=0;
			start.y=0;
			cur=(d.charAt(0),pts[0],start);
			int area=0;
			
			//start
			for(int i=1;i<n;i++)
			{
				Point temp=cur;
				cur=(d.charAt(i),pts[i],cur);
				prev=temp;
				
				area+=cross(start,prev,cur);
			}
			private int area(Point a,Point b,Point c)
			{
				Point x=new Point(),
						y=new Point();
				x.x=a.x-b.x;
				x.y=a.y-b.y;
				y.x=a.x-c.x;
				y.y=a.y-c.y;
				
				return (x.x*y.y-x.y*y.x)/2;
				
			}
	}
	
}