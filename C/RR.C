//RR

/*
imitate Q
arvv insrt
*/
#include<stdio.h>
#include<malloc.h>
int size = 0;
int *q;
int n = 0;
void insert(int ab)
{
	if (size == n)
	{
		printf("FULL");
		return;
	}
	q[size] = ab;
	size++;
}
int del()
{
	int i, t;
	if (size == 0)
		return -1;
	t = q[0];
	for (i = 0; i<size; i++)
		q[i] = q[i + 1];
	size--;
	return t;
}
void sortArrv(int **a, int n)
{
	int *t, i, j;
	for (i = 0; i<n - 1; i++)
		for (j = 0; j<n - i - 1; j++)
			if (a[j][1]>a[j + 1][1])
			{
		t = a[j];
		a[j] = a[j + 1];
		a[j + 1] = t;
			}
}

void roundRobin(int **a, int n)
{
	int i = 0, time = a[i][1], x, j;
	int *w, *t,wa=0,ta=0;
	t = (int *)malloc(n*sizeof(int));
	w = (int *)malloc(n*sizeof(int));
	for (i = 0; i<n; i++)
	{
		w[i] = -1;
		t[i] = -1;
	}
	i = 0;
	printf("Processor Utilisation:\n");
	while (1)
	{
		while (i<n && a[i][1] <= time && a[i][2]>0)	//insert process if it has arrived
		{
			insert(i);
			i++;
		}
		x = del();
		if (x == -1)	//if Q empty chk if all processes are done
		{
			int j = 0;
			while (j<n && a[j][2] == 0)
				j++;
			if (j == n)
				break;	//if done then break
			else
				i++;
		}
		else	
		{
			if (w[x] == -1)	//if process ran for 1st tym 
			{
				w[x] = time - a[x][1];
			}
			time++;
			printf("%d-", a[x][0]);
			a[x][2]--;
			if (a[x][2]>0)	//put back in Q
				insert(x);
			else
			{
				t[x] = time - a[x][1];
			}
		}
	}
	printf("\nProcess Waiting Turnaround\n");
	for (i = 0; i<n; i++)
	{
		printf("%d\t%d\t%d\n", a[i][0], w[i], t[i]);
		wa+=w[i];
		ta+=t[i];
	}
	printf("Average Turnaround: %f Average waiting: %f ",ta/(float)n,wa/(float)n);
}

void main()
{
	int *(*a), i, j, av, b;
	printf("Enter number of Processes	: ");
	scanf("%d", &n);
	q = (int *)malloc(n*sizeof(int));
	*a = (int *)malloc(n*sizeof(int));
	for (i = 0; i<n; i++)
		a[i] = (int *)malloc(3 * sizeof(int));
	printf("Arrival time and Burst times%d\n", n);
	for (i = 0; i<n; i++)
	{
		scanf("%d %d", &av, &b);
		a[i][0] = i;
		a[i][1] = av;
		a[i][2] = b;
	}
	sortArrv(a, n);
	roundRobin(a, n);
}