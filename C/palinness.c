//http://www.codechef.com/LTIME23/problems/PALPROB
#include<stdio.h>
#include<string.h>
//#pragma warning (disable : 4996)
int palin(char s[100], int n)
{
	int i;
	for (i = 0; i < n; i++)
	{
		if (s[0] != s[n - i-1])
			return 0;
	}
	return 1;
}
int calc(char s[100], int n)
{
	if (n == 1)
		return 1;
	else
	{
		if (palin(s, n))
			return calc(s, n / 2) + 1;
		else
			return 0;
	}
}
int main()
{
	int t;
	char s[100];
	scanf("%d", &t);
	while (t--)
	{
		scanf("%s", &s);
		printf("%d\n", calc(s, strlen(s)));
	}

	return 0;
}