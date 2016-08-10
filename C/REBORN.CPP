
#include<stdlib.h>
void main()
{
 int i,j;
 for(i=50;i<60;i++)
 {
  for(j=0;j<=25;j++)
  {
   cout<<"http://dl01.mangashare.com/manga/Katekyou-Hitman-Reborn/";
   if(i<100)
   {
     cout<<"0"<<i;
    }
   if(j<10)
   {
     cout<<"/00"<<j;
    }
    if(j>=10)
    {
     cout<<"/0"<<j;
     }
    cout<<".jpg\n";
   }
  }

 }