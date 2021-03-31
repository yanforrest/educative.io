
class HappyNumber {

   public static boolean find(int num) {
      // // TODO: Write your code here
      int fast = trans(trans(num)), slow = trans(num);
      while( fast != slow){
         fast = trans(trans(fast));
         slow = trans(slow);
      }

      return (fast==1);
   }

   private static int trans( int value){
      int result = 0;
      int quotient =  0;
      int remainder = 0;


      while( value != 0 ){
          quotient = value / 10;
          remainder = value - quotient * 10;
          result += remainder * remainder ;
          value = quotient;
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(HappyNumber.find(23));
      System.out.println(HappyNumber.find(12));
   }
}
