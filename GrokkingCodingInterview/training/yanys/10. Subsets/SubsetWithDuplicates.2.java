import java.util.*;

class SubsetWithDuplicates {

   public static List<List<Integer>> findSubsets(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> subsets = new ArrayList<>();
      List<List<Integer>> lastsets = new ArrayList<>();

      // TODO: Write your code here
      subsets.add(new ArrayList<>());
      lastsets.add(new ArrayList<>());
      int preNumber = nums[0];
      for(int Number: nums ){
         if( preNumber !=Number)
         {
            lastsets.clear();
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
               List<Integer> set = subsets.get(i);
               set = new ArrayList(set);
               set.add(Number);
               subsets.add(set);
               lastsets.add(set);
            }
         } else {
            int n = lastsets.size();
            for (int i = 0; i < n; i++) {
               List<Integer> set = lastsets.get(i);
               set = new ArrayList(set);
               set.add(Number);
               subsets.add(set);
               lastsets.add(set);
            }
         }
         preNumber = Number;
      }
      return subsets;
   }

   public static void main(String[] args) {
      List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
      System.out.println("Here is the list of subsets: " + result);

      result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
      System.out.println("Here is the list of subsets: " + result);
   }
}
