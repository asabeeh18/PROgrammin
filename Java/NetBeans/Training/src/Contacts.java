
/**
 *
 * @author Ahmed
 *
 * https://www.hackerrank.com/challenges/ctci-contacts?h_r=next-challenge&h_v=zen
 * Tries: Contacts Part of Cracking the coding interview
 */
import java.util.*;

public class Contacts {

    static Node root=new Node();
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final String add = "add";
        
        for (int a0 = 0; a0 < n; a0++)
        {
            String op = in.next();
            String contact = in.next();
            // max names 10^5
            if (op.equals(add))
            {
                root.add(contact);
            } else
            {
                int d = root.find(contact);
                System.out.println(d);
            }
        }

    }

    static class Node {

        HashMap<Character, Node> table;
        String name;
        boolean end;
        Node()
        {
            table = new HashMap<>();
        }
/**
        private void add(String contact)
        {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (contact == null || contact.length() < 1)
            {
                return;
            }
            Node n = table.get(contact.charAt(0));
            if (n == null)
            {
                n = new Node();
                n.end = true;
                n.name = contact.substring(1);
                table.put(contact.charAt(0), n);

            } else
            {
                if (n.end)
                {
                    Node n2 = new Node();
                    if (n.name != null && n.name.length() > 0)
                    {
                        n.add(n.name);
                        n.add(contact.substring(1));
                        name = null;
                        n.end = false;
                    } else
                    {
                        n.table.put(contact.charAt(0), n2);
                        n2.add(contact.substring(1));
                    }
                }
                //n.add(contact.substring(1));
            }
        }
**/
        
        private void add(String contact)
        {
            Node current=root;
            Node n=new Node();
            for(int i=0;i<contact.length();i++)
            {
                if(current.table.containsKey(contact.charAt(i)))
                {
                    n=current.table.get(contact.charAt(i));
                }
                else
                {
                    n=new Node();
                    n.end=false;
                    current.table.put(contact.charAt(i), n);
                }
                current=n;
            }
            n.end=true;
        }
        private int find(String contact)
        {
            Node current=root;
            for(int i=0;i<contact.length() && current!=null;i++)
            {
                if(current.table.containsKey(contact.charAt(i)))
                {
                    current=current.table.get(contact.charAt(i));
                }
                else
                    return 0;
            }
            return fullCount(current);
        }
        
        int fullCount(Node cur)
        {
            int count=0;
            if(cur.end)
            {
                count++;
            }
            for (Map.Entry<Character, Node> entry : cur.table.entrySet())
            {
                Node node = entry.getValue();
                count += fullCount(node);
            }
            return count;
        }
/**    
        private int find(String contact)
        {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (contact.length() == 0)
            {
                int count = 0;
                if (end)
                {
                    count = 1;
                }
                for (Map.Entry<Character, Node> entry : table.entrySet())
                {
                    Node node = entry.getValue();
                    count += node.find(contact);
                }
                return count;
            }
            if (end)
            {
                Node node = table.get(contact.charAt(0));
                if (node != null)
                {
                    return 1 + node.find(contact.substring(1));
                }
                return 1;
            } else if (contact != null)
            {
                Node node = table.get(contact.charAt(0));
                if (node != null)
                {
                    return node.find(contact.substring(1));
                }
                return 0;
            } else
            {
                return 0;
            }
        }
**/
    }
}
