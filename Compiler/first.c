//Basic First only for 1 to 1 productions no support for epsilon
#include<stdio.h>
#include<malloc.h>
#include<ctype.h>
char *(*s);
int n;

int findRow(char c)
{
	int i;
	for(i=0;i<n;i++)
	{
		if(s[i][0]==c)
			return i;
	}
	printf("FAULT: %d "+c);
	return -1;
}

void first(int i)
{
	if(isupper(s[i][3]))
		//insert for loop for expansion pack loop thorugh DS
		first(findRow(s[i][3]));
	
	else
		printf("%c\n",s[i][3]);
}

int main()
{
	
	int i;
	printf("Number of Productions: ");
	scanf("%d", &n);
	s = (char**)malloc(n*sizeof(char*));
	printf("Format A->ABC\n");
	for (i = 0; i<n; i++)
	{
		s[i] = (char*)malloc(n*sizeof(char));
		scanf("%s", s[i]);
	}
	/*insert tokeniser here  for expansion pack 
	tokenise on '|' store in a DS
	*/
	for(i=0;i<n;i++)
	{
		printf("First of %c:",s[i][0]);
		first(i);
	}
	return 1;
}