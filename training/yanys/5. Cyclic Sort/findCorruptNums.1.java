import java.util.ArrayList;
import java.util.List;

class FindCorruptNums {

   public static int[] findNumbers(int[] nums) {
      List<Integer> duplicated = new ArrayList<>();
      List<Integer> missing = new ArrayList<>();

      // TODO: Write your code here
      int i =0, j=0;
      while( i < nums.length ){
         if(nums[i]!=nums[nums[i]-1])
            swap(nums, i, nums[i] - 1);
         else
            i++;
      }

      for(i=0; i< nums.length; i++){
         if(nums[i] != i+1) {
            missing.add(i + 1);
            if(!duplicated.contains(nums[i]))
               duplicated.add(nums[i]);
         }
      }

      int[] result= new int[missing.size()+duplicated.size()];

      for(i=0; i< duplicated.size(); i++)
         result[i]= duplicated.get(j);

      for(j=0; j< missing.size(); j++)
         result[i+j]= missing.get(j);

      return result;
   }
   public static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void main(String[] args) {
      int[] nums = FindCorruptNums.findNumbers(new int[]{3,1,2,5,2});
      System.out.println("Output: ");
      for(int i=0; i<nums.length;i++)
         System.out.println(nums[i]+" ");
      System.out.println("\n");

      nums = FindCorruptNums.findNumbers(new int[]{3,1,2,3,6,4});
      System.out.println("Output: ");
      for(int i=0; i<nums.length;i++)
         System.out.println(nums[i]+" ");
      System.out.println("\n");

   }
}
