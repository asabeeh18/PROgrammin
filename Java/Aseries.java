//https://arena.topcoder.com/#/u/practiceCode/1345/1640/1758/1/1345
class Aseries
{
	int[] sort(int ser[])
	{
		int n=sizeof(ser)/sizeof(ser[0]);
		int i;
		int j,t;
		for(i=0;i<n;i++)
		{
			for(j=0;j<n-i-1;j++)
			{
				if(ser[j]>ser[j+1])
				{
					t=ser[j];
					ser[j]=ser[j+1];
					ser[j+1]=t;
				}
			}
		}  
		return ser;
	}
	
	int longest(int ser[])
	{
		ser=sort(ser);
		int n=ser.length;
		
		for(int i=0;i<n;i++)
		{
			
		}
		/*
			make a lower triangular Mx  size x size
			put array elemnts at row and cols
			fill in d values in by subtracting row-col
			counter = 0
			begin:
			i=1
			pick a number from col i
			pick same nmbr(if exists) from col i+1 but from the nxt row of prev SELECTED row
			if not exists ignore and move on
			save the new_counter
			if(new counter > counter)
			counter =new counter
			:end_repeat for all cols
		*/
		return 1;
	}
	}		