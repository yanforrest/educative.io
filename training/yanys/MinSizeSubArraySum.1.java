class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    // TODO: Write your code here
    int winSum = 0;
    int winStart = 0;
    int minSize = arr.length;
    int winSize =0;

    for(int winEnd =0; winEnd < arr.length; winEnd++){
      winSum += arr[winEnd];
      winSize ++;
      if(winSum >= S){
        while((winSum -= arr[winStart]) >= S){
          winStart++;
          winSize--;
        }

        minSize = Math.min(minSize, winSize);
        winStart++;
        winSize--;
      }
    }
    return  minSize;
  }

  public static void main(String[] args) {
  int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
  System.out.println("Smallest subarray length: " + result);
  result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
  System.out.println("Smallest subarray length: " + result);
  result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
  System.out.println("Smallest subarray length: " + result);
}
}
