//http://www.codechef.com/problems/DEVJERRY
#include<stdio.h>
#include<math.h>
//#pragma warning (disable : 4996)
int max(int a,int b)
{
	if(a>b)
		return a;
	return b;
}
int min(int a,int b)
{
	if(a<b)
		return a;
	return b;
}
int main()
{
	int n, sx, sy, ex, ey, bx, by, d, t;
	scanf("%d", &t);
	while (t--)
	{
		scanf("%d %d %d %d %d %d %d", &n, &sx, &sy, &ex, &ey, &bx, &by);

		d = abs(sx - ex) + abs(sy - ey);
		if ((sx == ex || sy == ey) && (bx>=min(ex,sx)) && (bx <= max(ex,sx)) && (by >= min(ey,sy)) && (by <= max(ey,sy)))
		{
			d += 2;
		}
		printf("%d\n", d);
	}
	//while (1);
	return 0;
}