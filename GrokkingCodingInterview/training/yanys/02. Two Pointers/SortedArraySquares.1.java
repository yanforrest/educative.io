class SortedArraySquares {

   public static int[] makeSquares(int[] arr) {
      int[] squares = new int[arr.length];
      // TODO: Write your code here
      int left = 0;
      int right = arr.length -1;
      int cur = arr.length -1;;
      int leftSquare;
      int rightSquare;
      
      while(left != right){
         leftSquare = arr[left]*arr[left];
         rightSquare = arr[right]*arr[right];
         if(leftSquare > rightSquare ){
            squares[cur--] = leftSquare;
            left++;

         } else {
            squares[cur--] = rightSquare;
            right --;
         }
      }

      return squares;
   }

   public static void main(String[] args) {

      int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
      for (int num : result)
         System.out.print(num + " ");
      System.out.println();

      result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
      for (int num : result)
         System.out.print(num + " ");
      System.out.println();
   }
}

