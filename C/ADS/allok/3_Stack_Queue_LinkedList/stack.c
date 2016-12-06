/*
Ahmed Sabeeh
2016CS16

Question: Write program for stack, queue, linked list, and doubly linked list.

Stack using array
*/

#include<stdio.h>
#define N 10
int top=-1;

int push(int *a,int n)
{
    if(top>=N-1)
        return 0;
    top++;
    a[top]=n;
    return 1;
}

int pop(int *a)
{
    int n;
    n=a[top];
    --top;
    return n;
}

void display(int *a)
{
    int i=0;
    if(top<0)
    {
    	printf("No element in stack!");
    }
    for(i=0;i<=top;i++)
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
        printf("1. Push\n2. Pop\n3. Display\n4. Exit\n");
        e=scanf("%d",&ch);
        if(e!=1)
		{
			getchar();
			ch=5;
		}
        switch(ch)
        {
            case 1: printf("Enter the number: ");
                    scanf("%d",&ch);
                    e=scanf("%d",&ch);
					if(e!=1)
					{
						getchar();
						printf("Illegal input!\n");
					}
                    status=push(a,ch);
                    if(status!=1)
                    {
                        printf("Error: Stack overflow!\n");
                    }
                    else
                        printf("Push Success!\n");
                    ch=0;
                    break;
            case 2: if(top==-1)
                    {
                        printf("Error: Stack underflow!\n");
                    }
                    else
                    {
                        ch=pop(a);
                        printf("Popped Element: %d\n",ch);
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
