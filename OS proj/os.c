#include<stdio.h>
#include<malloc.h>
struct node
{
    int id,burst,arrv;
    struct node *next;
};
//mode 1=Q 2=Stack
struct node *front=NULL;
struct node *rear=NULL;
int time=0;
int num=0;
//front=NULL;
//rear=NULL;
void insert()
{
    int a,b;
    struct node *newrec;
	printf("Enter Burst time and arrival time");
	scanf("%d %d",b,a);
	newrec=(struct node*)(malloc(sizeof(struct node)));
	newrec->burst=b;
	newrec->arrv=a;
	newrec->next=NULL;
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
	num++;
}

int** copyLL()
{
	//pid burst arrv
	int **a,i=0;
	struct node *f=front;
	a=(int**)malloc(num*sizeof(int *));
		//for(i=0;i<num;i++)
			
	while(f!=NULL)
	{
		a[i]=(int*)malloc(3*sizeof(int));
		a[i][0]=f->id;
		a[i][1]=f->burst;
		a[i][2]=f->arrv;
		i++;
	}
	return a;
}

void gantz(int a[][3],int strt[],int end[])
{
	int t=0,i;
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
void sort(a[][3])
{
	int i,j,*t;
	for(i=0;i<n;i++)
		for(j=0;j<n-i-1;j++)
			if(a[i][2]>a[i+1][2])
			{
				t=a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
}
void rr(int a[][3])
{
	int i=0,time=0;
	sort(a);
	while(notEmpty() || a[i][2]>=time)
	{
		if(time==a[i][2])
		{
			wait[i]=0;
			insertQ(i);
			i++;
			strt[i]=time;
		}
		if(notEmpty())
		{
			x=delQ();
			wait[x]++
			printf("%cP%d",5,a[x][0]);
			a[x][1]--;
			time++;
			if(a[x][1]!=0)
			{
				insertQ(x);
				end[x]=time;
			}
			i++;	
		}
	}
}


void fifo(int *a[3])
{
	int time=0,i,j;
	sort(a);
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

void display(int *a[3])
{
	int i;
	for(i=0;i<num;i++)
		printf("%d-",a[i][0]);
}
int main()
{
	int ch=0,**a;
	while(ch!=4)
	{
		printf("1.Insert\n2.Display\n");
		scanf("%d",ch);
		switch(ch)
		{
			case 1:insert();
					break;
			case 2: a=copyLL();
                     display(a);
					break;
			case 4: break;
			default: printf("Wrong choice try again");
		}
	} 	
}