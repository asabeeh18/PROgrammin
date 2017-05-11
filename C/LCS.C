#include<stdio.h>
#include<conio.h>
#include<math.h>

struct lcsarray
{
	int value[100];
	char symbol[100];
};
char diagonal,up,left;
char x[100],y[100];

void lcsprint(struct lcsarray l,int i,int j)
{
	if(i==0 || j==0)
		return;
	if(l.symbol[i,j]==diagonal)
	{
		lcsprint(l,i-1,j-1);
		printf("%c",&x[i]);					//print karneka character
	}
	else
	if(l.symbol[i,j]==up)
		lcsprint(l,i-1,j);
	else
		lcsprint(l,i,j-1);
}


struct lcsarray lcslength(struct lcsarray l,int m,int n)
{
	int i,j;

	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			if(x[i]==y[i])				//match found
			{
				l.value[i,j]=l.value[i-1,j-1] + 1;		//diagonal + 1 kiya
				l.symbol[i,j]=diagonal;
			}
			else
			if(l.value[i-1,j]>=l.value[i,j-1])			//upar wali value left wale se jyada hai
			{
				l.value[i,j]=l.value[i-1,j];			//upar wale ki value daal di
				l.symbol[i,j]= up;
			}
			else
			{
				l.value[i,j]==l.value[i,j-1];
				l.symbol[i,j]=left;
			}
	return l;
}

void main()
{
	int m,n,i,j;
	char fake;
	struct lcsarray l,ans;
	clrscr();
	printf("Enter no. of elements in 1st n 2nd string\n");
	scanf("%d %d",&m,&n);
	printf("Enter string 1 \n");
	for(i=0;i<m;i++);
		scanf("%c",&x[i]);
	printf("Enter string 2\n");
	scanf("%c",&fake); 							 //to catch the enter
	for(j=0;i<n;j++);							//input
		scanf("%c",&y[i]);
	for(i=0;i<m;i++)
		l.value[i,0]=0;							//initialize
	for(j=0;j<n;j++)
		l.value[0,j]=0;
	ans=lcslength(l,m,n);							//function called for operating on strings
	lcsprint(ans,m,n);						//ans print karne ko
	getch();
}