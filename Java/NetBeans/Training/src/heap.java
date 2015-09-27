// heap.java
// demonstrates heaps
// to run this program: C>java HeapApp
import java.io.*;
////////////////////////////////////////////////////////////////

// -------------------------------------------------------------
 
////////////////////////////////////////////////////////////////
class Heap
   {
   private int[] heapArray;
   private int maxSize;           // size of array
   private int currentSize;       // number of nodes in array
// -------------------------------------------------------------
   public Heap(int mx)            // constructor
      {
      maxSize = mx;
      currentSize = 0;
      heapArray = new int[maxSize];  // create array
      }
// -------------------------------------------------------------
   public boolean isEmpty()
      { return currentSize==0; }
// -------------------------------------------------------------
   public boolean insert(int key)
      {
      if(currentSize==maxSize)
         return false;
      //Node newNode = new Node(key);
      heapArray[currentSize] = key;
      trickleUp(currentSize++);
      return true;
      }  // end insert()
// -------------------------------------------------------------
   public void trickleUp(int index)
      {
      int parent = (index-1) / 2;
      int bottom = heapArray[index];

      while( index > 0 &&
             heapArray[parent]< bottom )
         {
         heapArray[index] = heapArray[parent];  // move it down
         index = parent;
         parent = (parent-1) / 2;
         }  // end while
      heapArray[index] = bottom;
      }  // end trickleUp()
// -------------------------------------------------------------
   public int remove()           // delete item with max key
      {                           // (assumes non-empty list)
      int root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
      }  // end remove()
// -------------------------------------------------------------
   public void trickleDown(int index)
      {
      int largerChild;
      int top = heapArray[index];       // save root
      while(index < currentSize/2)       // while node has at
         {                               //    least one child,
         int leftChild = 2*index+1;
         int rightChild = leftChild+1;
                                         // find larger child
         if(rightChild < currentSize &&  // (rightChild exists?)
                             heapArray[leftChild] <
                             heapArray[rightChild])
            largerChild = rightChild;
         else
            largerChild = leftChild;
                                         // top >= largerChild?
         if( top >= heapArray[largerChild])
            break;
                                         // shift child up
         heapArray[index] = heapArray[largerChild];
         index = largerChild;            // go down
         }  // end while
      heapArray[index] = top;            // root to index
      }  // end trickleDown()
// -------------------------------------------------------------
   public boolean change(int index, int newValue)
      {
      if(index<0 || index>=currentSize)
         return false;
      int oldValue = heapArray[index]; // remember old
      heapArray[index]=newValue;  // change to new

      if(oldValue < newValue)             // if raised,
         trickleUp(index);                // trickle it up
      else                                // if lowered,
         trickleDown(index);              // trickle it down
      return true;
      }  // end change()
// -------------------------------------------------------------
   
// -------------------------------------------------------------
   }  // end class Heap
////////////////////////////////////////////////////////////////
class HeapApp
   {
   public static void main(String[] args) throws IOException
      {
      int value, value2;
      Heap theHeap = new Heap(31);  // make a Heap; max size 31
      boolean success;

      theHeap.insert(70);           // insert 10 items
      theHeap.insert(40);
      theHeap.insert(50);
      theHeap.insert(20);
      theHeap.insert(60);
      theHeap.insert(100);
      theHeap.insert(80);
      theHeap.insert(30);
      theHeap.insert(10);
      theHeap.insert(90);

      while(true)                   // until [Ctrl]-[C]
         {
         System.out.print("Enter first letter of ");
         System.out.print("show, insert, remove, change: ");
         int choice = getChar();
         switch(choice)
            {
           
            case 'i':                        // insert
               System.out.print("Enter value to insert: ");
               value = getInt();
               success = theHeap.insert(value);
               if( !success )
                  System.out.println("Can't insert; heap full");
               break;
            case 'r':                        // remove
               if( !theHeap.isEmpty() )
                  theHeap.remove();
               else
                  System.out.println("Can't remove; heap empty");
               break;
            case 'c':                        // change
               System.out.print("Enter current index of item: ");
               value = getInt();
               System.out.print("Enter new key: ");
               value2 = getInt();
               success = theHeap.change(value, value2);
               if( !success )
                  System.out.println("Invalid index");
               break;
            default:
               System.out.println("Invalid entry\n");
            }  // end switch
         }  // end while
      }  // end main()
//-------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
//-------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }
//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
//-------------------------------------------------------------
  }  // end class HeapApp
////////////////////////////////////////////////////////////////