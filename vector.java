import java.util.Scanner;
import java.util.Vector;
/**
 * @author Saurabh
 *
 */
class vector {

	public static void main(String[] args) {
		Vector student = new Vector();
		Scanner src = new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			student.add(new String(src.nextLine()));
		}
		for(int i=0;i<5-1;i++)
			for(int j=0;j<5-1;j++)
		{
			if(((String)student.elementAt(j)).compareTo((String)student.elementAt(j+1))>0)
			{
				Object t = student.elementAt(j);
				student.removeElementAt(j);
				student.add(j+1,t);
			}
		}
	System.out.println(student);
	
	}

}
