/*
Ahmed Sabeeh
2016CS16

Question: Write program for stack, queue, linked list, and doubly linked list.
Queue using array
*/
#include<stdio.h>
#define N 10

int rear=-1,front=-1;

int insert(int *a,int n)
{
    if(rear>=N-1)
        return 0;
    if(front==-1)
        front++;
    rear++;
    a[rear]=n;
    return 1;
}

int delete(int *a)
{
    int n,i;
    n=a[front];
    for(i=0;i<rear;i++)
        a[i]=a[i+1];
    rear--;
    return n;
}

void display(int *a)
{
    int i=0;
    if(rear<0)
    {
    	printf("No element in Queue!");
    }
    for(i=0;i<=rear;i++)
    {
        printf("%d ",a[i]);
    }
    printf("\n");    
}

void main()
{
    int a[N],ch=0,status,e;
    while(ch!=4)
    {
        printf("1. Insert\n2. Delete\n3. Display\n4. Exit\n");
        e=scanf("%d",&ch);
        if(e!=1)
		{
			getchar();
			ch=5;
		}
        switch(ch)
        {
            case 1: printf("Enter: ");
                    scanf("%d",&ch);
                    if(e!=1)
					{
						getchar();
						printf("Error! Illegal input");
						break;
					}
                    status=insert(a,ch);
                    if(status!=1)
                    {
                        printf("Error: Queue overflow!\n");
                    }
                    else
                    	printf("Insert Success!\n");
                    ch=0;
                    break;
            case 2: if(rear==-1)
                    {
                        printf("Error: Queue underflow!\n");
                    }
                    else
                    {
                        ch=delete(a);
                        printf("Removed Element: %d\n",ch);
                        ch=0;
                    }
                    
                    break;
            case 3: display(a);
                    break;
            case 4: break;
            default: printf("Try Again!");
                            
        }
    }
}
