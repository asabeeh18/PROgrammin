#pragma warning (disable : 4996)
//https://www.hackerrank.com/contests/morgan-stanley/challenges/substring-query
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	char s[1000];
	int q;
	int t, l, r, i, m;
	long long n;
	scanf("%s %d", s, &q);
	while (q--)
	{
		scanf("%d", &t);
		if (t == 1)
		{
			scanf("%d %d %lld", &l, &r, &n);
			n %= 26;
			l--;
			r--;
			for (i = l; i <= r; i++)
			{
				t = s[i];
				t += n;
				//printf("%c---", s[i]);
				if (t>'z')
				{
					//m = s[i] / 'z';
					t = (t % 122)+97 -1 ;
				}
				s[i] = t;
			}
		}
		else
		{
			printf("%s\n", s);
		}
	}
	return 0;
}
