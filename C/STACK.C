//Stack Implememtation
#include<stdio.h>
#define M 50
struct stack
{
	int a[M];
	int topa,topb;
};
void push(int x,struct stack *s,int n)
{
	if(n==1)
	{
		if(s->topa!=s->topb)
			s->a[++(s->topa)]=x;
		else 
			printf("Stack FULL");
	}
	if(n==2)
	{
		if(s->topa!=s->topb)
			s->a[--(s->topb)]=x;
		else 
			printf("Stack FULL");
	}
}
int pop(struct stack *s,int n)
{
	if(n==1)
		return s->a[s->topa--];
	return s->a[s->topb++];
}
void display(struct stack *s,int n)
{
	int i;
	if(n==1)
		for(i=0;i<=s->topa;i++)
			printf("%d ",s->a[i]);
	if(n==2)
		for(i=M-1;i>=s->topb;i--)
			printf("%d ",s->a[i]);
}
void main()
{
	int num,ch;
	struct stack s;
	s.topa=-1;
	s.topb=M;
	do{
		printf("\n************Enter Your Choise************ \n 1:PushOne \n 2:Push2 \n 3:Pop1 \n 4: Pop2\n 5:Display1 \n6:Display2\n7:Exit");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: printf("\nEnter an intger\n");
					scanf("%d",&num);
					push(num,&s,1);
					break;
			case 2: printf("\nEnter an intger\n");
					scanf("%d",&num);
					push(num,&s,2);
					break;
			case 3: if(s.topa!=-1)
					{
						num=pop(&s,1);
						printf("Popped Element is: %d",num);
					}
					else
						printf("Empty Stack Selected");
					break;
			case 4:
					if(s.topb!=M)
					{
						num=pop(&s,2);
						printf("Popped Element is: %d",num);
					}
					else
						printf("Empty Stack Selected");
					break;
			case 5: display(&s,1);
					break;
			case 6: display(&s,2);
					break;
			case 7: break;
			default: printf("\nInvalid Choice");
		}
	}while(ch!=7);
}