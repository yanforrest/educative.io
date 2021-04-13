class SingleNumber {
   public static int findSingleNumber(int[] arr) {
      int result = 0;
      for(int i = 0; i < arr.length; i++)
      {
         result =result ^ arr[i];
      }
      return result;
   }

   public static void main( String args[] ) {
      System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
   }
}
