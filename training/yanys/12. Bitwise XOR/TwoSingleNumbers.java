
class TwoSingleNumbers {

   public static int[] findSingleNumbers(int[] nums) {
      // TODO: Write your code here
      int value = 0, i=0;
      for (i =0; i < nums.length; i++){
         value = value ^ nums[i];
      }
      int mask = 1;
      while((value & mask )== 0){
         mask <<= 1;
      }
      int v1=0, v2=0;
      for(i=0; i< nums.length; i++){
         if((nums[i] & mask) ==0){
            v1 ^= nums[i];
         }else{
            v2 ^= nums[i];
         }
      }

      return new int[] { v1, v2 };

   }

   public static void main(String[] args) {
      int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
      int[] result = TwoSingleNumbers.findSingleNumbers(arr);
      System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

      arr = new int[] { 2, 1, 3, 2 };
      result = TwoSingleNumbers.findSingleNumbers(arr);
      System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
   }
}
