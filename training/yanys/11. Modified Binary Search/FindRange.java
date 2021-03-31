class FindRange {

   public static int[] findRange(int[] arr, int key) {


      int[] result = new int[] { -1, -1 };

      if ( key > arr[arr.length - 1 ] || key < arr[0])  return result;


      int length = arr.length;
      int start = 0, end = length-1;

      start = 0; end = length-1;
      while( start+1 != end ){
         int mid = start + (end -start)/2;
         if(arr[mid] >= key){
            end = mid;
         }else{
            start = mid;
         }
      }
      if(arr[end]==key) result[0]= end;
      else result[0]=-1;

      start = 0; end = length-1;
      while(start+1 != end){
         int mid = start + (end -start)/2;
         if(arr[mid] > key){
            end = mid;
         }else{
            start = mid;
         }
      }
      if(arr[start]==key) result[1] = start;
      else result[1]=-1;

      return result;
   }

   public static void main(String[] args) {
      int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
      result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
      result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
   }
}