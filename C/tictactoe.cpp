/*
Syed Mehroz Alam
CIS-61, First Year, Sec-A, Batch 2002-03
Computer & Information Systems Dept,
NED University, Karachi, Pakistan.
Email: smehrozalam@yahoo.com

13-June-2003
*/

#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>

#define ENTER_KEY '\r'
#define ESCAPE_KEY 27
#define SPECIAL_KEY 0
#define UP_ARROW 72
#define DOWN_ARROW 80
#define LEFT_ARROW 75
#define RIGHT_ARROW 77
#define pos_cursor(x,y) gotoxy(x*4+2,y*2+2)

// The following two parameters can be changed as per needed
const ORDER=3;		// determines the order of the board
const level=3;		// determines the computer level (1=easiest)


char board[ORDER][ORDER];
int computer=1;
int pos;

//The functions' purposes are evident from their names
void display(void);
void empty_board(void);
void input(int player);
int chkboard(void);	//checks if any player has won
void counter_move(int player, int *best_i, int *best_j, int *best_pos);
void best_move(int player);

void main(void)
{
	clrscr();
	empty_board();

	textcolor(15);
	cprintf("Tic Tac Toe\n\r\n\r");
	cprintf("Made by Syed Mehroz Alam\n\r");
	cprintf("CIS-61, First Year, Batch 2002-03, \n\r");
	cprintf("Computer & Information Systems Dept, \n\rNED University.\n\r" );
	cprintf("Email: smehrozalam@yahoo.com" );
	textcolor(7);


	printf("\n\n\nDo you want to play versus COMPUTER ('n' for no) :");
	char opt=getch();
	if ( opt=='n' || opt=='N') computer=0;

	int player=1, win=0,turn=1;
	display();
	do
	{
		printf("\nPlayer %d move \n", player);
		printf("\nPress arrow keys to move, then press <Enter> to place your mark");
		input(player);
		display();
		win=chkboard();
		player=(player==1)?2:1;
		turn++;
	}
	  while ( win==0 && turn<=ORDER*ORDER );
	if (win) printf("\nPlayer %d won",win);
	else printf("\nDraw");
	printf("\n\nPlay again (y for yes) ");
	opt=getch();
	if ( opt=='y' || opt=='Y')
		main();
	else
		exit(0);
	getch();

}

void empty_board(void)
{
	for (int i=0;i<ORDER;i++)
		for (int j=0;j<ORDER;j++)
			board[i][j]=NULL;
}


void display(void)
{
	clrscr();
	for (int i=0;i<ORDER;i++)
	{
		printf("\n");
		for (int j=0;j<ORDER;j++)
			printf(" %c |", board[i][j]);
		printf("\b \n");

		if (i!=ORDER-1)
			for (j=0;j<ORDER*4-1;j++)
				printf("Ä");
	}
	printf("\nPress Esc to exit\n");
}

void input(int player)
{
	printf("\nPress S for best move");

	if (player==2 && computer==1)
	{
		best_move(player);
		return;
	}

	int x=0,y=0;
	pos_cursor(x,y);		//macro to position cursor at (x,y)th element
	unsigned char key, key2;
	do
	{
		while( ( key=getch())!=ENTER_KEY )
		{
			if (key==ESCAPE_KEY)
				exit(0);
			else if (key=='S' || key=='s')
				{
					best_move(player);
					return;
				}
			else if (key==SPECIAL_KEY)
			{
				key2=getch();
				switch(key2)
				{
					case UP_ARROW: y--; break;
					case DOWN_ARROW: y++; break;
					case LEFT_ARROW: x--; break;
					case RIGHT_ARROW: x++; break;
				}
				if (x<0) x=0;
				else if (x>ORDER-1) x=ORDER-1;
				else if (y<0) y=0;
				else if (y>ORDER-1) y=ORDER-1;
				pos_cursor(x,y);
			}
		}
	}
	  while(board[y][x]!=NULL);

	char mark=(player==1)?'X':'O';
	board[y][x]=mark;

}

