class RotationCountOfRotatedArray {

   public static int countRotations(int[] arr) {
      // TODO: Write your code here
      if( arr[0] < arr[arr.length-1]) return 0;
      int start =0, end = arr.length-1;


      while(start + 1 < end){

         int mid = start + (end-start)/2;

         if(arr[start] > arr[mid] ) end = mid;
         else  start = mid;

      }
      return end;
   }

   public static void main(String[] args) {
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 ,  -3, -2, -1, 0}));
   }
}
