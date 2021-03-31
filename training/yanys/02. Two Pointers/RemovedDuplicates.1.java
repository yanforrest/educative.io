class RemoveDuplicates {

   public static int remove(int[] arr) {
      // TODO: Write your code here
      int left=0, right=0;
      int lastValue;

      lastValue= arr[0];
      left = 1;

      for (right =0; right < arr.length; right ++){
         if(lastValue != arr[right]) {
            lastValue = arr[right];
            arr[left++] = lastValue;
         }
      }
      return left;
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
      System.out.println(RemoveDuplicates.remove(arr));

      arr = new int[] { 2, 2, 2, 11 };
      System.out.println(RemoveDuplicates.remove(arr));
   }
}