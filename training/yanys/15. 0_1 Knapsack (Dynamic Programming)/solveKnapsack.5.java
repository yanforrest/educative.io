/* memorize bottom-up dynamic programming approach*/

class Knapsack {

   public int solveKnapsack(int[] profits, int[] weights, int capacity) {

      int n = profits.length;
      int[][] dp = new int[n][capacity+1];

      for(int i =0; i < n ; i++) dp[i][0]=0;

      for(int c=0; c < capacity+1; c++ )
         if(weights[0] <= c)
            dp[0][c]= profits[0];

      for( int i = 1; i< n; i++){
         for(int c= 1; c< capacity +1; c++){
            int profit1 = 0, profit2=0;
            if(weights[i] <= c) profit1 = dp[i-1][c-weights[i]] + profits[i];
            profit2 = dp[i-1][c];

            dp[i][c]= Math.max(profit1, profit2);
         }
      }
      printSelectedElements(dp, weights, profits, capacity);
      return dp[n-1][capacity];
   }

   private void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity) {
      System.out.print("Selected weights:");

      int row = profits.length-1;
      int col = capacity;

      while(col !=0){
         if( row >= 1 && dp[row-1][col] == dp[row][col]) {
            row = row - 1;
         }else {
            // there is an item in this row, print it
            System.out.print(weights[row] + " ");
            col = col - weights[row];
            row = row - 1;
         }
      }

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