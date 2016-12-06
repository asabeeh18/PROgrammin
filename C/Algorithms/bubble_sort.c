void sort(int [] ser)
{
    int n=sizeof(ser)/sizeof(ser[0]);
    int i;
	int j;
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
}
