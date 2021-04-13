class MinimumDifference {

   public static int searchMinDiffElement(int[] arr, int key) {
      // TODO: Write your code here

      int start =0, end = arr.length - 1;

      while(start <= end){
         int mid = start + (end-start)/2;

         if(arr[mid] == key ) return mid;

         if(arr[mid] > key) {
            end = mid - 1;
         }else {
            start = mid + 1 ;
         }
      }

      if(start > arr.length -1 ) start = arr.length - 1;
      if(end < 0) end = 0;
      return Math.min( Math.abs(arr[end]-key), Math.abs(arr[start]-key));
   }

   public static void main(String[] args) {
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
      System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
   }
}