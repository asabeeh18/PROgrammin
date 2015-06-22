//#include<stdio>
int main()
{
	int n,i,j,enem[200],a[200][200],m,e,ek,count=0;
	scanf("%d",&n);
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			scanf("%d",&a[i][j]);
	//start
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			enem[j]=-1;
		for(j=i;j<n;j++)
			if(a[i][j]==0)
				enem[e++]=j;
		for(m=0;m<e;m++)
		{
			ek=enem[m];
			for(j=0;j<n;j++)
				if(a[ek][j]==1 && a[i][j]==1)
					count++;
		}
	}
	return 0;
}
