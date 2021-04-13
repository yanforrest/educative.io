class SearchBitonicArray {

   public static int search(int[] arr, int key) {
      int start = 0, end = arr.length -1;
      int middle = 0;

      int peak = findPeak(arr);
      // find the key in ascending region,
      int f1 = binarySearch(arr, 0, peak, key);
      int f2 = binarySearch(arr,  peak, arr.length-1, key);

      if( f1 != -1 ) return f1;
      if( f2 != -1 ) return f2;

      return -1;
   }


   public static int findPeak(int[] arr){
      int start = 0, end = arr.length -1;
      while(start < end ){
         int middle = start + ( end - start )/2;
         if(arr[middle] > arr[middle + 1]){
            end = middle;
         }else if (arr[middle] < arr[middle + 1]){
            start = middle + 1;
         }
      }
   }

   public static int binarySearch(int[] arr, int start, int end, int key){
      boolean isAscending = arr[start] - arr[end] < 0;

      while (start <= end){
         int middle = start + ( end - start ) /2;

         if( arr[middle] == key) return middle;
         if(isAscending) {
            if ( arr[middle] > key ) end = middle - 1;
            if ( arr[middle] < key ) start = middle + 1;
         }else {
            if ( arr[middle] > key ) start = middle + 1;
            if ( arr[middle] < key ) end = middle - 1;
         }
      }
      return -1;
   }
   public static void main(String[] args) {
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
      System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
      System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
   }
}