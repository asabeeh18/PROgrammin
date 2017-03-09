class Permatchd2
{
    int a[],max[],n[];
    public int fix(String[] g)
    {
        a=new int[g.length];
        max=new int[g.length];
        n=new int[g.length];
        int count=0,oddC=0;
        for(int i=0;i<a.length;i++)
        {
            a[i]=i;
            max[i]=0;
            n[i]=1;
        }
        for(int i=0;i<g.length;i++)
        {
            for(int j=i+1;j<g[i].length();j++)
            {
                if(g[i].charAt(j)=='Y')
                    merge(i,j);
            }
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==i)
            {
                if(max[i]%2==0)
                    continue;
                else
                {
                    if(max[i]>=(n[i]*(n[i]-1))/2)
                    {
                        oddC++;
                    }
                    else
                        count++;
                }
            }
        }
        if(oddC>0 && oddC%2==0)
            return oddC/2;
        else if(oddC>0)
            return -1;
        return count;
    }
    public int find(int x)
    {
        if (a[x] != x)
        {
            a[x] = find(a[x]);
        }
        return a[x];
    }

    public void merge(int x, int y)
    {
        int xx = find(x), yy = find(y);

        //System.out.println(yy+":"+xx);
        if (xx > yy)
        {
            a[xx] = yy;
            max[yy]+=max[xx]+1;
            n[yy]+=n[xx];
        } 
        else
        {
            a[yy] = xx;
            max[xx]+=max[yy]+1;
            n[xx]+=n[yy];
        }
     
    }
    public static void main(String[] args) {
        String s[]={"NYN", "YNN", "NNN"};
        System.out.println(new Permatchd2().fix(s));
}
}
    