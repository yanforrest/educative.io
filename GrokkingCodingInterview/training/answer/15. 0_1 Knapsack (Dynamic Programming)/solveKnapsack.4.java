/* memorize bottom-up dynamic programming approach*/

class Knapsack {

   public int solveKnapsack(int[] profits, int[] weights, int capacity) {

      int[][] dp = new int[2][capacity+1];

      for(int i =0; i < 2 ; i++) dp[i][0]=0;

      for(int c=0; c < capacity+1; c++ ) {
         if (weights[0] <= c)
            dp[0][c] = profits[0];
      }

      int n = profits.length;
      for( int i = 1; i< n; i++){
         for(int c= 1; c< capacity +1; c++){
            int profit1 = 0, profit2=0;
            if(weights[i] <= c) profit1 = dp[(i-1)%2][c-weights[i]] + profits[i];
            profit2 = dp[(i-1)%2][c];
            dp[i%2][c]= Math.max(profit1, profit2);
         }
      }

      return dp[(n-1)%2][capacity];
   }

   public static void main(String[] args) {
      Knapsack ks = new Knapsack();
      int[] profits = {1, 6, 10, 16};
      int[] weights = {1, 2, 3, 5};
      int maxProfit = ks.solveKnapsack(profits, weights, 7);
      System.out.println("Total knapsack profit ---> " + maxProfit);
      maxProfit = ks.solveKnapsack(profits, weights, 6);
      System.out.println("Total knapsack profit ---> " + maxProfit);
   }
}