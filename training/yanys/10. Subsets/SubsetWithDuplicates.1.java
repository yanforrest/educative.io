import java.util.*;

class SubsetWithDuplicates {

   public static List<List<Integer>> findSubsets(int[] nums) {
      
      List<List<Integer>> subsets = new ArrayList<>();
      // TODO: Write your code here
      subsets.add(new ArrayList<>());
      for(int Number: nums ){
         int n = subsets.size();
         for(int i=0; i< n; i++){
            List<Integer> set = subsets.get(i);
            set = new ArrayList(set);
            set.add(Number);
            if(!subsets.contains(set))
               subsets.add(set);
         }
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
