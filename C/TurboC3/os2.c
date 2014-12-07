#include<stdio.h>
#include<malloc.h>
#define un 63000
struct node
{
    int id,burst,arrv;
    struct node *next;
};
//mode 1=Q 2=Stack
struct node *front=NULL;
struct node *rear=NULL;
int time=0;
int n=0;
//front=NULL;
//rear=NULL;
void insert()
{
    int a,b;
    struct node *newrec;
    printf("Enter Burst time and arrival time");
	scanf("%d %d",&b,&a);
	newrec=(struct node*)(malloc(sizeof(struct node)));
	newrec->burst=b;
	newrec->arrv=a;
	newrec->next=NULL;
	newrec->id=++n;
	if(front==NULL)
	{
		front=newrec;
		rear=newrec;
	}
	else
	{
		rear->next=newrec;
		rear=newrec;
	}
}
void display(int *a[])
{
	int i;
	printf("dis[");
	for(i=0;i<n;i++)
		printf("%d,%d,%d-",a[i][0],a[i][1],a[i][2]);
}
int** copyLL()
{
	//pid burst arrv
	int **a;
	int i=0;
	struct node *f=front;
	a=(int**)malloc(n*sizeof(int *));
		//for(i=0;i<n;i++)
			
	while(f!=NULL)
	{
		
		a[i]=(int*)malloc(3*sizeof(int));
		a[i][0]=f->id;
		a[i][1]=f->burst;
		a[i][2]=f->arrv;
		i++;
		f=f->next;
	}
	return a;
}

void gantz(int *a[],int strt[],int end[])
{
	int t=0,i;
	printf("\n");
	if(strt[0]==0)
		printf("%c",5);
	for(i=0;i<n;i++)
	{
		while(t!=strt[i])
		{
			t++;
			printf("_");
		}
		printf("|P%d",a[i][0]);
		while(t!=end[i])
		{
			t++;
			printf("_");
		}
	}
}

int** sort(int *a[])
{
	int i,j,*t;
	for(i=0;i<n;i++)
	{
		printf("%d==\n",i);
		for(j=0;j<n-1;j++)
		{
			printf("\ntry: %d %d\n",n,j);
			if(a[j][2]>a[j+1][2])
			{
				printf("sorting\n");
				t=a[j];
				a[j]=a[j+1];
		    	a[j+1]=t;
				printf("\nafter: %d %d\n",a[j][2],a[j+1][2]);
			}
			else
			{
				printf("\n%d %d\n",a[j][2],a[j+1][2]);
			}
		}
        display(a);
	}
	free(t);
	printf("\nDONE\n");
    return a;
}

void fifo(int *a[])
{
	int time=0,i,j;
	int strt[n],end[n],wait[n],turn[n];
	//sort(a);
	for(i=0;i<n;i++)
	{
		if(a[i][2]>time)
			time=a[i][2];
		strt[i]=time;
		wait[i]=time-a[i][2];
		time+=a[i][1];
		turn[i]=time-a[i][2];
		end[i]=time;
	}
	gantz(a,strt,end);
}

int main()
{
	int ch=0,**a;
	while(ch!=4)
	{
		printf("1.Insert\n2.Display\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:insert();
					break;
					
			case 2: 
                    printf("IN");
					a=copyLL();
					display(a);
                    printf("COPIES");
					a=sort(a);
					printf("displd");
					display(a);
					 
					 fifo(a);
	//				 rr(a);
					break;
			case 4: break;
			default: printf("Wrong choice try again");
		}
	} 	
}