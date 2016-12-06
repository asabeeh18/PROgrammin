/*
Ahmed Sabeeh
2016CS16

Write program for radix sort, merge sort, quick sort, and bucket sort. Input data would be output 
of command "ps -xal". For details see man page for "ps". You have to sort the input in descending order of the PID.

Radix Sort
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
struct Line
{
	int pid;
	char f[100],ppid[100],pri[100],ni[100],vsz[100],rss[100],uid[100],wchan[100],stat[100],tty[100],time[100],command[100];
};

void printToFileRadix(struct Line *psx,int n,FILE *out)
{
	int i=0;
	for(i=n-1;i>=0;i--)
	{
		fprintf(out,"%s %s %d %s %s %s %s %s %s %s %s %s %s\n",psx[i].f,psx[i].uid,psx[i].pid,psx[i].ppid,psx[i].pri,psx[i].ni,psx[i].vsz,psx[i].rss,psx[i].wchan,psx[i].stat,psx[i].tty,psx[i].time,psx[i].command);		
	}
	fclose(out);
}

void radixSort(struct Line *psx,int n)
{
	int max,i,k,digit,j,m;
	struct Line bucket[10][100];
	int count[10];
	
	for(i=0;i<10;i++)
		count[i]=0;

	max=psx[0].pid;
	for(i=0;i<n;i++)
	{
		if(psx[i].pid>max)
			max=psx[i].pid;
	}
	k=10;
	while(k<max*10)
	{

		for(i=0;i<n;i++)
		{
			digit=psx[i].pid%k;
			digit=digit/(k/10);

			bucket[digit][count[digit]++]=psx[i];
		}

		m=0;
		for(i=0;i<10;i++)
		{
			j=0;
			while(j<count[i])
			{
				psx[m]=bucket[i][j];
				j++;
				m++;
			}
			count[i]=0;
		}
		k*=10;		
	}
}

int main()
{
	FILE *ps,*out;
	int i,n=100;
	struct Line psx[500];
	char s[256];
	
	//input	
	printf("Enter input file name containing output of \"ps -xal\": ");
	scanf("%s",s);
	ps=fopen(s,"r+");
	printf("Enter output file name: ");
	scanf("%s",s);
	out=fopen(s,"w");
	


/*
Input Format
F   UID   PID  PPID PRI  NI    VSZ   RSS WCHAN  STAT TTY        TIME COMMAND
4     0     1     0  20   0   2900  1420 ?      Ss   ?          0:01 /sbin/init
*/
	i=0;
	while(!feof(ps))
	{
		
		fscanf(ps,"%s %s %d %s %s %s %s %s %s %s %s %s %[^\n]s",&psx[i].f,&psx[i].uid,&psx[i].pid,&psx[i].ppid,&psx[i].pri,&psx[i].ni,&psx[i].vsz,&psx[i].rss,&psx[i].wchan,&psx[i].stat,&psx[i].tty,&psx[i].time,&psx[i].command);
		i++;
	}
	n=i-1;	

	radixSort(psx,n);
	printToFileRadix(psx,n,out);
	printf("Done!! Output saved in file: %s\n",s);

	return 0;
}


