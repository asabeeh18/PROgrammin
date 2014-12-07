#include<stdio.h>
#include<stdlib.h>
void main()
{ 
  int a[10],n,f,i,m,e,b;
  printf("\n Enter the number of elements in the array : ");
  scanf("%d",&n);
  for(i=0;i<n;i++)
     { 
      printf("Enter the %d element of array : ",i+1);
      scanf("%d",&a[i]);
     }
  printf("\n Enter the number to be searched in the array : ");
  scanf("%d",&f);
  b = 0;
  e = n-1;
  m = (b+e)/2;
  while(b<=e)
    { 
     if(a[m]==f)
        {
         printf("\n Element present at %d position  ",m+1);
         exit(0);
        }
     else if(f>a[m])
        { b = m;
          e = n-1;
          m = (b+e)/2;
       }
      else 
         {
          b = 0;
          e = m;
          m = (b+e)/2;
         }
   }
 if(b>e) printf("\n Element not present");
}
