/*
Ahmed Sabeeh
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
#include<unistd.h>
#include<malloc.h>
void forkChild(int fd[2])
{
	int fd1[2],fd2[2],n,i;
	pipe(fd1);	
	int pid=fork(); //make a
	int **a;
	
	if(pid==0)
	{
		//in a
		printf("Process Pid:%d\tPPid:%d\n",getpid(),getppid());
		read(fd1[0],&n,sizeof(int));
		printf("Sorter n:%d\n",n);
		a=(char**)malloc(n);
		read(fd1[0],a,n);
		for(i=0;i<4;i++)
		{
			printf("ppid\t%d,%d\n",getppid(),a[i]);
		}
	}
	else if(pid>0)
	{
		pipe(fd2);
		pid=fork(); //make b
		if(pid==0)
		{
			printf("Process Pid:%d\tPPid:%d\n",getpid(),getppid());
			//in b
			read(fd2[0],&n,sizeof(int));
			printf("Sorter n:%d\n",n);
			a=(char**)malloc(n);
			read(fd2[0],a,n);
			for(i=0;i<4;i++)
			{
				printf("ppid\t%d,%d\n",getppid(),a[i]);
			}
		}
		else if(pid>0)
		{
			//parent space
			read(fd[0],&n,sizeof(int));
			printf("Relay n:%d\n",n);
			a=(char**)malloc(n);
			read(fd[0],a,n);
			
			//close read ends
			close(fd1[0]);
			close(fd2[0]);
			
			//write to child
			//n=sizeof(a);
			write(fd1[1],&n,sizeof(int));
			write(fd1[1],a,sizeof(a));
			write(fd2[1],&n,sizeof(int));
			write(fd2[1],a,sizeof(a));
			wait(pid);
			wait(pid);			
		}
	}
}

void main()
{
	int pid,n;
	char* a[]={"34","65","78","2"};
	int fd1[2],fd2[2];
	printf("Main Process Pid:%d\tPPid:%d\n",getpid(),getppid());
	
	pipe(fd1);
	pid=fork(); //make 2
	if(pid==0)
	{
		//in 2
		
		printf("Process Pid:%d\tPPid:%d\n",getpid(),getppid());
		forkChild(fd1);
	}
	else if(pid>0)
	{
		pipe(fd2);
		pid=fork(); //make 3
		if(pid==0)
		{
			printf("Process Pid:%d\tPPid:%d\n",getpid(),getppid());
			//in 3
			forkChild(fd2);
		}
		else if(pid>0)
		{
			//parent space
			
			//close read ends
			close(fd1[0]);
			close(fd2[0]);
			
			//write to child
			n=sizeof(a);
			write(fd1[1],&n,sizeof(int));
			write(fd1[1],a,sizeof(a));
			write(fd2[1],&n,sizeof(int));
			write(fd2[1],a,sizeof(a));
			wait(pid);			
			wait(pid);
		}
	}
	//printf("%d\n",execv("/home/user/b.o",a));
}
