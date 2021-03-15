class CircularArrayLoop {

   public static boolean loopExists(int[] arr) {
      // TODO: Write your code here
      int slow=0, fast=0;
      int pos=0, neg=0;

      while(slow != fast){
         fast = (fast + arr[fast]) % arr.length;
         fast = (fast + arr[fast]) % arr.length;
         slow = (slow + arr[slow]) % arr.length;

      }

      fast = (fast + arr[fast]) % arr.length;
      fast = (fast + arr[fast]) % arr.length;
      slow = (slow + arr[slow]) % arr.length;
      while(slow != fast){
         if( arr[fast] > 0) pos = 1;
         else if ( arr[fast] < 0) neg = 1;
         fast = (fast + arr[fast]) % arr.length;

         if( arr[fast] > 0) pos = 1;
         else if ( arr[fast] < 0) neg = 1;
         fast = (fast + arr[fast]) % arr.length;

         slow = (slow + arr[slow]) % arr.length;

      }

      if ( pos == 1 && neg ==0 )
         return true;
      else
         return false;
   }

   public static void main(String[] args) {
      System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
      System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
      System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
   }
}