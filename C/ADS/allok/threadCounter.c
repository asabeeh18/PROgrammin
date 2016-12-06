/*
Ahmed Sabeeh
2016CS16
15/09/2016
*/
/*
Hello World program in which multiple threads print messages and use a shared counter to increment the counter value
*/

#include<stdio.h>
#include<pthread.h>

int count=0;
pthread_mutex_t lock1 = PTHREAD_MUTEX_INITIALIZER;

void helloW()
{
	//Lock 
	pthread_mutex_lock(&lock1);
	
	//Critical Section
	count++;
	printf("Count:%d,Id: %u :Hello World\n",count,pthread_self());

	//Release
	pthread_mutex_unlock(&lock1);
}
void main()
{
	int n=20;
	pthread_t thread;
	while(n--)
	{
		pthread_create(&thread, NULL, helloW,NULL);
	}
	pthread_join(thread, NULL);
}

