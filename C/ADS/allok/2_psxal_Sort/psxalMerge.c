/*
Ahmed Sabeeh
2016CS16

Write program for radix sort, merge sort, quick sort, and bucket sort. Input data would be output 
of command "ps -xal". For details see man page for "ps". You have to sort the input in descending order of the PID.

Merge Sort
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
struct Line
{
	int pid;
	char f[100],ppid[100],pri[100],ni[100],vsz[100],rss[100],uid[100],wchan[100],stat[100],tty[100],time[100],command[100];
};

void printToFileMerge(struct Line *psx,int n,FILE *out)
{
	int i=0;
	for(i=0;i<n;i++)
	{
		fprintf(out,"%s %s %d %s %s %s %s %s %s %s %s %s %s\n",psx[i].f,psx[i].uid,psx[i].pid,psx[i].ppid,psx[i].pri,psx[i].ni,psx[i].vsz,psx[i].rss,psx[i].wchan,psx[i].stat,psx[i].tty,psx[i].time,psx[i].command);		
	}
	fclose(out);
}

//MERGE SORT
void merge(struct Line *psx,int start,int mid,int end)
{
	
	struct Line temp[500];
	int k=0,i=start,j=mid+1;
	
	//printf("In25\n");
	while(i<=mid && j<=end && i<j)
	{
		if(psx[i].pid<psx[j].pid)
		{
			temp[k]=psx[j];
			k++;
			j++;
		}
		else
		{
			temp[k]=psx[i];
			k++;
			i++;
		}
	}
	
	while(i<=mid)
	{
			temp[k]=psx[i];
			k++;
			i++;		
	}
	while(j<=end)
	{
			temp[k]=psx[j];
			k++;
			j++;		
	}
	for(i=0,j=start;i<k;i++,j++)	
	{
		psx[j]=temp[i];
	}
}
void mergeSort(struct Line *psx,int start,int end)
{
	//printf("In Sorting %d %d\n",start,end);
	int mid;
	if(start<end)
	{
		mid=(start+end)/2;
		//printf("%d",mid);
		mergeSort(psx,start,mid);
		mergeSort(psx,mid+1,end);
		merge(psx,start,mid,end);
	}
}
//END MERGESORT

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
	
	i=0;
/*
Input Format
F   UID   PID  PPID PRI  NI    VSZ   RSS WCHAN  STAT TTY        TIME COMMAND
4     0     1     0  20   0   2900  1420 ?      Ss   ?          0:01 /sbin/init
*/
	while(!feof(ps))
	{
	
		fscanf(ps,"%s %s %d %s %s %s %s %s %s %s %s %s %[^\n]s",&psx[i].f,&psx[i].uid,&psx[i].pid,&psx[i].ppid,&psx[i].pri,&psx[i].ni,&psx[i].vsz,&psx[i].rss,&psx[i].wchan,&psx[i].stat,&psx[i].tty,&psx[i].time,&psx[i].command);
		i++;
	}
	n=i-1;	
	
	//call to sort here
	mergeSort(psx,0,n-1);
	//print output here
	printToFileMerge(psx,n,out);
	printf("Done!! Output saved in file: %s\n",s);
	return 0;
}


