#include<conio.h>
#include<stdio.h>
struct rational
{
	int n,d;
};
struct rational a,b;
float add()
{
	return (a.n*1.0*b.d+b.n*a.d)/(1.0*b.d*a.n);
}
float mult()
{
	return 1.0*a.n*b.n/(1.0*a.d*b.d);
}
void main()
{
	printf("Enter num and den of 1: ");
	scanf("%d",&a.n);
	scanf("%d",&a.d);
	printf("Enter num and den of 2: ");
	scanf("%d",&b.n);
	scanf("%d",&b.d);
	printf("%f\n%f",add(),mult());
}