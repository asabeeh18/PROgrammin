public class Robofactory
{
    public int reveal(int a[],String ans[])
    {
        String[] test={"Even","Odd"};
    	int eveC=0,eveI=-1;
        if(a[0]%2==0)
        {
            eveC++;
            eveI=0;
        }
        for(int i=1;i<a.length;i++)
        {
            if(test[a[i]%2]==ans[i])
                continue;
            else if(a[i-1]%2==1)
            {
                System.out.println(i+":");
                return i;
            }
            if(a[i]%2==0 && i<a.length-1)
            {
                eveI=i;
                eveC++;
            }
        }
        if(eveC>0 && eveI!=a.length-1)
            return -1;
        if(eveC==0)
        {
            System.out.println("MZ");
            return 0;
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        int a[]={1,3,5,10};
        String s[]={"Odd", "Odd", "Odd", "Even"};
        System.out.println(new Robofactory().reveal(a,s));
    }
}