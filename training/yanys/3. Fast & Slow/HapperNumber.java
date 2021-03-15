class HappyNumber {

   public static boolean find(int num) {
      // // TODO: Write your code here
      int fast = num, slow = num;
      do{
         fast = trans(trans(fast));
         slow = trans(slow);
      }while( fast != slow);

      return (fast==1);
   }

   private static int trans( int value){
      int result = 0;
      int remainder = 0;


      while( value != 0 ){
          remainder = value % 10;
          result += remainder * remainder ;
          value = value / 10;
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(HappyNumber.find(23));
      System.out.println(HappyNumber.find(12));
   }
}
