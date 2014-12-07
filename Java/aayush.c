function minmax(x,i,j,fmin,fmax)
	i,j->bounds
	x(i,j)->array
	fmin,fmax->o/p variables
Integer gmin,gmax,hmin,hmax,m
1.Start
2.if i=j then
3.{ fmin=fmax=x(i)
4.return;
}
5.if i=j-1 then
{
6.fmin=minimum(x(i),x(j))
7.fmax=maximum(x(i),x(j))
8.return
}
9 m=(i+j)2
10.minmax(x,i,m,gmin,gmax)
11.minmax(x,m+1,j,hmin,hmax)
12.fmin=minimum(gmin,hmin)
13 fmax=maximum(gmax,hmax)
14 return