//dragonxor
#include<stdio.h>
#include<math.h>
int main()
{
	int t,n,c,i,j,k;
	long a,b;
	scanf("%d",&t);
	while(t--)
	{
		c=0;
		scanf("%d %ld %ld",&n,&a,&b);
		if(!(a&(1<<(n-1))))
		{
			a=a|(1<<(n-1));
			c--;
		}
		if(!(b&(1<<(n-1))))
		{
			b=b|(1<<(n-1));
			c--;
		}
		for(i=0;i<n;i++)
		{
			//printf("%ld %ld",a,b);
			if ((a & 1) == 1)
				c++;
			if((b&1)==1)
				c++;
			b=b>>1;
			a=a>>1;
		}
		i=n-c;
		n=pow(2,n)-1;
		for(j=0;j<abs(i);j++)
				n=n&~(1<<j);
		printf("%d\n",n);
			
		//printf("%d",c);
	}
}