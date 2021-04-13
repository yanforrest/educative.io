class SearchRotatedArray {

   public static int search(int[] arr, int key) {
      // TODO: Write your code here
      int start = find_boundary(arr, key);
      int f1 = binarySearch(arr, start, arr.length-1, key);
      int f2 = binarySearch(arr, 0, start-1, key);

      if(f1 != -1) return f1;
      if(f2 != -1) return f2;
      return -1;
   }

   public static int find_boundary(int[] arr, int key){
      int length = arr.length;
      if (arr[0]< arr[length-1]) return 0;

      int start =0, end = length-1;

      while( start < end ){
         int middle = start + (end - start) / 2;
         if(arr[middle] > arr[0]) start = middle + 1;
         if(arr[middle] < arr[length-1]) end = middle;
      }
      return start;
   }
   public static int binarySearch(int[] arr, int start, int end, int key){

      while(start <= end){
         int middle = start + (end-start)/2;
         if(arr[middle] == key) return middle;

         if(arr[middle] > key)  end = middle - 1;
         else  start = middle +1;
      }
      return -1;
   }

   public static void main(String[] args) {
      System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
      System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
   }
}