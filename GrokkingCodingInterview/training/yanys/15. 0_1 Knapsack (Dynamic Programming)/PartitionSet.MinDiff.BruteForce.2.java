class PartitionSet {

   public int canPartition(int[] num) {
      int sum = 0;
      for(int i = 0; i < num.length; i++ )
         sum += num[i];

      return canPartitionRecursive(num, 0, 0, 0);
   }

   int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2) {
      if(currentIndex == num.length)
         return Math.abs( sum1 - sum2 );

      int d1 = canPartitionRecursive(num, currentIndex + 1, sum1 + num[currentIndex],  sum2);
      int d2 = canPartitionRecursive(num, currentIndex + 1,  sum1,  sum2 + num[currentIndex]);


      return Math.min(d1, d2);
   }

   public static void main(String[] args) {
      PartitionSet ps = new PartitionSet();
      int[] num = {1, 2, 3, 9};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 3, 100, 4};
      System.out.println(ps.canPartition(num));
   }
}