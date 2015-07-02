#pragma warning (disable : 4996)
//http://www.spoj.com/problems/MST1/
//1 2 3 5 7 11
//http://www.codechef.com/problems/COINS/
#include<stdio.h>
#include<malloc.h>
unsigned long int *store;
unsigned long int max = 0;
unsigned long int dividor(unsigned long int n)
{
	unsigned long int x;
	if (max >= n)
		if (store[n] != 0)
			return store[n];
	if (n == 1LL || n == 2LL || n == 3LL || n == 5LL || n == 7LL || n == 11LL)
		return n;
	x = dividor(n / 2) + dividor(n / 3) + dividor(n / 4);
	if (max >= n)
		store[n] = x;
	return x;
}
int main()
{
	unsigned long int a[10];
	int i = 0;
	int j = 0;
	while (scanf("%lu", &a[i]) != EOF)
	{
		i++;
		if (a[i]>max)
			max = a[i];
	}
	while (1)
	{
		store = (unsigned long int*)calloc(max, sizeof(unsigned long int));
		if (store == 0)
			max /= 2;
		else
			break;
	}
	store[1] = 1;
	for (j = 0; j < i; j++)
	{
		printf("%lu\n", dividor(a[j]));
	}
	while (1);
	return 0;
}