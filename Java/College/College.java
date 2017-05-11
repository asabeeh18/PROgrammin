import java.util.*;
import java.io.*;
class College
{
	private String name,brnch[];
	private int rate,brnchStud[],brnchNo;
	public College()throws IOException//Ad Max Salary ,palcmnt%,
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Name of College:");
		name=src.nextLine();
		System.out.println("No. of Branches:");
		brnchNo=src.nextInt();
		brnch=new String[brnchNo];
		brnchStud=new int[brnchNo];
		for(int i=0;i<brnchNo;i++)
		{
			src.nextLine();
			System.out.println("Branch Name:");
			brnch[i]=src.nextLine();
			System.out.println("Maximum Students in Branch:");
			brnchStud[i]=src.nextInt();
		}
		System.out.println("College Rating out of 5:");
		rate=src.nextInt();
		toFile(this,true);	//true to add to college collection File
	}
	public void toFile(College add,boolean n)throws IOException
	{
		String s;
		if(n)
			s=add.name+".txt";
		else
			s="College.txt";
		FileWriter fw = new FileWriter("CollegeList.txt");
		BufferedWriter bw = new BufferedWriter(fw);	
		bw.write("\nName:"+add.name+"\nRating"+add.rate+"\nNo. Of Branches:"+add.brnchNo);
		bw.newLine();
		for(int i=0;i<add.brnchNo;i++)
			bw.write("\n"+brnch[i]+":"+brnchStud[i]);
		bw.write("\n");
	
		//fw.close();
		bw.close();
	}	
}
class GO
{
	public static void main(String arg[])throws IOException
	{
		College c=new College();
	}
}	
/*WRITE TO FILE
String content = "This is the content to write into file";
 
			File file = new File("/users/mkyong/filename.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
*/
/*READ TO FILE			
String sCurrentLine;
 
			br = new BufferedReader(new FileReader("C:\\testing.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
*/	
			