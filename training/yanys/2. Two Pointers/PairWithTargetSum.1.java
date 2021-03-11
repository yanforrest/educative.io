class PairWithTargetSum {

   public static int[] search(int[] arr, int targetSum) {
      // TODO: Write your code here
      int start = 0;
      int end = arr.length-1;
      int sum = arr[start] + arr[end];

      while (sum != targetSum){

         if(sum > targetSum) end--;

         if(sum < targetSum) start++;

         if(start >=0 && start < arr.length && end >=0 && end < arr.length ) {
            sum = arr[start] + arr[end];
         } else {
            break;
         }
      }

      return sum == targetSum ? new int[] {start, end} : new int[] { -1, -1 };

   }

   public static void main(String[] args) {
      int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
      result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
   }
}