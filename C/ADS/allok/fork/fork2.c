/*
Ahmed Sabeeh
aa..sss
2016CS16
*/
/*
(ii).         P1
             /  \
            P2  P3
           / \  / \
          P4 P5 P6 P7
Process P1 takes interger input for sorting from command line. The input data would be transferred from P1 to P4, P5, P6, and P7 through the processes P2 and P3. Sorting algorithms (All sorting algorithms would be different) would be implemented at P4, P5, P6, and P7. Also print the process id and parent process id of each process.
*/
#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

//#include<sys/wait.h>
void main(int argc,char* argv[])
{

	printf("\n\n");
	printf("Main Process Pid:%d\tPPid:%d\n",getpid(),getppid());

	if(fork()==0)
	{
		printf("%d\n",execv("./f2_2.o",argv));
		
	}

	wait();
	if(fork()==0)
	{
		printf("%d\n",execv("./f2_3.o",argv));
	}
	wait();
	//printf("%d\n",execv("/home/user/b.o",a));
}
