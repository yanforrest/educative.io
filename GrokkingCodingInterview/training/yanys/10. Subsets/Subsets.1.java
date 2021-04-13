import java.util.*;

class Subsets {

   public static List<List<Integer>> findSubsets(int[] nums) {
      List<List<Integer>> subsets = new ArrayList<>();
      // TODO: Write your code here
      List<Integer> cur = new ArrayList<>();
      subsets.add(cur);
      for( int level = 0; level < nums.length; level++){
         int length = subsets.size();
         for(int i=0; i < length; i++){
            cur = new ArrayList<>(subsets.get(i));
            cur.add(nums[level]);
            subsets.add(cur);
         }
      }
      return subsets;
   }

   public static void main(String[] args) {
      List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
      System.out.println("Here is the list of subsets: " + result);

      result = Subsets.findSubsets(new int[] { 1, 5, 3 });
      System.out.println("Here is the list of subsets: " + result);
   }
}
