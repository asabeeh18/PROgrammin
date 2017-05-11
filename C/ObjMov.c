//Object MOver
#include<stdio.h>
#include<conio.h>
int cx=0,cy=0;
void display()
{
	int i;
	for(i=0;i<cy;i++)
		printf("\n");
	for(i=0;i<cx;i++)
		printf(" ");;
	printf("!");
}	
void move(char ch)//move will return 1 upon successfull move(no collision) in later stages
{
	//insert collison module
	if(ch=='w')
		cy--;
	else if(ch=='a')
		cx--;
	else if(ch=='s')
		cy++;
	else if(ch=='d')
		cx++;
	else{}
	return;
}	
int main()
{
	char ch;
	printf("!");
	while(ch!='x')
	{
		ch=getch();
		move(ch);//later stage if move retruns 1 only den clrscr
		//clrscr();
		display();
	}
	return 0;
}	