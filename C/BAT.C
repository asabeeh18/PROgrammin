#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int n, k,x,minpoz, i,j, max,tmp, pos, fix, cost=0, difer;
    int ordr[104],num[104], freq[10], dif[104];
    char s[104];
    scanf("%d %d", &n, &k);
    fflush(stdin);
    scanf("%s",s);
    for(i=0; i<n; i++)
		num[i]=s[i]-'0';
        //scanf("%d", &num[i]);
    
    for(i=0; i<10; i++)
        freq[i]=0;
    
    for(i=0; i<n; i++)
		if(num[i]>=0 && num[i]<=9)
			freq[num[i]]++;
    max=freq[i];
    for(i=1; i<10; i++)
    {
		if(freq[i]>max)
		{
			max=freq[i];
			pos=i;
		}
		else if(freq[i]==max)
			if(pos>i)
			{
				pos=i;
				max=freq[i];
			}
    }
    for(i=0; i<n; i++)
	{
		dif[i]=abs(pos-num[i]); //pos-num[i]
		ordr[i]=i;
			for(j=i;j>0;j--)
			{
				if(dif[ordr[j]]<dif[ordr[j-1]])
				{
					tmp=ordr[j];
					ordr[j]=ordr[j-1];
					ordr[j-1]=tmp;
				}
				else if(dif[ordr[j]]==dif[ordr[j-1]])
					if(ordr[j]>ordr[j-1])
					{
						tmp=ordr[j];
						ordr[j]=ordr[j-1];
						ordr[j-1]=tmp;
					}
	}	
    fix=k-max;
	k=1;
	while(fix!=0 && k<=n)
    {
			if(num[n-ordr[k]]!=pos)
			{
				fix--;
				num[n-ordr[k]]=pos;
				cost+=dif[n-ordr[k]];
				k++;
			}
			else
				k++;
	}

    printf("%d\n", cost);
    for(i=0; i<n; i++)
	printf("%d", num[i]);
    return 0;
}
