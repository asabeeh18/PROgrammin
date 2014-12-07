#include<iostream.h>
#include<conio.h>
//--------------------------GLOBAL-DECLARATIONS
cost m=3;
//--------------------------END-GLB-DCL--------
//---------------------------CLASS
class xAnd_0
{
 public:
     char s[m][m];
     int chk[m][m],i,j;
     build();
     start();
     accept();
     win()
     winchk();
     aI();    //Artificial Intelligence
          //----------------------------------BLANK     
     xAnd_0           //Constructor
     { 
      for(i=0;i<3;i++)
      {
       for(j=0;j<3;j++)
       {
        s[i][j]='';
        chk[i][j]=0;
       } 
      }
     }            //End-Constr-------
};       //------------------END-CLASS----------

//-------------------------------MANY---------FUNCTIONS------------------\\
//

        //----------------------------------BLANK 
   //  -------------------BUILD       
void xAnd_0::build()
{
  cout<<"\t1\t2\t3";
 for(i=0;i<3;i++)
 {
  for(j=0;j<3;j++)
  {
   if(ch[i][j]!=1)
   {
    cout<<"_";
   }
   else
   {
    cout<<s[i][j];
   }
   if(j!=2)
   {
    cout<<"|";
   }
  }
 }
}
//------------------------END----BUILD----------------------------

  

