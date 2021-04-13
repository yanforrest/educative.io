class PairWithTargetSum {

   public static int[] search(int[] arr, int targetSum) {
      // TODO: Write your code here
      int left = 0;
      int right = arr.length-1;
      int sum = arr[left] + arr[right];

      while (left < right){

         sum = arr[left] + arr[right];

         if(sum == targetSum){
            return  new int[] {left, right};
         }

         if(sum > targetSum) right --;
         else left ++;

      }

      return new int[] { -1, -1 };

   }

   public static void main(String[] args) {
      int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
      result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
      System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
   }
}