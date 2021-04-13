class PartitionSet {

   public int canPartition(int[] num) {
      int Sum = 0, sum=0;
      int n = num.length;
      for (int i =0; i < n; i++)
         Sum += num[i];
      sum = Sum/2+1;

      boolean[][] dp = new boolean[n][sum];

      // initialize the first column to true;
      for(int i = 0; i < n; i++)
         dp[i][0] = true;
      // initialize the first row
      for(int i = 0; i < sum;  i++)
         if (i == num[0]) dp[0][i] = true;


      for(int i = 1; i < n; i++) {
         for (int j = 1; j < sum; j++) {
            if( dp [i-1][j]) {
               dp[i][j] = dp [i-1][j];
            } else {
               if( num[i] <= j ) dp[i][j] = dp [i-1][j-num[i]];
            }
         }
      }
      int j = sum;
      while(dp[n-1][--j]!=true);

      return Sum-j-j;
   }

   public static void main(String[] args) {
      PartitionSet ps = new PartitionSet();
      int[] num = {1, 2, 3, 9};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 3, 100, 4};
      System.out.println(ps.canPartition(num));
   }
}