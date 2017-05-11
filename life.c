#include<stdio.h>
#include<string.h>
void main()
{
    char s1[100],s2[100];
    int a[100][100],i,j,ind=-1,m=-1,k;
   // printf("7");
	scanf("%s %s",&s1,&s2);
    //printf("9");
	for(i=0;i<strlen(s2);i++)
	{
		for(j=0;j<strlen(s1);j++)
		{
      //      printf("12");
			k=0;
			if(s2[i+k]==s1[j+k])
			{
		//	    printf("16");
                while(s2[i+k]==s1[j+k] && (i+k)<strlen(s2))
					k++;
          //      printf("19");
				a[i][j]=k;
			}
		}
	}
	for(i=0;i<strlen(s2);i++)
		for(j=0;j<strlen(s1);j++)
			if(m<a[i][j])
			{
				m=a[i][j];
				ind=i;
			}
	for(i=ind;i<(ind+m);i++)
	{
		printf("%c",s2[i]);
	}
	printf("\n%d",m);
	
}