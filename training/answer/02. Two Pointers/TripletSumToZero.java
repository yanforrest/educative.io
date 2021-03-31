import java.util.*;

public class TripletSumToZero {

   public static List<List<Integer>> searchTriplets(int[] arr){
      List<List<Integer>> triplets = new ArrayList<>();
      Arrays.sort(arr);

      for(int i = 0; i < arr.length; i ++){
         if(i>0 && arr[i] ==arr[i-1]  )
            continue;
         searchPair(arr, -arr[i], i+1, triplets);
      }
      return triplets;

   }
   public static List<List<Integer>> searchPair(int[] arr, int target, int left,  List<List<Integer>> triplets) {

      for( int i = left; i < arr.length; i++){
         for(int j = i; j < arr.length; j++){
            if( target == arr[i] + arr[j] ){
               if(!triplets.contains(Arrays.asList(-target, arr[i], arr[j])))
                  triplets.add(Arrays.asList(-target, arr[i], arr[j]));

            }
         }
      }
      return triplets;
   }

   public static void main(String[] args) {
      System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
      System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
   }

}
