#include<stdio.h>
int main()
{
    int test,n,k,cnt=0,i,a;
	scanf("%d",&test);
	while(test--)
	{
		scanf("%d%d",&n,&k);
        cnt=0;
		for(i=0;i<n;i++)
		{
			scanf("%d",&a);
			if(a%2==0)
			{
                if(++cnt==k)
				{
					printf("YES\n");
					break;
				}
		    }  
			else
				cnt=0;
		}
		if(i==n)
            printf("NO\n");
	}
}