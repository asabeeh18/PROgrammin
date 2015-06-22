#include<stdio.h>
#include<math.h>
long sum(long i)
{
	long j,fact=1;
	for(j=1;j<=i;j++)
		fact*=j
	return fact;

int main()
{
	int t;
	long i,sum,n;
	scanf("%d",&t);
	while(t--)
	{
		sum=0;
		scanf("%ld",&n);
		for(i=n/2;i>=2;i--)
			sum+=fact(i);
		printf("%ld",sum);
	}
	return 0;
}

2 return 
3p3+3p2*(func(4))+3p1*(func(2))
12344321

1234
1243
1324
1342
1423
1432

4
1221
1212
2121
11
22

123321
123
132
321
312
213
231

1221

1212
2121

1331

1313
3131

2323
3232
11
22
33
