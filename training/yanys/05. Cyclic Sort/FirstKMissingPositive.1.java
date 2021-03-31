import java.util.*;

class FirstKMissingPositive {

   public static List<Integer> findNumbers(int[] nums, int k) {
      List<Integer> missingNumbers = new ArrayList<>();
      List<Integer> listNumbers =  new ArrayList<>();

      for( int i = 0; i< nums.length; i++){
         listNumbers.add(nums[i]);
      }

      // TODO: Write your code here
      int i = 0;
      while( i < listNumbers.size()){
         if( listNumbers.get(i) > 0 ){
            if ( listNumbers.get(i) > listNumbers.size()){
               for(int j = listNumbers.size()  ; j < listNumbers.get(i); j++)
                  listNumbers.add(-1);
            }

            if(listNumbers.get(i) != listNumbers.get(listNumbers.get(i)-1))
               swap(listNumbers, i, listNumbers.get(i) - 1);
            else
               i++;
         }else{
            i++;
         }
      }

      for(i=0; i < listNumbers.size(); i++){
         if(listNumbers.get(i)!=i+1 &&  missingNumbers.size() < k)
            missingNumbers.add(i+1);
      }

      int j = listNumbers.size() + 1;
      for( i = missingNumbers.size()  ; i < k; i++){
         missingNumbers.add(j++);
      }
      return missingNumbers;
   }

   public static void swap(List<Integer> arr, int i, int j){
      int temp = arr.get(i);
      arr.set(i, arr.get(j));
      arr.set(j, temp);
   }

   public static void main(String[] args) {
      System.out.println("Output: " + FirstKMissingPositive.findNumbers(new int[]{3,-1,4,5,5}, 3));
      System.out.println("Output: " + FirstKMissingPositive.findNumbers(new int[]{2,3,4},3));
      System.out.println("Output: " + FirstKMissingPositive.findNumbers(new int[]{-2,-3,4},2));
   }
}