import com.sun.corba.se.spi.ior.iiop.RequestPartitioningComponent;

class SubsetSum {

  public boolean canPartition(int[] num, int sum) {
    // TODO: Write your code here
    return canPartitionRecursive(num, sum, 0);
  }

  boolean canPartitionRecursive(int[] num , int sum, int index){

    if(index == num.length - 1 ){
      if(sum == 0) return true;
      else if(num[index]==sum) return true;
      return false;
    }

    if( canPartitionRecursive(num, sum, index+1) )  return true;

    if( canPartitionRecursive(num, sum-num[index], index+1) ) return true;

    return false;
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