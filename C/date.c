/*
	Question: Write a C program to implement bubble sort for following input types:
	(i). Integer
	(ii). String
	(iii). Date (Day/Month/Year where Month is either string, such as August or integer, such as 08)
	All these data are stored in file. Your program should read input from one file and store sorted output in another file. Find the execution time of program for each input type. While writing the program, follow the software engineering principle as you studied in your UG/PG courses.
*/
#include<stdio.h>
#include<string.h>
/*
	union Month
	{
	int mnthint;
	char mnthstr[50];
	};
*/
struct Date
{
	int day;
	int year;
	int month;
};
void main()
{
	FILE *input = fopen("date", "r+");	
	FILE *output = fopen("date-outs", "w");
	int i, j, n;
	struct Date date[50];
	struct Date tmp;
	
	i = 0;
	while (!feof(input))
	{
		if (!fscanf(input,"%d/%d/%d",&date[i].day,&date[i].month,&date[i].year))
		break;
		/*		date[i].day = atoi(strtok(bf, "/"));
			date[i].month.mnthint=atoi(strtok(NULL, "/"));
			date[i].year=atoi(strtok(NULL, "/"));
		*/
		printf("%d/%d/%d.\n",date[i].day,date[i].month,date[i].year);
		i++;
	}
	n=i;
	
	
	
	
	for (i = 0; i<n; i++)
	{
		for (j = 0; j<n - i - 1; j++)
		{
			if(date[j].year>date[j+1].year)
			{
				tmp=date[j];
				date[j]=date[j+1];
				date[j+1]=tmp;
			}
			else if(date[j].month>date[j+1].month && date[j].year==date[j+1].year)
			{
				tmp=date[j];
				date[j]=date[j+1];
				date[j+1]=tmp;
			}
			else if(date[j].day==date[j+1].day && date[j].month==date[j+1].month && date[j].year==date[j+1].year)
			{
				tmp=date[j];
				date[j]=date[j+1];
				date[j+1]=tmp;
			}
		}
	}
	printf("Sorting Done\n");
	for (i = 0; i<n; i++)
	{
		fprintf(output,"%d/%d/%d ", date[i].day, date[i].month, date[i].year);
	}
	fclose(output);
}
/*void print()
{
for(i=0;i<n;i++)
printf("%d ",bf[i]);
}*/
