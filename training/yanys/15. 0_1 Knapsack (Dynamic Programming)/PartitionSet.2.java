class PartitionSet {

   static boolean canPartition(int[] num) {
      //TODO: Write - Your - Code
      int sum = 0;
      for(int i = 0; i < num.length; i++){
         sum += num[i];
      }
      if( sum %2 == 1)
         return false;

      int [][] dp = new int [sum/2+1][num.length];

      return canPartitionRecursive(dp, num, sum/2, 0);
   }

   static boolean canPartitionRecursive(int[][] dp, int[] num, int sum, int cur ){

      if (cur == num.length - 1 ){
         return ( num[cur]==sum );
      }

      if(dp[sum][cur] != 0){
         return( dp[sum][cur] == 1);
      }

      boolean b1 = canPartitionRecursive(dp, num, sum - num[cur], cur + 1);
      boolean b2 = canPartitionRecursive(dp, num, sum, cur + 1);

      dp[sum][cur] = ( b1||b2 ) ?  1: -1;

      return b1 || b2;

   }


   public static void main(String[] args) {
      PartitionSet ps = new PartitionSet();
      int[] num = {1, 2, 3, 4};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 1, 3, 4, 7};
      System.out.println(ps.canPartition(num));
      num = new int[]{2, 3, 4, 6};
      System.out.println(ps.canPartition(num));
   }
}