#include<stdio.h>
#include<math.h>
void main()
{
    int i,n;
	float l,r,c,b,x1,x2,a,m1,m2;
	float *x,*y,*z;
	scanf("%d %d %d",&n,&l,&r);
	x=(float*)malloc(n*sizeof(float));
	z=(float*)malloc(n*sizeof(float));
	y=(float*)malloc(n*sizeof(float));
	for(i=0;i<n;i++)
		scanf("%f %f %f",&x[i],&y[i],&z[i]);
	for(i=0;i<n-1;i++)
	{
        if(x[i]<l)
            continue;
        if(x[i+1]>r)
            break;
		x1=x[i]+y[i]*tan(z[i]/180.0);
		x2=x[i+1]-y[i+1]*tan(z[i+1]/180.0);
		m1=(x1-x[i])/(0-y[i]);
		m2=(x2-x[i+1])/(0-y[i+1]);
		a=(-m2*x[i+1]+y[i+1]-(-m1*x[i]+y[i]))/(m1-m2);
		b=m1*a-m1*x[i]+y[i];
		c=c<b?c:b;
	}
	printf("%f %d",(double)c,c);
}