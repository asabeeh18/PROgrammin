import java.util.*;

class Strings
{
     public static void main(String args[])
     {
          Scanner src = new Scanner(System.in);

          System.out.print("Enter a string: ");
          String str = src.nextLine();

          char arr[] = str.toCharArray();
          int i;

          for(i = 0; i < arr.length; i++)
          {
               if(i == 0 && arr[i] !=' ')
                {
					if((int)arr[i] >= 97 && (int)arr[i] <= 122)
                         arr[i] = (char)(arr[i] - 32);
               }
               else if(arr[i] ==' ')
               {
                    if((int)arr[i + 1] >= 97 && (int)arr[i + 1] <= 122)
                         arr[i + 1] = (char)(arr[i + 1] - 32);
               }
          }

          str = new String(arr);
          System.out.println("Output: " + str);
     }
}