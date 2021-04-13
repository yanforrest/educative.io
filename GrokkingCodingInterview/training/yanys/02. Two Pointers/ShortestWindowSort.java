class ShortestWindowSort {

   public static int sort(int[] arr) {
      // TODO: Write your code here
      int left=0, right=arr.length-1;
      int i;
      for(left=0; left < arr.length-1; left++){
         if(arr[left] > arr[left+1])
            break;
      }

      for(right= arr.length-1 ; right > 0; right--){
         if( arr[right-1] > arr[right] )
            break;
      }

      if( left >= right ) return 0;


      for( i = left+1; i <= right-1; i++){

         while (left >= 0 && arr[i] < arr[left] )
            left--;

         while( right <= arr.length -1  && arr[i]  > arr[right] )
            right ++;
      }

      return (right-left-1);
   }

   public static void main(String[] args) {
      System.out.println(ShortestWindowSort.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
      System.out.println(ShortestWindowSort.sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
      System.out.println(ShortestWindowSort.sort(new int[]{1, 2, 3}));
      System.out.println(ShortestWindowSort.sort(new int[]{3, 2, 1}));
   }
}