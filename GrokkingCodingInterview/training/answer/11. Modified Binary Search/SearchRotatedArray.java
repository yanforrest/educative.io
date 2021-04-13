class SearchRotatedArray {

   public static int search(int[] arr, int key) {
      // TODO: Write your code here

      int start = 0, end = arr.length-1;

      while(start <= end){
         int mid = start + (end-start)/2;

         if (arr[mid] == key) return mid;

         if(arr[mid] < arr[start]){
            if(key > arr[mid]  && key <= arr[end]) {
               start = mid + 1;
            }else {
               end = mid - 1;
            }
         }else {
            if(key < arr[mid]  && key >= arr[start]) {
               end = mid - 1;
            }else {
               start = mid + 1;
            }
         }
      }
      return -1;
   }


   public static void main(String[] args) {
      System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
      System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
   }
}