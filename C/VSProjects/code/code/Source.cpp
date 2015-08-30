
#pragma warning (disable : 4996)
#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
/* Function to get no of set bits in binary
representation of passed binary no. */
int comp(const void * elem1, const void * elem2)
{
	int f = *((int*)elem1);
	int s = *((int*)elem2);
	if (f > s) return  -1;
	if (f < s) return 1;
	return 0;
}
int countSetBits(int n)
{
	unsigned int count = 0;
	while (n)
	{
		n &= (n - 1);
		count++;
	}
	return count;
}

/* Program to test function countSetBits */
int main()
{
	//int i = 9;
	//  printf("%d", countSetBits(i));
	int i, n, k, t, *b;
	long *a, sum = 0;
	scanf("%d", &t);
	while (t--)
	{
		sum = 0;
		scanf("%d%d", &n, &k);
		a = (long*)malloc(n*sizeof(long));
		b = (int*)malloc(n*sizeof(int));
		for (i = 0; i<n; i++)
		{
			scanf("%li", &a[i]);
			b[i] = countSetBits(a[i]);
		}
		qsort(b, n, sizeof(int), comp);
		sum = 0;
		for (i = 0; i<k; i++)
		{
			sum += b[i];
			//printf("%d\n", b[i]);
		}
		printf("%li\n", sum);
	}
	return 0;
}