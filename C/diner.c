//#pragma warning (disable : 4996)
#include<stdio.h>
#include<malloc.h>
#include<string.h>
//https://code.google.com/codejam/contest/6224486/dashboard#s=p1
int max(int a[], int n)
{
	int i, m = 0;
	for (i = 1; i<n; i++)
	{
		m = a[i]>a[m] ? i : m;
	}
	return m;
}
int main()
{
	int newmax, oldmax, i, im, t, d, *a, *b, j, split;
	scanf("%d", &t);
	for (i = 1; i <= t; i++)
	{
		scanf("%d", &d);
		a = (int *)malloc(d*sizeof(int*));
	//	b = (int *)malloc(d*sizeof(int));
		for (j = 0; j<d; j++)
		{
			scanf("%d", &a[j]);
		}

		split = 0;
		//d = 0;

		while (1)
		{
			im = max(a, d);
			oldmax = a[im] + split;

			d++;
			//free(a)
			a=(int *)realloc(a, d*sizeof(int *));

				if (a[im] % 2 == 0)
				{
				a[im] = a[im] / 2;
				a[d-1] = a[im];
				}
				else
				{
					a[d-1] = a[im] / 2;
					a[im] = a[d-1] + 1;
				}
			split++;
			im = max(a, d);

			newmax = a[im] + split;
			if (newmax >= oldmax)
				break;



		}
		printf("Case #%d: %d\n",i, oldmax);
	}
	return 0;
}