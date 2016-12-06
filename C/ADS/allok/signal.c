/*
Ahmed Sabeeh
2016CS16 
*/
/*
Write a C program for each of the following signals demonstrating their utility. You are free to make use of different
system calls in your C program for demonstration of utility.
	SIGALRM - alarm clock
	SIGBUS - bus error
	SIGFPE - floating point arithmetic exception
	SIGINT - interrupt (i.e., Ctrl-C)
	SIGQUIT - quit (i.e., Ctrl-\)
	SIGTERM - process terminated
	SIGUSR1 and SIGUSR2 - user defined signals
*/
#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include<stdlib.h>

void sig_handler(int signo)
{
    if(signo==SIGUSR1)
        printf("received SIGUSR1\n");
    else if(signo==SIGALRM)
        printf("received SIGALRM\n");
    else if(signo==SIGFPE)
        printf("received SIGFPE\n");
    else if(signo==SIGINT)
        printf("received SIGINT\n");
    else if(signo==SIGTERM)
        printf("received SIGTERM\n");
    else if(signo==SIGQUIT)
        printf("received SIGQUIT\n");
    else if(signo==SIGBUS)
        printf("received SIGBUS\n");
    else if(signo==SIGUSR2)
        printf("received SIGUSR2\n");
}

void main()
{
	printf("Pid: %d\n",getpid());
	while(1)
	{
		if(signal(SIGUSR1,sig_handler)==SIG_ERR) 
			printf("Not getting SIGUSR1\n\n");

		if(signal(SIGALRM,sig_handler)==SIG_ERR)
			printf("Not getting SIGALRM\n");
			
		if(signal(SIGFPE,sig_handler)==SIG_ERR)
			printf("Not getting SIGFPE\n");

		if(signal(SIGINT,sig_handler)==SIG_ERR)
			printf("Not getting SIGINT\n");

		if(signal(SIGQUIT,sig_handler)==SIG_ERR)
			printf("Not getting SIGQUIT\n");

		if(signal(SIGTERM,sig_handler)==SIG_ERR)
			printf("Not getting SIGTERM\n");

		if(signal(SIGBUS,sig_handler)==SIG_ERR)
			printf("Not getting SIGBUS\n");

		if(signal(SIGUSR2,sig_handler)==SIG_ERR)
			printf("Not getting SIGUSR2\n");
	}
}
