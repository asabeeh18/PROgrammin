public class Jrand {

 public static void main (String[] args) {

    long startTime = System.currentTimeMillis();
    int i; 
    for (i = 0; i < 2000000000; i++) {
        // Do nothing!
    }
    long endTime = System.currentTimeMillis();
    float totalTime = (endTime - startTime);

    System.out.println("time: " + totalTime/1000);
 }

}