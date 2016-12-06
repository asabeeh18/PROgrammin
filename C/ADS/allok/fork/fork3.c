/*
Ahmed Sabeeh
2016CS16
*/
/*
P1
            / / \ \
           P2 P3 P4 P5 
Process P1 takes integer input for sorting from command line. The input data would be transferred from P1 to P2, P3, P4, and P5. Sorting algorithms (All sorting algorithms would be different) would be implemented at P2, P3, P4, and P5. Also print the process id and parent process id of each process.
*/

#include<stdio.h>
void main(int argc,char* argv[])
{
	printf("\n\n");
	if(fork()==0)
	{
		//Bubble
		printf("%d\n",execv("./b.o",argv));
	}

	wait();
	if(fork()==0)
	{
		//Insertion
		printf("%d\n",execv("./i.o",argv));
	}
	wait();
	if(fork()==0)
	{
		//Heap
		printf("%d\n",execv("./h.o",argv));
	}
	wait();	
	if(fork()==0)
	{
		//Merge
		printf("%d\n",execv("./m.o",argv));
	}
	wait();
	printf("\nEnd\n");
}
