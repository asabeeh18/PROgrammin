#include<stdio.h>
#include<malloc.h>
struct Node
{
int p_id;                               
int p_at;                                
int p_bt;                               
int p_wt;                              
int p_tt;                                
struct Node *next;
};

struct Node *newrec, *first, *last, *p, *q,*temp,*w;

void sort(int id,int at,int bt)
{
w=first;
while(first!=last)
{
while(w!=last)
{
if((w->p_bt)>=(w->next->p_bt))
{
  temp=(struct Node*)malloc(sizeof(struct Node));
  temp->p_id=id; 
  temp->p_at=at;
  temp->p_bt=bt;
  temp->p_bt=w->p_bt;
  temp->p_at=w->p_at;
  temp->p_tt=w->p_tt;
  w->p_bt=(w->next)->p_bt;
  w->p_at=(w->next)->p_at;
  w->p_tt=(w->next)->p_tt;
  (w->next)->p_bt=temp->p_bt;
  (w->next)->p_at=temp->p_at;
  (w->next)->p_tt=temp->p_tt;
 }
 }
 w=w->next;
 }
first=first->next;
}

void insert(int id, int at, int bt)
{
newrec=(struct Node*)malloc(sizeof(struct Node));
newrec->p_id=id;
newrec->p_at=at;
newrec->p_bt=bt;
newrec->next=NULL;
  if(first==NULL)
  {
    first=newrec;
    last=newrec;
newrec->p_wt=0;
newrec->p_tt=newrec->p_bt-newrec->p_at;
  }
  else
  {
    p=first;
    while(p!=NULL)
    {
newrec->p_wt=(newrec->p_wt+p->p_bt);
      p=p->next;
    }
newrec->p_wt-=newrec->p_at;
    last->next=newrec; 
    last=newrec; q=first;
    while(q!=NULL) 
    {
newrec->p_tt=(newrec->p_tt+q->p_bt);
       q=q->next;
    } 
newrec->p_tt-=newrec->p_at;
   }
}

void display()
{
  p=first; 
  while(p!=NULL)
  { 
printf("%d ", p->p_id);
printf("%d ", p->p_at);
printf("%d ", p->p_bt);
printf("%d ", p->p_wt);
printf("%d ", p->p_tt);
printf("\n"); p=p->next;
  } 
printf("\n");
}

int main()
{ 
int n, i, at, bt;
printf("Enter No. Of Processes: ");
scanf("%d", &n);
  for(i=1; i<=n; i++)
  { 
printf("Enter Arrival Time For Process %d: ", i);
scanf("%d", &at); 
printf("Enter Burst Time For Process %d: ", i);
scanf("%d", &bt); 
    insert(i,at,bt);
  } 
  display();
  sort(i,at,bt);
  display();
  return 0;
}

