/*
Ahmed Sabeeh
2016CS16
*/
/*
Question. Create processes using fork() in following manner
(i).  Process 1
         |
      Process 2 (child of process 1)
         |
      Process 3  (child of process 2)
         |
      Process 4  (child of process 3)
         |
      Process 5  (child of process 4)
*/

#include<stdio.h>
#include<unistd.h>
void main()
{
	int pid;
	printf("Process 1 Pid:%d\tPPid:%d\n",getpid(),getppid());
	pid=fork();
	if(pid==0)
	{
		printf("Process 2 Pid:%d\tPPid:%d\n",getpid(),getppid());
		pid=fork();
		if(pid==0)
		{	
			printf("Process 3 Pid:%d\tPPid:%d\n",getpid(),getppid());
			pid=fork();
			if(pid==0)
			{
				printf("Process 4 Pid:%d\tPPid:%d\n",getpid(),getppid());
				pid=fork();
				if(pid==0)
				{
					printf("Process 5 Pid:%d\tPPid:%d\n",getpid(),getppid());
				}
				else if(pid>0)
				{
					wait(pid);
				}
			}
			else if(pid>0)
			{
				wait(pid);
			}
		}
		else if(pid>0)
		{
			wait(pid);
		}
	}
	else if(pid>0)
	{
		wait(pid);
	}
		
}
