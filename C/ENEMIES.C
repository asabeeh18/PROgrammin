#include<stdio.h>
void main()
{
    int t,w[30],l[30],c=0,s=0,j,i,te;
//    printf("\n%d",c);
    scanf("%d",&t);
    for(i=0;i<t;i++)
	scanf("%d %d",&w[i],&l[i]);
  //  printf("\n%d",c);
	for(i=0;i<t-1;i++)
		for(j=0;j<t-i-1;j++)
		{	if(((float)w[j]/l[j])<((float)w[j+1]/l[j+1]))
			{
				te=w[j];
				w[j]=w[j+1];
				w[j+1]=te;

				te=l[j];
				l[j]=l[j+1];
				l[j+1]=te;
			}
		}
for(i=0;i<t;i++)
    printf("%d %d \n",w[i],l[i]);
	for(i=0;i<t;i++)
	{
		s+=l[i];
		c+=s*w[i];
	}
	printf("\n%d",c);
}
