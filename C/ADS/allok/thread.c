/*
Ahmed Sabeeh
2016CS16
15/09/2016
*/
/*
Write a simple Hello World program in which multiple threads print messages
*/

#include<stdio.h>
#include<pthread.h>

void helloW()
{
	printf("Hello World\n");
}
void main()
{
	int n=20;
	pthread_t thread;
	while(n--)
	{
		pthread_create(&thread, NULL, helloW, NULL);
	}
	pthread_join(thread, NULL);
}

