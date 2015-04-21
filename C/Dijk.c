#pragma warning (disable : 4996)
//https://code.google.com/codejam/contest/6224486/dashboard#s=p2
#include<stdio.h>
#include<math.h>
//#define ij -k
int mx[5][5] = { { 0, 0, 0, 0, 0 }, { 0, 1, 2, 3, 4 }, { 0, 2, -1, 4, -3 }, { 0, 3, -4, -1, 2 }, { 0, 4, 3, -2, -1 } };
int eval(int a, int b)
{
	int ai;
	ai = abs(a);
	return (ai / a)*mx[ai][b];
}
int solver(char s[], int l)
{
	int c = s[l - 1];
	s[l - 1] = '\0';
	if (l == 2)
		return eval((int)s[0], c);
	else
		return eval(solver(s, l - 1), c);
}


int main()
{
	//i j k = 2 3 4
	int i, t, l, x, a;
	char str[10000];

	scanf("%d", &t);
	for (i = 1; i <= t; i++)
	{
		a = 0;
		scanf("%d %d %s", &l, &x, str);

		//printf("\n%s",str);
		//105=i 103 =g

		for (a = 0; a<l; a++)
		{
			str[a] -= 'g';
			printf("%d.", str[a]);
		}

		a = solver(str, l);
		printf("\n%d", a);

	}
	return 0;
}