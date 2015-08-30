import java.util.*;
class JewelEasy
{
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int t=r.nextInt();
		r.nextLine();
		//char color[]=new char[26];
		while(t-->0)
		{
			int color[][]=new int[26][2];
			char[] jewel=(r.nextLine()).toCharArray();
			for(int i=0;i<jewel.length;i++)
			{
				if(jewel[i]>='a')
				{
					color[jewel[i]-'a'][0]++;
				}
				else
				{
					color[jewel[i]-'A'][1]++;
				}
			}
		//	System.out.println(color['s'-'a'][0]+": "+Math.ceil(color['s'-'a'][0]/2.0));
			int cost=0;
			for(int i=0;i<26;i++)
			{
				cost+=Math.ceil(color[i][0]/2.0);
				cost+=Math.ceil(color[i][1]/2.0);
			}
			System.out.println(cost);
		}
	}
}