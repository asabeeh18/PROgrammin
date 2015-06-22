#include<stdio.h>
#include<malloc.h>
#include<stdio.h>
int **a;
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
    int x,b;
    struct node *newrec;
    printf("Enter Burst time and arrival time");
	scanf("%d %d",&b,&x);
	newrec=(struct node*)(malloc(sizeof(struct node)));
	newrec->burst=b;
	newrec->arrv=x;
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
void display()
{
	int k;
	printf("dis[");
	for(k=0;k<n;k++)
		printf("%d,%d,%d-",a[k][0],a[k][1],a[k][2]);
}
void copyLL()
{
	//pid burst arrv

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
}


void sort()
{
	int i,j,*t;
	for(i=0;i<n;i++)
	{
//		printf("%d==\n",i);
		for(j=0;j<n-1;j++)
		{
		       //	printf("\ntry: %d %d\n",n,j);
			if(a[j][2]>a[j+1][2])
			{
  //				printf("sorting\n");
				t=a[j];
				a[j]=a[j+1];
			a[j+1]=t;
    //				printf("\nafter: %d %d\n",a[j][2],a[j+1][2]);
			}
			else
			{
      //				printf("\n%d %d\n",a[j][2],a[j+1][2]);
			}
		}
       //	display();
	}
       //	display();
	//free(t);
	//display();
       //	printf("\nDONE\n");
       //	display();
}

void gantz(int strt[],int end[])
{
	int t=0,i;
	printf("\nGANTT CHART");
	printf("\n");
	for(i=0;i<n;i++)
	{
		while(t!=strt[i])
		{
			t++;
			printf("_");
		}
		printf("| P%d",a[i][0]);
		while(t!=end[i])
		{
			t++;
			printf("_");
		}
	}
}


void fifo()
{
	int time=0,i,j;
	int *strt,*end,*wait,*turn;
	strt=(int *)malloc(n*sizeof(int));
	wait=(int *)malloc(n*sizeof(int));
	turn=(int *)malloc(n*sizeof(int));
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
	gantz(strt,end);
	for(i=0;i<n;i++)
		printf("\nProcess ID: %d\nWaiting Time: %d\nTurnaround Time: %d\n",a[i][0],wait[i],turn[i]);
}



int all0()
{
	int i=0;
	for(i=0;i<n;i++)
	    if(a[i][1]!=-1)
	    return 0;
	return 1;
}
void sjf()
{

	int j,k,b=1;
	int t=0;
	int s=0,i;
	int *wait,*turn;
	wait=(int *)malloc(n*sizeof(int));
	turn=(int *)malloc(n*sizeof(int));
	for(i=0;i<n;i++)
		wait[i]=0;
	printf("\nGANTT CHART");
	printf("\n");
	while(t!=a[0][2])
	{
		printf("_");
		t++;
	}
	while(all0()==0)
	{
		j=0;
		while(j!=n && a[j][2]<=t)
		{
			while(a[s][1]==-1)
			{
			       s++;
			       if(s==n)
				s=0;
			}
			k=(a[s][1]<a[j][1])?s:j;
			if(a[k][1]!=-1)
				s=k;
			j++;
		}
		for(i=0;i<n;i++)
			if(a[i][2]<=t && i!=s && a[i][2]!=-1)
				wait[i]++;
		if(b==s)
			printf("_");
		else
			printf("| P%d_",a[s][0]);
		a[s][1]--;
	//	printf("a[s][0]\n");
		if(a[s][1]==0)
		{
			a[s][1]=-1;
			turn[s]=t-a[s][2];
		}
		b=s;
		t++;
	}
	for(i=0;i<n;i++)
		printf("\nProcess ID: %d\nWaiting Time: %d\nTurnaround Time: %d\n",a[i][0],wait[i],turn[i]);

}

//Free up Memory
void clean()
{
	int i;
	for(i=0;i<n;i++)
		free(a);
	free(a);
}
int main()
{
	int ch=0;
	clrscr();
	while(ch!=4)
	{
		printf("1.Insert\n2.FIFO Schedule\n3.SRT Schedule 4.Exit\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:insert();
					break;
			case 2:
					copyLL();
					sort();
					fifo();
					clean();
					break;
			case 3:
					copyLL();
					sort();
					sjf();
					clean();
					break;
			case 4: break;
			default: printf("Wrong choice try again");
		}
	}
	return 1;
}