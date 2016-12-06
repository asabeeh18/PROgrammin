/*
Ahmed Sabeeh
2016CS16
*/

/*
Implement FIFO DUP and PIPE between Parent process and a Child process exchanging messages - "How are you? .. I am fine .. Thank You". The parent and the child processes should print their PIDs and PPIDs correspondingly.
*/
#include<stdio.h>
void main()
{
	int fd1[2],fd2[2],pid;
	char *str[1024];
    int err=pipe(fd1);
    
    if(err!=0)
    {
    	printf("Error while creating pipe");
    }
    err=pipe(fd2);
    pid=fork();
    if(pid==0)
    {
    	close(fd1[0]);
    	close(fd2[1]);    	
    	read(fd2[0],str,sizeof(str));
    	printf("Sent By: %d\tReceived By: %d:\t %s\n",getppid(),getpid(),str);


    	write(fd1[1],"I am fine",sizeof("I am fine"));
    	
    	read(fd2[0],str,sizeof(str));
    	printf("Sent By: %d\tReceived By: %d:\t %s\n",getppid(),getpid(),str);

    }
    else
    {
    	close(fd1[1]);
    	close(fd2[0]);    	
    

    	write(fd2[1],"How are you?",sizeof("How are you?"));
		
	   	read(fd1[0],str,sizeof(str));
    	printf("Sent By: %d\tReceived By: %d:\t %s\n",getppid(),getpid(),str);
		

    	write(fd2[1],"Thank You",sizeof("Thank You"));

    }
}
