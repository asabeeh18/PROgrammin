
import java.util.*;

public class MorganString {

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r = new Scanner(System.in);

        int t = r.nextInt();
        r.nextLine();
        while (t-- > 0)
        {
            StringBuilder ss = new StringBuilder();
            String a = r.nextLine();
            String b = r.nextLine();
            boolean cSmall=false;
            int iSmall=-1;
            //int len=a.length()<b.length()?a.length():b.length();
            int i, j;
            for (i = 0, j = 0; i < a.length() && j < b.length();)
            {
                if (a.charAt(i) < b.charAt(j))
                {
                    ss.append(a.charAt(i));
                    i++;
                } else if (a.charAt(i) > b.charAt(j))
                {
                    ss.append(b.charAt(j));
                    j++;
                } else
                {
                    int ii=i+1,jj=j+1;
                    while(true)
                    {
                        if(ii>=a.length())
                        {
                            
                            ss.append(b.substring(j,jj));
                            
                            //ss.append(b.charAt(j));
                            j=jj+1;
                            break;
                        }
                        if(jj>=b.length())
                        {
                            ss.append(a.substring(i,ii));
                            //ss.append(a.charAt(i));
                            i=ii+1;
                            break;
                        }
                        if(a.charAt(ii)<b.charAt(jj))
                        {
                            ss.append(a.substring(i,ii+1));
                            //ss.append(a.charAt(i));
                            i=ii+1;
                            break;
                        }
                        else if(a.charAt(ii)>b.charAt(jj))
                        {
                            ss.append(b.substring(j,jj+1));
                            //ss.append(b.charAt(j));
                            j=jj+1;
                            break;
                        }
                        else
                        {
                            ii++;
                            jj++;
                        }
                    }
                }
            }
            while (i < a.length())
            {
                ss.append(a.charAt(i));
                i++;
            }
            while (j < b.length())
            {
                ss.append(b.charAt(j));
                j++;
            }
            System.out.println(ss.toString());
        }

    }
}