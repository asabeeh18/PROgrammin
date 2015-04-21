//shift reduce parser
#pragma warning (disable : 4996)
#include<stdio.h>
#include<malloc.h>
#include<string.h>
char stack[10];
int st = -1, n;
char *(*pro), *(*var);
void match(int);
int main()
{
	int i;
	char s[10];
	printf("Enter the number of productions: ");
	scanf("%d", &n);
	pro = (char**)malloc(sizeof(char*));
	var = (char**)malloc(sizeof(char*));
	printf("Enter the productions on LEFT and RIGHT sides one at a time:\n");
	for (i = 0; i < n; i++)
	{
		pro[i] = (char*)malloc(sizeof(char));
		var[i] = (char*)malloc(sizeof(char));
		scanf("%s", var[i]);
		printf("->");
		scanf("%s", pro[i]);
	}
	printf("Enter input string: ");
	scanf("%s", s);
	i = 0;
	//Start processing

	do
	{
		stack[++st] = s[i];
		printf("%s\n", stack);
		match(1);
		i++;
	} while (s[i] != '\0');


	//reduction
	i = 1;
	while (st >= 0)
	{
		st--;
		i++;
		match(i);
		printf("%s\n", stack);
	}
	if (stack[0] == var[0][0])
		printf("Accepted");
	while (1);
	return 0;
}
//matches k characters of stack with productions
void match(int k)
{
	int i;

	for (i = 0; i < n; i++)
		if (!(strncmp(&stack[st], pro[i], k)))
		{
		strncpy(&stack[st], var[i], k);
		st -= k - 1;	//tentative
		i = -1;
		if (k == 1)
			return;
		}
}