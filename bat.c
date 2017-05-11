#include <stdio>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int n, k, i, max, pos, fix, cost=0, difer;
    int num[104], freq[10], dif[104];
    
    scanf("%d %d", &n, &k);
    for(i=0; i<n; i++)
        scanf("%d", &num[i]);
    
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
    }
    
    for(i=0; i<n; i++)
        dif[i]=abs(pos-num[i]);
    
    fix=k-max;
    for(i=0; i<n; i++)
    {
        while(fix!=0)
        {
			if(dif[i]>=1 && dif[i]<=9)
			{
				fix--;
				num[i]=pos;
				cost+=dif[i];
			}
        }
    }
    
    printf("%d\n", cost);
    for(i=0; i<n; i++)
        printf("%d", num[i]);
   
    return 0;
}
