
#pragma warning (disable : 4996)
//http://www.codechef.com/problems/DAILY
#include<stdio.h>
#include<malloc.h>
long long fact(long long x)
{
	long long i, f = 1;
	for (i = x; i >= 2; i--)
	{
		f *= i;
	}
	return f;
}
int main()
{
	long long x, n, i, j, k, empty, res = 0;
	char *a;
	scanf("%llu %llu", &x, &n);
	a=(char *)malloc(54*sizeof(char));
	//printf("x n: %llu %llu", x, n);
	while(n--)
	{
		//printf("\n:: %llu",n);
		scanf("%s",a);
		//printf("\n:: %llu",n);
		for (j = 0, k = 53; j < 36; j += 4, k -= 2)
		{
			//printf("\n:: %llu",n);
			empty = ((a[j] == '0' ? 1 : 0)+(a[j + 1] == '0' ? 1 : 0)+(a[j + 2] == '0' ? 1 : 0)+(a[j + 3] == '0' ? 1 : 0)+(a[k] == '0' ? 1 : 0)+(a[k - 1] == '0' ? 1 : 0));
	//		printf("Empty-j: %llu\n", empty);
			//printf("\n:: %llu",n);
			if (empty >= x)
				res += fact(empty) / fact(empty - x);
			//printf("\n:: %llu",n);
		//	printf("%llu\n", res);
		}
		//printf("\n:: %llu",n);
	}
	res = res / fact(x);
	printf("%llu", res);
	//while (1);
	return 0;
}