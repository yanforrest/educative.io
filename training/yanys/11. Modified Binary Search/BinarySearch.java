class BinarySearch {

   public static int search(int[] arr, int key) {
      int length = arr.length;
      boolean isAscending = arr[length-1] - arr[0] > 0;
      int start = 0, end = length - 1;

      while(end >= start){
         int mid = start +(end-start)/2;

         if(arr[mid] == key) return mid;

         if(isAscending){
            if (arr[mid] > key) end = mid - 1;
            else start = mid + 1;
         }else{
            if (arr[mid] > key) start = mid + 1;
            else end = mid - 1;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
      System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
      System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
      System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
   }
}