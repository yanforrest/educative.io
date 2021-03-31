class CircularArrayLoop {

   public static boolean loopExists(int[] arr) {
      // TODO: Write your code here
      int slow=0, fast=0;
      int pos=0, neg=0;

      for ( int i =0; i < arr.length; i++) {
         // because the number of the digital set is finite, then from every start point
         // the traveler will be ended within a loop when slow = fast.
         slow = i; fast = i;  pos=0; neg=0;

         // because the number of the digital set is finite, then from every start point
         // the traveler will be ended within a loop when slow = fast.
         do {
            fast = (fast + arr[fast]) % arr.length;
            fast = (fast + arr[fast]) % arr.length;
            slow = (slow + arr[slow]) % arr.length;
         } while (slow != fast);

         // travel in the loop, check if there is a negative direction.
        do{
            if (arr[fast] > 0) pos = 1;
            else if (arr[fast] < 0) neg = 1;
            fast = (fast + arr[fast]) % arr.length;
         } while (slow != fast);
         // if all the direction within the loop is positive, pos will be 1, neg will be zero.
         if (pos == 1 && neg == 0)
            break;
      }

      if (pos == 1 && neg == 0)
          return true;

      return false;

   }

   public static void main(String[] args) {
      System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
      System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
      System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
      System.out.println(CircularArrayLoop.loopExists(new int[] { 4, 1, -1, -2 }));
   }
}