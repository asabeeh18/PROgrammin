//i dont think this is my code :/
import java.util.Arrays;
class StripePainter
{
	int stroke=0;
	public int minStrokes(String paint)
	{
		painter(paint.toCharArray(),'-');
		return stroke;
	}
	public void painter(char[] paint,char col)
	{
		if(paint.length==0) return;
		if(paint.length==1)
		{
			if(paint[0]==col) return;
			else
			{
				stroke++;
				return;
			}
		}
		for(int i=0;i<paint.length/2;i++)
		{
			for(int j=paint.length-1;j>paint.length/2-i && j>=i;j--)
			{
				if(paint[i]==paint[j] && paint[i]!=col)
				{
					painter(Arrays.copyOfRange(paint,0,i),col);
					painter(Arrays.copyOfRange(paint,i+1,j),paint[i]);
					stroke++;
					System.out.println(i+","+j+","+col+","+(new String(paint)));
					painter(Arrays.copyOfRange(paint,j+1,paint.length),col);
					return;
				}
				else if(paint[i]==paint[j])
				{
					painter(Arrays.copyOfRange(paint,0,i),col);
					painter(Arrays.copyOfRange(paint,i+1,j),paint[i]);
					//stroke++;
					System.out.println(":"+i+","+j+","+col+","+(new String(paint)));
					painter(Arrays.copyOfRange(paint,j+1,paint.length),col);
					return;
				}
			}
		}
	}
	public static void main(String a[])
	{
		System.out.println((new StripePainter()).minStrokes("ABACADA"));
	}
}