/*An arithmetic series consists of a sequence of terms such that each term minus its immediate predecessor gives the same result.
 * For example, the sequence 3,7,11,15 is the terms of the arithmetic series 3+7+11+15; each term minus its predecessor equals 4. 
 * (Of course there is no requirement on the first term since it has no predecessor.)
Given a collection of integers, we want to find the longest arithmetic series that can be formed by choosing a sub-collection 
* (possibly the entire collection). Create a class ASeries that contains a method longest that is given a values and returns 
* the length of the longest arithmetic series that can be formed from values.

Examples
0)
{3,8,4,5,6,2,2}
Returns: 5
No arithmetic series using these values is longer than 2,3,4,5,6.
1)
{-1,-5,1,3}
Returns: 3
-1, 1, 3 is an arithmetic series (so is 3,-1,-5).
2)
{-10,-20,-10,-10}
Returns: 3
-10,-10,-10 is an arithmetic series.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of 
* this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc.
* All rights reserved.
*/

/**
 *
 * @author Aditya C Awalkar
 */
import java.util.*;

class Sequence {

    private static void findSequence(int a[],int b[][],int n)
    {
        int count=2,c;
        //for(int i=3;i<n;i++)
            for(int j=0,u=j+1 ; j<n-1 && u<n ; j++,u++)
                for(int k=j+1,v=k+1 ;k<n-1 && v<n ;  k++,v++)
                    if(b[j][k]==b[u][v])           //checks for match in matrix
                    {    
                        c=b[j][k];
                        count++;
                        int h=3;                //ek match ho gaya so aageka match check karneka logic
                        while(h<n){             //n 4 ke liye hi banaya hai ab tak.. so h=3to4 ka ek check hoga es loop mein
                            if(c==b[j++][k++])
                                count++;
                            h++;
                        }
                    }
        if(count==2)
            System.out.println(0);
        else    System.out.println(count);
    }
    
    public static void main(String args[])
    {
        Scanner src=new Scanner(System.in);
        int n=src.nextInt();
        int a[]=new int[n];
        int b[][]=new int[n][n];
        for(int i:a)
            a[i]=src.nextInt();
        for(int i:a)
            for(int j=0;j<n;j++)
                b[i][j]=a[i]-a[j];
        findSequence(a,b,n);
    }
}