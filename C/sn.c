#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void bubblesort(int num[], int n)
{
    int i, j, t;
    for(i=n-2; i>=0; i--)
    {
        for(j=0; j<=i; j++)
        {
            if(num[j]>num[j+1])
            {
                t=num[j];
                num[j]=num[j+1];
                num[j+1]=t;
            }
        }
    }

}

int main() {

    int n, i, a, b, f, l;
    int num[100000];
    int dev[100000];
    float mean=0, stdev=0;
    int fix=0;
    
    scanf("%d", &n);
    for(i=0; i<n; i++)
        scanf("%d", &num[i]);
    
    bubblesort(num,n);

    for(i=0; i<n; i++)
        mean+=num[i];
    mean=mean/n;
    
    for(i=0; i<n; i++)
        stdev+=pow((num[i]-mean),2);
    stdev=stdev/n;
    stdev=sqrt(stdev);
    
    for(i=0; i<n; i++)
        dev[i]=(int)abs(stdev-num[i]);
    
    f=0;
    l=n-1;
    a=num[f];
    b=num[l];
    
    while(2*a<b)
    {
        if(dev[f]>dev[l])
        {
            f++;
            fix++;
        }
        else
        {
            l--;
            fix++;
        }
        a=num[f];
        b=num[l];
    }
    
    printf("\n%d", fix);
    
    return 0;
}
