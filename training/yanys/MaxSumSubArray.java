class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here
    int maxSum=0, winSum=0;
    int winStart = 0;

    if (arr.length < k )
      return -1;

    for(int winEnd = 0; winEnd < arr.length; winEnd++){
      winSum = winSum + arr[winEnd];

      if (winEnd >= k-1) {
        if(winSum >  maxSum) {
          maxSum = winSum;
        }
        winSum = winSum - arr[winStart];
        winStart ++;
      }
    }

    return maxSum;
  }
   public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }

}
