import com.sun.corba.se.spi.ior.iiop.RequestPartitioningComponent;

class SubsetSum {

  public boolean canPartition(int[] num, int sum) {
    // TODO: Write your code here
    boolean[][] dp = new boolean[num.length][sum+1];

    // first, initial the first column
    for(int i =0; i< num.length; i++) dp[i][0] = true;

    //second, intial the first row
    for(int j =0; j <= sum; j++) {
      if (j == num[0]) dp[0][j] = true;
    }

    for(int i = 1; i < num.length; i++ ){
      for(int j = 1; j <= sum; j++ ){
      /*  if(dp[i-1][j] ){
          dp[i][j] = dp[i-1][j];
        }else{
          if (j >= num[i]) dp[i][j]= dp[i-1][j-num[i]];
        }*/
        if (j >= num[i]) dp[i][j]= dp[i-1][j-num[i]];
         dp[i][j] = dp[i][j]  || dp[i-1][j] ;
      }
    }
    return dp[num.length-1][sum];
  }

  public static void main(String[] args) {
    SubsetSum ss = new SubsetSum();
    int[] num = { 1, 2, 3, 7 };
    System.out.println(ss.canPartition(num, 6));
    num = new int[] { 1, 2, 7, 1, 5 };
    System.out.println(ss.canPartition(num, 10));
    num = new int[] { 1, 3, 4, 8 };
    System.out.println(ss.canPartition(num, 6));
  }
}