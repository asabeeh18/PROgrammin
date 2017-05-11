public class LongLongTripDiv2
{
	public String isAble(long D, int T, int B)
	{
		if((D-T)/(double)(B-1)==(D-T)/(B-1) && (D-T)/(double)(B-1)>=0 && (T-(D-T)/(double)(B-1))>=0)
			return "Possible";
		else
			return "Impossible";
	}
}