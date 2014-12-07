//CSCAN
#include<stdio.h>
#include<malloc.h>
void sort(int a[], int n)
{
	int i, j, t;
	for (i = 0; i<n; i++)
		for (j = 0; j<n - i - 1; j++)
			if (a[j]>a[j + 1])
			{
		t = a[j];
		a[j] = a[j + 1];
		a[j + 1] = t;
			}
}
int main()
{
	int *a, r, m, n, b, i, j, h, tm=0;
	printf("Enter the range of disk");
	scanf("%d %d", &m, &n);
	printf("Number of requests");
	scanf("%d", &r);
	printf("Initial head position");
	scanf("%d", &h);
	printf("Enter Access String\n");
	a = (int *)malloc(n*sizeof(int));
	for (i = 0; i<r; i++)
		scanf("%d", &a[i]);
	sort(a, r);
	for (i = 0; i<n; i++)
		if (a[i]>h)
			break;
	printf("\nTrack Movement\n");
	j = 0;
	do
	{
		if (i >= r)
		{
			printf("\n%d\t %d\n", n, abs(h - n));
			printf("\n%d\t %d\n", m, abs(n - m));
			i = 0;
			h = m;
			tm+=abs(h - n)+abs(n - m);
		}
		printf("\n%d\t %d\n", a[i], abs(h - a[i]));
		tm+=abs(h - a[i]);
		h = a[i];
		i++;
		j++;
	} while (j<r);
	printf("Total Movement: %d",tm);
}


