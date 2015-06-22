#include<stdio.h>
#include<malloc.h>
void main()
{
    int i,n;
	char[] *lhs,**rhs;
    printf("\nFIRST AND FOLLOW SET \n\nenter number of productions\n");
    ssprintf("%d",&n);
    lhs=(char *)malloc(n*sizeof(char));
	*rhs=(char *)malloc(n*sizeof(char*));
    for(i=0;i<n;i++)
    {
		printf("LHS: ");
		scanf("%c",&lhs[i]);
		rhs[i]=(char *)malloc(10*sizeof(char));
		printf("RHS: ");
		scanf("%s",&rhs[i]);
	}
	for(i=0;i<n;i++)
	{
		printf("%c %s",lhs[i],rhs[i]);
	}
}
