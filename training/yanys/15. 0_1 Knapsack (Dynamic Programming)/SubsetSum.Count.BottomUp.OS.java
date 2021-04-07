class SubsetSum {
   static int countSubsets(int[] num, int sum) {
      int n = num.length;
      int[][] dp = new int[2][sum+1];
      //Initialize the first column
      for(int i = 0; i < 2; i++) dp[i][0]=1;

      for(int j = 0; j <= sum ; j++) {
         if (num[0] == j) dp[0][j] = 1;
      }

      for(int i = 1; i < n; i++){
         for(int j = 1; j <= sum; j++){
            dp[i%2][j] = dp[(i-1)%2][j] ;
            if (j >= num[i]) dp[i%2][j] += dp[(i-1)%2][j-num[i]];
         }
      }

      return dp[(n-1)%2][sum];

   }

   public static void main(String[] args) {
      SubsetSum ss = new SubsetSum();
      int[] num = { 1, 1, 2, 3 };
      System.out.println(ss.countSubsets(num, 4));
      num = new int[] { 1, 2, 7, 1, 5 };
      System.out.println(ss.countSubsets(num, 9));
   }
}