int chkboard(void)
{
	int player2_position=0;
	int player1,player2;

	//rows and cols check
	for (int k=0;k<2;k++)
		for (int i=0;i<ORDER;i++)
		{
			player1=player2=0;

			for (int j=0;j<ORDER;j++)
			{
				if (k==0)		//then check rows
				{
					if (board[i][j]=='X')
						player1++;
					else if (board[i][j]=='O')
						player2++;
				}
				else		// else check cols
				{
					if (board[j][i]=='X')
						player1++;
					else if (board[j][i]=='O')
						player2++;
				}
			}		//end loop j
			if (player1==0)
				player2_position+=player2;
			if (player2==0)
				player2_position-=player1;

			if (player1==ORDER)
			{
				pos=-ORDER*ORDER;
				return 1;
			}
			else if (player2==ORDER)
			{
				pos=ORDER*ORDER;
				return 2;
			}


		}	//end loop i

	//diagonal check
	for (k=0;k<2;k++)
	{
		player1=player2=0;
		for (i=0;i<ORDER;i++)
		{
			if (k==0)		//then check left diagonal
			{
					if (board[i][i]=='X')
						player1++;
					else if (board[i][i]=='O')
						player2++;
			}
			else            //else check right diagonal
			{
					if (board[i][ORDER-1-i]=='X')
						player1++;
					else if (board[i][ORDER-1-i]=='O')
						player2++;
			}
		}		// end loop i
		if (player1==0)
				player2_position+=player2;
		if (player2==0)
				player2_position-=player1;
		pos=player2_position;

		if (player1==ORDER)
		{
			pos=-ORDER*ORDER;
			return 1;
		}
		else if (player2==ORDER)
		{
			pos=ORDER*ORDER;
			return 2;
		}

	}
//	printf("\nPlayer 2 Postion %d", player2_position);
	::pos=player2_position;
	return 0;
}


void best_move(int player)
{
	int temp_pos=0, tot_pos;

	tot_pos=(player==1)?3276:-3276;

	int best_i,best_j, best_pos;
	int tmp_i[level],tmp_j[level];
	char mark[3]={0,'X','O'};
	int peak=ORDER*ORDER;
	peak=(player==1)?peak:-peak;
	int next_player=(player==1)?2:1;

	for (int i=0;i<ORDER;i++)
		for (int j=0;j<ORDER;j++)
			if ( board[i][j]==NULL )
			{
				board[i][j]=mark[player];	//puts X/O at 0,0 if 0,0 is null???
				temp_pos=0;
				chkboard();
				temp_pos+=pos;
				next_player=player;
				int cnt=0;

				do
				{
					next_player=(next_player==1)?2:1;
					counter_move(next_player, &tmp_i[cnt], &tmp_j[cnt], &best_pos);
					temp_pos+=best_pos;
					if (tmp_i[cnt]!=-1 && (best_pos)!=peak )
						board[ tmp_i[cnt] ] [ tmp_j[cnt] ] = mark[next_player];
					cnt++;

				}
					  while (tmp_i[cnt-1]!=-1 && best_pos!=peak && cnt<level);

				if (cnt==level || tmp_i[cnt-1]==-1 || best_pos==peak)
					cnt--;
				if (tmp_i[cnt]==-1)
					cnt--;

				while(cnt>=0 && tmp_i[cnt]!=-1)
				{
					board[tmp_i[cnt]][tmp_j[cnt]]=NULL;
					cnt--;
				}

				if (player==2)
				{
					if ( tot_pos<temp_pos )
					{
						best_i=i;
						best_j=j;
						tot_pos=temp_pos;
					}
				}
				else
					if ( tot_pos>temp_pos )
					{
						best_i=i;
						best_j=j;
						tot_pos=temp_pos;
					}

				board[i][j]=NULL;
			}  	// end if (board==NULL)

	board[best_i][best_j]=mark[player];
//	printf("i=%d,j=%d,pos=%d", best_i,best_j,best_pos);

}


void counter_move(int player, int *best_i, int *best_j, int *best_pos)
{
	*best_i=*best_j=-1;
	char mark=(player==1)?'X':'O';
	*best_pos=(player==1)?3276:-3276;

	for (int i=0;i<ORDER;i++)
		for (int j=0;j<ORDER;j++)
			if ( board[i][j]==NULL )
			{
				board[i][j]=mark;
				chkboard();
				if (player==2)
				{
					if ( *best_pos<pos )
					{
						*best_i=i;
						*best_j=j;
						*best_pos=pos;
					}
				}
				else
					if ( *best_pos>pos )
					{
						*best_i=i;
						*best_j=j;
						*best_pos=pos;
					}

				board[i][j]=NULL;
			}  	// end if (board==NULL)
	if (*best_i==-1)
		*best_pos=0;//(player==2)?3276:-3276;

	return;
}