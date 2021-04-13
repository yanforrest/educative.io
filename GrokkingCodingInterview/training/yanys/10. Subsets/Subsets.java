import java.util.*;

class Subsets {

   public static List<List<Integer>> findSubsets(int[] nums) {
      List<List<Integer>> subsets = new ArrayList<>();
      // TODO: Write your code here
      subsets.add(new ArrayList<>());
      for( int currentNumber : nums){
         int length = subsets.size();
         for(int i=0; i < length; i++){
            List<Integer> set = new ArrayList<>(subsets.get(i));
            set.add(currentNumber);
            subsets.add(set);
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
