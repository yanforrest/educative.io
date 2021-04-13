class SearchBitonicArray {

   public static int search(int[] arr, int key) {
      int start = 0, end = arr.length -1;
      int middle = 0;
      while(start < end ){
         middle = start + ( end - start )/2;
         if(arr[middle] > arr[middle + 1]){
            end = middle;
         }else if (arr[middle] < arr[middle + 1]){
            start = middle + 1;
         }
      }
      int peak = start;
      // find the key in ascending region,
      start = 0; end = peak;
      while (start <= end){
         middle = start + ( end - start ) /2;
         if(arr[middle] > key){
            end = middle - 1;
         }else if ( arr[middle] < key){
            start = middle + 1;
         }else{
            return middle;
         }
      }

      // find the key in ascending region,
      start = peak; end = arr.length -1;
      while (start <= end){
         middle = start + ( end - start ) /2;
         if(arr[middle] > key){
            start = middle+1;
         }else if ( arr[middle] < key){
            end = middle - 1;
         }else{
            return middle;
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