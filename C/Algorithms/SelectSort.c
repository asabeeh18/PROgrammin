#include<stdio.h>
#include<conio.h>
void select(int a[],int n)
{
int i,j,max,temp;
for(i=n-1;i>=0;i--)
 {
  max=0;
  for(j=1;j<=i;j++)
   {
    if(a[max]<a[j])
     max=j;
   }
 temp=a[max];
 a[max]=a[i];
 a[i]=temp;
 }
}
void show(int a[],int n)
{
int i;
printf("The sorted series is:\n");
for(i=0;i<n;i++)
 {
  printf("%d  ",a[i]);
 }
}
void main()
{
int b[20],i,n,temp;
clrscr();
printf("Enter the value of n:\n");
scanf("%d",&n);
printf("Enter the array:");
for(i=0;i<n;i++)
 {
  scanf("%d",&temp);
  b[i]=temp;
  printf("%d ",b[i]);
 }
select(b,n);
show(b,n);

getch();
}