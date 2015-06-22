import java.io.*; 
class bit_shift
{
    
    public void main() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a no.");
        int n=Integer.parseInt(br.readLine());
        
        int g=n>>>2;
        
        System.out.println(g);
        
        String j=Integer.toBinaryString(g);
        System.out.println(j);
    }
}