class PartitionSet {

   static boolean canPartition(int[] num) {
      //TODO: Write - Your - Code
      int sum = 0;
      for(int i = 0; i < num.length; i++){
         sum += num[i];
      }
      if( sum %2 == 1)
         return false;

      Boolean [][] dp = new Boolean [num.length][sum/2+1];

      return canPartitionRecursive(dp, num, sum/2, 0);
   }

   static boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int cur ){

      if (sum == 0) return true;
      if(num.length==0 || cur >=num.length) return false;

      if (cur == num.length - 1 ){
         return ( num[cur]==sum );
      }

      if(dp[cur][sum] == null){
         if( num[cur] <= sum ) {
            if (canPartitionRecursive(dp, num, sum - num[cur], cur + 1)) {
               dp[cur][sum]= true;
               //dp[cur + 1][sum - num[cur]]=dp[cur][sum];
               return true;
            }
         }
         dp[cur][sum]=canPartitionRecursive(dp, num, sum, cur + 1);
         //dp[cur + 1][sum]=dp[cur][sum];
      }else{
         System.out.println("hit memory");
      }

      return dp[cur][sum];

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