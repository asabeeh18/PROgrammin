/*
Ahmed Sabeeh
2016CS16
*/
/*
Q1. Write C program for Longest Common Subsequence.
*/
#include<stdio.h>
#include<math.h>
#define N 4

int board[20],count;

void printBoard(int n)
{
	int i,j;
	printf("\nSolution: %d\n",++count);

	for(i=1;i<=n;++i)
		printf("\t%d",i);
	for(i=1;i<=n;++i)
	{
		printf("\n\n%d",i);
		for(j=1;j<=n;++j) //for nxn board
		{
			if(board[i]==j)
				printf("\tQ"); //queen at i,j position
			else
				printf("\t-"); //empty slot
		}
	}
}
 
int place(int row,int column)
{
	int i;
	for(i=1;i<=row-1;++i)
	{
		//column conflict
		if(board[i]==column)
			return 0;
		//diagonal conflict	
		else if(abs(board[i]-column)==abs(i-row))
			return 0;
	}
	return 1; //safe
}
 

void queen(int row,int n)
{
	int column;
	for(column=1;column<=n;++column)
	{
		//safe for queen?
		if(place(row,column))
		{
			board[row]=column; 
			if(row==n) //finished
				printBoard(n); //printing the board configuration
			else //try queen with next position
				queen(row+1,n);
		}
	}
}
void main()
{
	int n,i,j;

	n=N;
	queen(1,n);
	printf("\n");
}
