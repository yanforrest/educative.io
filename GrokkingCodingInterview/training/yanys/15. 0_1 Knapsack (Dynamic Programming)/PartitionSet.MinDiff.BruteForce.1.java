class PartitionSet {

   public int canPartition(int[] num) {
      int sum = 0;
      for(int i = 0; i < num.length; i++ )
         sum += num[i];

      return Math.abs((sum % 2) +  2 * canPartitionRecursive(num, sum/2, 0));
   }
   int canPartitionRecursive(int[] num, int sum, int index) {
      if(index == num.length-1)
         return sum - num[index];

      int d1 = canPartitionRecursive(num, sum, index+1);
      int d2 = canPartitionRecursive(num, sum-num[index], index+1);

      if(Math.abs(d1) < Math.abs(d2)) return d1;
      else return d2;
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