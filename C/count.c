//count alpha digit blank special
#include<stdio.h>
#include<string.h>
void main()
{
    char s[20],t;
	int i,n=0,a=0,b=0,spe=0;
	printf("Enter String\n");
	scanf("%s",s);
	for(i=0;i<strlen(s);i++)
	{
		if(s[i]<='9' && s[i]>='0')	//count numbrs
			n++;
		else if((s[i]<='z'&&s[i]>='a')||(s[i]<='Z'&&s[i]>='A'))  //count alpha
			a++;
		else if(s[i]==' ')	//space
			b++;
		else	//special character
			spe++;
	}
	printf("\nSPECIAL:%d  ALPHA:%d  Numeric:%d   Spaces:%d",spe,a,n,b);
}	