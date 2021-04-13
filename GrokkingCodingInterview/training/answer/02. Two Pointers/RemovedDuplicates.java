class RemoveDuplicates {

   public static int remove(int[] arr) {
      // TODO: Write your code here
      int left, right;

      left = 1;

      for (right =1; right < arr.length; right ++){
         if(arr[left-1] != arr[right])
            arr[left++] = arr[right];
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