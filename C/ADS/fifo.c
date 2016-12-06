/*
Ahmed Sabeeh
2016CS16
*/

/*
Implement FIFO DUP and PIPE between Parent process and a Child process exchanging messages - "How are you? .. I am fine .. Thank You". The parent and the child processes should print their PIDs and PPIDs correspondingly.
*/
#include<stdio.h>
#include <fcntl.h> 
#include<errno.h>
void main()
{
	int fd,pid,err;
	char str[1024];
    char *mfifo = "/home/user/fifoC";
   	err=mkfifo(mfifo, 0666);

	if(err!=0)
	{
		printf("%d Error while creating fifo: %d\n",getpid(),errno);
	}

    pid=fork();
    if(pid==0)
    {
   	    

    	fd=open(mfifo,O_RDONLY);
    	read(fd,str,sizeof(str));
    	printf("Sent By: %d\tReceived By: %d:\t %s\n",getppid(),getpid(),str);
		close(fd);
    	fd=open(mfifo,O_WRONLY);
    	//printf("%d Sending IAF\t\n",getpid());
    	write(fd,"I am fine",sizeof("I am fine"));
		close(fd);
		
    	fd=open(mfifo,O_RDONLY);    	
    	read(fd,str,sizeof(str));
    	printf("Sent By: %d\tReceived By: %d:\t %s\n",getppid(),getpid(),str);
    }
    else
    {
        fd=open(mfifo,O_WRONLY);
		
    	//printf("%d Sending HAY\t\n",getpid());
    	write(fd,"How are you?",sizeof("How are you?"));
		close(fd);
		
		fd=open(mfifo,O_RDONLY);
	   	read(fd,str,sizeof(str));
    	printf("Sent By: %d\tReceived By: %d:\t %s\n",getppid(),getpid(),str);
		close(fd);
		fd=open(mfifo,O_WRONLY);
		//printf("%d Sending TY\t\n",getpid());
    	write(fd,"Thank You",sizeof("Thank You"));
		close(fd);    	
    	wait();
    }   
}
