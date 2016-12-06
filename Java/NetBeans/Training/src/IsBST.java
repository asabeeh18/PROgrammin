/**
 * 
 * @author Ahmed
 * 
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree?h_r=next-challenge&h_v=zen
 * Trees: Is This a Binary Search Tree?
 * Part of Cracking the coding interview
 */
class IsBST
{
    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    int a=-1,b=-1;
    boolean checkBST(Node root) {
       return inorder(root);
    }
    boolean inorder(Node node)
    {
        boolean status=true;
        
        if(node == null)
            return true;
        
        status=inorder(node.left)&status;
        b=node.data;
        //OK:b>a
        if(a>=b)
        {
              return false;    
        }
        a=b;
        status=inorder(node.right)&status;
        return status&true;
    }
    class Node {
        int data;
        Node left;
        Node right;
     }

}
