/*
Ahmed Sabeeh
2016CS16
15/09/2016
*/
/*
3. Hello World program with a Controlled Order
*/

#include<stdio.h>
#include<pthread.h>
#include<errno.h>
#define N 10
int count=0;
int flag=0;
pthread_mutex_t lock1 = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t CV = PTHREAD_COND_INITIALIZER;

void helloW(int id)
{
//	pthread_t id=pthread_self();
	pthread_mutex_lock(&lock1);
	if(id%2!=0)
	{
		while(count<N/2)
		{
			printf("%d Waiting...\n",id);
			pthread_cond_wait(&CV,&lock1);
		}
	}
	//Critical Section
	count++;
	printf("Count:%d,Id: %d :Hello World\n",count,id);
	
	//at 10 All evens will be done
	if(count>=N/2 && flag==0)
	{
		pthread_cond_broadcast(&CV);
		flag=1;
	}
		
	//Release Lock
	pthread_mutex_unlock(&lock1);
    pthread_exit(NULL);
}
void main()
{
	int n=N,i,err;
	pthread_t thread[n];
	for(i=0;i<n;i++)
	{
		err=pthread_create(&thread[i], NULL, helloW, i);
		if(err!=0)
			printf("\nError Creating Thread:%d !!,%d\n",i,errno);
	}
	//Wait for all threads to complete
	for(i=0;i<n;i++)
		pthread_join(thread[i], NULL);
}

