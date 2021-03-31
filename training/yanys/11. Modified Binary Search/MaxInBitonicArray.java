class MaxInBitonicArray {

   public static int findMax(int[] arr) {
      // TODO: Write your code here

      int start =0, end = arr.length -1;

      while (start < end ){
         int middle = start + (end - start) /2;
         if(arr[middle] > arr[middle + 1]){
            end = middle;
         }else if (arr[middle] < arr[middle + 1]){
            start = middle+1;
         }
      }
      return arr[start];
   }

   public static void main(String[] args) {
      System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 2}));
      System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
      System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
      System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
      System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
   }
}