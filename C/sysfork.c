#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

int i = 0;
void createchild()
{
  printf("my pid is %d and my parent pid is %d \n",getpid(), getppid());
  
  if(i == 4)
    return;
    i++;
  if(fork() == 0)
  {
    createchild();
    //sleep(1);
  }
}

int main()
{
  createchild();
  return 0;
}