class SubsetSum {
   static int countSubsets(int[] num, int sum) {
      int n = num.length;
      int[][] dp = new int[n][sum+1];
      //Initialize the first column
      for(int i = 0; i < n; i++) dp[i][0]=1;

      for(int j = 0; j <= sum ; j++) {
         if (num[0] == j) dp[0][j] = 1;
      }

      for(int i = 1; i < n; i++){
         for(int j = 1; j <= sum; j++){
            dp[i][j] = dp[i-1][j] ;
            if (j >= num[i]) dp[i][j] += dp[i-1][j-num[i]];
         }
      }
      return dp[n-1][sum];

   }

   public static void main(String[] args) {
      SubsetSum ss = new SubsetSum();
      int[] num = { 1, 1, 2, 3 };
      System.out.println(ss.countSubsets(num, 4));
      num = new int[] { 1, 2, 7, 1, 5 };
      System.out.println(ss.countSubsets(num, 9));
   }
}