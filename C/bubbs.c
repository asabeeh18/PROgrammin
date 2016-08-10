/*
Question: Write a C program to implement bubble sort for following input types:
(i). Integer
(ii). String
(iii). Date (Day/Month/Year where Month is either string, such as August or integer, such as 08) 
All these data are stored in file. Your program should read input from one file and store sorted output in another file. Find the execution time of program for each input type. While writing the program, follow the software engineering principle as you studied in your UG/PG courses.
*/
#include<stdio.h>
void main()
{
	int bf[100];
	FILE *input=fopen("ints.txt","r+");
	FILE *output=fopen("ints-outs","w");
	int i,j,tmp,n;
	int a[50];
	
	i=0;
	//printf("In");
	while(!feof(input))
	{
		fscanf(input,"%d",&bf[i]);
		i++;
	}
	n=i;
	
	for(i=0;i<n;i++)
		printf("%d ",bf[i]);
	for(i=0;i<n;i++)
	{
		for(j=0;j<n-i-1;j++)
		{
			if(bf[j]>bf[j+1])
			{
				tmp=bf[j+1];
				bf[j+1]=bf[j];
				bf[j]=tmp;
			}
		}
	}
	for(i=0;i<n;i++)
		fprintf(output,"%d ",bf[i]);
}
/*void print()
{
	for(i=0;i<n;i++)
		printf("%d ",bf[i]);
}*/
