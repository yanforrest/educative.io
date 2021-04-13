import java.lang.Math;

class CalculateComplement {
   public static int bitwiseComplement(int n) {
      int mask =1, v = n;
      while(v!=0){
         mask <<= 1; v>>=1;
      }

      return (mask-1) ^ n;
   }

   public static void main( String args[] ) {
      System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
      System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
   }
}