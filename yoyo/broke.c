#include<stdio.h>
int main()
{
    int l=0;
    float b,s,n;
    float r,broke,servtx,stt,stamp_regu,profit,pay=0;
    l=scanf("%f\n%f\n%f\n%f",&r,&b,&s,&n);
    //printf("%f %f %f %f %d\n",r,b,s,n,l);
    if(l<4)
    {
        printf("Invalid Input");
        return 0;
    }
	broke=b*r/100.0;
	servtx=10.36*broke/100;
	stt=0.025*s/100;
	pay=n*(broke+servtx+stt);
	broke=s*r/100;
	servtx=10.36*broke/100;
	stamp_regu=0.006*(b+s)/100;
	pay+=n*(broke+servtx+stamp_regu);
	profit=n*(s-b);
   // printf("\n%f %f \n",pay,profit);
	if(profit<0)
		printf("Loss\n%.2f",pay+(-profit));
	else
	{
		if(profit>pay)
			printf("Profit\n%.2f",profit-pay);
		else
			printf("Loss\n%.2f",pay-profit);
	}
    return 0;
}
