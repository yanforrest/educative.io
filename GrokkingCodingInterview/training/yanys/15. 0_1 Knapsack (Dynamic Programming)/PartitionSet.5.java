class PartitionSet {

   public boolean canPartition(int[] num) {
      int sum = 0;
      int n = num.length;
      for (int i = 0; i < n; i++)
         sum += num[i];

      if (sum%2 != 0) return false;

      sum /=2;

      boolean[][] dp = new boolean[n][sum+1];

      // initial the first column
      for( int i = 0; i < n;  i++) dp[i][0] = true;

      // initial the first row
      for( int j = 1; j < sum + 1 ; j++) {
         dp[0][j]= num[0]==j ? true : false;
      }

      for( int i = 1; i < n; i++){
         for( int j = 0; j < sum + 1; j ++){
            if (j > num[i]) dp[i][j] = dp[i-1][j-num[i]];
            dp[i][j] |= dp[i-1][j];
         }
      }
      return dp[n-1][sum];
   }

   public static void main(String[] args) {
      PartitionSet ps = new PartitionSet();
      int[] num = { 1, 2, 3, 4 };
      System.out.println(ps.canPartition(num));
      num = new int[] { 1, 1, 3, 4, 7 };
      System.out.println(ps.canPartition(num));
      num = new int[] { 2, 3, 4, 6 };
      System.out.println(ps.canPartition(num));
   }
}