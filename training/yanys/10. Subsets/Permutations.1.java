import java.util.*;

class Permutations {

   public static List<List<Integer>> findPermutations(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      // TODO: Write your code here
      result.add(new ArrayList<>());

      for(int number : nums ){
         int n = result.size();
         for(int i=0; i<n; i++){
            List<Integer> cur = result.remove(0);
            for(int j=0; j<= cur.size(); j++){
               List<Integer> permutation = new ArrayList<>(cur);
               permutation.add(j, number);
               result.add(permutation);
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
      System.out.print("Here are all the permutations: " + result);
   }
}