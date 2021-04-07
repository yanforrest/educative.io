class Knapsack {

   public int solveKnapsack(int[] profits, int[] weights, int capacity) {
      knapsackRecursive(profits, weights, capacity, 0);
      return knapsackRecursive(profits, weights, capacity, 0);

   }
   private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex){


      if(currentIndex == profits.length-1){
         if (capacity >= weights[currentIndex]) return profits[currentIndex];
         else return 0;
      }

      int profit1 = profits[currentIndex] +  knapsackRecursive(profits, weights,
                        capacity-weights[currentIndex], currentIndex + 1);
      int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

      return Math.max(profit1, profit2);
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