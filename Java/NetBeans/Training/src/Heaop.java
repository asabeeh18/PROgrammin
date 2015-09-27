class Heaop
   {
   private static int[] heapArray;
   private static int maxSize;           // size of array
   private static int currentSize;       // number of nodes in array
// -------------------------------------------------------------
   
// -------------------------------------------------------------
   public static boolean isEmpty()
      { return currentSize==0; }
// -------------------------------------------------------------
   public static boolean insert(int key)
      {
      if(currentSize==maxSize)
         return false;
      //Node newNode = new Node(key);
      heapArray[currentSize] = key;
      trickleUp(currentSize++);
      return true;
      }  // end insert()
// -------------------------------------------------------------
   public static void trickleUp(int index)
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
   public static int remove()           // delete item with max key
      {                           // (assumes non-empty list)
      int root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
      }  // end remove()
// -------------------------------------------------------------
   public static void trickleDown(int index)
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
   public static boolean change(int index, int newValue)
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
   public static void main(String as[])
   {
      maxSize=20;
      heapArray = new int[maxSize];
      insert(70);           // insert 10 items
      insert(40);
      insert(50);
      insert(20);
      insert(60);
      insert(100);
      insert(80);
      insert(30);
      insert(10);
      insert(90);
      int x=remove();
      x=remove();
      x=remove();
      x=remove();
      x=remove();
      x=remove();
      x=remove();
      x=remove();
      x=remove();
      x=remove();
     
      insert(100);
      insert(80);
      insert(30);
      insert(10);
      insert(90);
      
      x=remove();
      x=remove();
      x=remove();
// -------------------------------------------------------------
   } 
}