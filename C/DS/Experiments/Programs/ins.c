//INSERTION SORT

void insertSort()
{
	for(i=1;i<n;i++)
	{
		x=a[i];
		j=i;
		while(j>0 && a[j-1]>x)
		{
			a[j]=a[j-1];
			j--;
		}
		a[j]=x;
	}
}
void main()
{
	