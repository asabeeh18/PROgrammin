import java.io.*;
class Chess
{
        static int capture=0;
        static int calls=0;
	public static void main(String args[]) throws Exception
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String s=r.readLine();
                String ss[][]=new String[2][];
		ss[0]=s.split("/");
		s=r.readLine();
		while(!s.equals("-1"))
		{
	
			ss[1]=s.split("/");
			compare(ss);
			System.arraycopy(ss[1],0,ss[0],0,ss[1].length);
			s=r.readLine();
		}
                System.out.println();
                System.out.println("Number of Captures : "+capture);
	}
	public static void compare(String[][] ss)
        {
                boolean captureSet=false,moveSet=false;
                char alpha=0,alphaC=0,piece=0;
                int pos=0,boxb=0,boxa=0;
                for(int i=0;i<8;i++)
                {
                    if(!ss[0][i].equals(ss[1][i]))
                    {
                        //int min=ss[0][i].length()<ss[1][i].lengh()?ss[0][i].length():ss[1][i].length();
                        char a[]=ss[0][i].toCharArray(),b[]=ss[1][i].toCharArray();
                        int min=a.length<b.length?a.length:b.length;
                        int j;
                        for(j=0;j<min;j++)
                        {
                            if(a[j]!=b[j])
                            {
                                if((a[j]>='0' && a[j]<='9') &&(b[j]>='0' && b[j]<='9'))
                                {
                                    boxb=b[j]-'0';
                                    boxa=a[j]-'0';
                                    continue;
                                } //false alarm
                                if((a[j]>='0' && a[j]<='9'))
                                {
                                    boxa+=a[j]-'0';
                                    //boxa=a[j]-'0';
                                    //continue;
                                }
                                else boxa++;
                                if((b[j]>='0' && b[j]<='9'))
                                {
                                    boxb+=b[j]-'0';
                                    continue;
                                }
                                else boxb++;
                                if(Character.isLetter(a[j]) && Character.isLetter(b[j]) && boxa==boxb)
                                {
                                    capture++;
                                    captureSet=true;
                                    if(b[j]=='P' || b[j]=='p')
                                    {
                                        alpha=findAlphaPoz(ss[1][i],j);
                                        if(b[j]=='p')
                                            alphaC=findAlphaPPoz(ss[0][i-1],alpha);
                                        else
                                            alphaC=findAlphaPPoz(ss[0][i+1],alpha);
                                        
                                    }
                                    else
                                    {
                                        alpha=findAlphaPoz(ss[1][i],j);
                                        alphaC=b[j];
                                    }
                                    pos=8-i;
                                    moveSet=true;
                                    if(b[j]!='p' && b[j]!='P')
                                        piece=b[j];
                                }
                                else if(Character.isLetter(b[j]) && boxa>=boxb)
                                {
                                    //if(ss[1][i].length==ss[0][i].length)
                                    alpha=findAlphaPoz(ss[1][i],j);
                                    moveSet=true;
                                    pos=8-i;
                                    if(b[j]!='p' && b[j]!='P')
                                        piece=b[j];
                                }
                                
                            }
                            else 
                            {
                                
                                boxa++;
                                boxb++;
                            }
                            if(moveSet)
                                break;
                        } 
                        
                        if(j==min && count(ss[1][i])>count(ss[0][i]) && min<8)
                        {
                            alpha=findAlphaPoz(ss[1][i],j);
                                    moveSet=true;
                                    pos=8-i;
                                     if(b[j]!='p' && b[j]!='P')
                                        piece=b[j];
                                   
                        }
                     }
                    if(moveSet)
                                break;
                    
                }
                String print="";
                if(moveSet && !captureSet)
                {
                    print=piece+""+alpha+""+pos;
                }
                else if(moveSet && captureSet)
                {
                    print=alpha+""+pos;
                }
                if(captureSet)
                {
                    print=alphaC+"x"+print;
                }
                if(calls%2==0)
                    print=(calls/2+1)+") "+print+" ";
                else
                    print=print+"\n";
                System.out.print(print);
                
                calls++;
        }
        static int count(String s)
        {
            int pos=0;
            for(int i=0;i<s.length();i++)
            {
                if(Character.isLetter(s.charAt(i)))
                {
                    pos++;
                }
              //  else
                   // pos+=s.charAt(i)-'0';
                
                            
            }
            return pos;
        }
        static char findAlphaPoz(String s,int i)
        {
            int pos=0;
            while(i>=0)
            {
                if(Character.isLetter(s.charAt(i)))
                {
                    pos++;
                }
                else
                    pos+=s.charAt(i)-'0';
                i--;
                            
            }
            return (char)(pos-1+'a');
        }
        static char findAlphaPPoz(String s,char pos1)
        {
            int poz=pos1-(int)'a'+1;
            int pos=0;
            for(int i=0;i<s.length();i++)
            {
                if(Character.isLetter(s.charAt(i)))
                {
                    pos++;
                }
                else
                    pos+=s.charAt(i)-'0';
                if((s.charAt(i+1)=='p' || s.charAt(i+1)=='P') && pos+2==poz)
                {
                    return (char)(pos+'a');
                }
            }
            pos=0;
            for(int i=s.length()-1;i>=0;i--)
            {
                if(Character.isLetter(s.charAt(i)))
                {
                    pos++;
                }
                else
                    pos+=s.charAt(i)-'0';
                if(pos==8-poz)
                {
                    return findAlphaPoz(s,8-pos+1);
                }
            }
            return '\0';
        }
        
}