#pragma warning (disable : 4996)
//http://www.codechef.com/LTIME23/problems/TICKETS5
#include<stdio.h>
#include<string.h>
int main()
{
	int n, t, i;
	char s[3];
	scanf("%d", &t);
	while (t--)
	{
		scanf("%s", &s);
		for (i = 0; i<strlen(s) - 2; i++)
		{
			if (s[i] != s[i + 2])
				break;
		}
		if (i == strlen(s) - 2)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}