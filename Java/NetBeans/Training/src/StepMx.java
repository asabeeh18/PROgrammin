class StepMx
{
    public static void main(String ar[]) throws java.io.IOException
    {
        java.util.Scanner r=new java.util.Scanner(System.in);
        int t=r.nextInt();
        while(t-->0)
        {
            int n=r.nextInt();
            int poz[]=new int[n*n+1];
            for (int i=0;i<n;i++)
            {
                //String[] line=r.readLine().split(" ");
                for(int j=0;j<n;j++)
                {
                    int num=r.nextInt();
                    poz[num]=n*i+j;
                }
                
            }
            int cost=0;
            int ci=poz[1]/n,cj=poz[1]%n;
            int i,j;
            for(int m=2;m<=n*n;m++)
            {
                i=poz[m]/n;
                j=poz[m]%n;
                cost+=Math.abs(i-ci)+Math.abs(j-cj);
                ci=i;
                cj=j;
            }
            System.out.println(cost);
        }
    }
}