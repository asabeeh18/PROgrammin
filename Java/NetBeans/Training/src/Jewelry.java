/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class Jewelry {

//int v[10],x[10],sumreq,n;
int sum(int[] x, int k)
{
    int s=0,i;
    for(i=0;i<k;i++)
		s+=x[i];
	return s;
}	
boolean proper(int[] x, int[] v, int k, int i, int sumreq)
{
	for(int j=0;j<=k-1;j++)
		if(x[j]==v[i])
			return false;
	if(sum(null, k-1)+v[i]>sumreq)
		return false;
	return true;
}
void sumset(int[] x, int[] v, int k, int sumreq)
{
    int i,j,s;
	for(i=k;i<v.length;i++)
	{
		if(proper(x,v,k,i,sumreq))
		{
			x[k]=v[i];
			s=sum(null, k);
			if(s==sumreq)
			{
                return;
			}
			sumset(x,v,k+1,sumreq);
		}
	}
}	
}
