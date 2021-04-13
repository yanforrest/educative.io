class CeilingOfANumber {

   public static int searchCeilingOfANumber(int[] arr, int key) {
      int length = arr.length;
      int start=0, end=length-1;
      while(start<=end){
         int mid = start + (end-start)/2;
         if(arr[mid]==key) return mid;

         if(arr[mid] > key){
            if(mid - 1 < 0 ) return 0;
            if(arr[mid-1] < key) return mid;
            end = mid - 1;
         }else{
            if(mid + 1 > length - 1) return -1;
            if(arr[mid+1] > key) return mid +1;
            start = mid + 1;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
      System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
      System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
      System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
   }
}