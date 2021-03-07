class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here
    int maxSum=0, winSum=0;
    int maxStart=0, winStart = 0;

    return -1; 
/*
    if (arr.length < k )
      return -1; 

    for(int i = 0; i < arr.length; i++){
      winSum = winSum + arr[i];
      if(i >= k-1){
        if (winStart == k-1) {
          maxSum = winSum;
          maxStart = 0;
        } else
           winSum = winSum - arr[winStart];
           winStart ++; 
          if(winSum >  maxSum) {
            maxSum = winSum;
            maxStart = winStart;
          }
      }; 
    }

    return maxSum;
   */ 
    
  }
/*
  public static void main( String[] args)
  {
    System.out.println("Max sum of the sub array is" 
      + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int [] { 2 , 1, 5, 1, 3, 2})) ;
    System.out.println("Max sum of the sub array is"
      + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] {2,3,4,1,5})) ;
  }
*/
  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }

}
