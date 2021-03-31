class Solution {
   public static int[][] flipAndInvertImage(int[][] arr) {
      int height = arr.length, width = arr[0].length;
      for( int row =0; row < height; row ++){
         for( int col =0; col < (width +1) >> 1; col ++){
            int temp = arr[row][col];
            arr[row][col] = arr[row][width-1-col] ^ 1;
            arr[row][width-1-col] = temp ^ 1;
         }
      }
      return arr;
   }

   public static void print(int[][] arr) {
      for(int i=0; i < arr.length; i++) {
         for (int j=0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

   public static void main(String[] args) {
      int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
      print(flipAndInvertImage(arr));

      int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
      print(flipAndInvertImage(arr2));
   }
}
