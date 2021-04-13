import java.util.*;

class GeneralizedAbbreviation {

   public static List<String> generateGeneralizedAbbreviation(String word) {
      List<String> result = new ArrayList<String>();
      // TODO: Write your code here
      List<String> subsets = new ArrayList<>();
      subsets.add(new String());
      for(int i=0; i < word.length(); i++){
         int n = subsets.size();
         for(int j=0; j< n; j++){
            String cur =subsets.remove(0);
            subsets.add(cur + ' ');
            subsets.add(cur + word.charAt(i) );
         }
      }

      while(!subsets.isEmpty()){
         String inStr = subsets.remove(0);
         String outStr = "";
         int abbreviateNum = 0;
         for(int i = 0; i < inStr.length(); i++){
            if( inStr.charAt(i) == ' '){
               abbreviateNum++;
               if(i == inStr.length() - 1 || inStr.charAt(i+1) != ' ' ){
                  outStr += abbreviateNum;
                  abbreviateNum = 0;
               }
            }else{
               outStr += inStr.charAt(i);
            }
         }
         result.add(outStr);
      }
      return result;
   }

   public static void main(String[] args) {
      List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
      System.out.println("Generalized abbreviation are: " + result);

      result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
      System.out.println("Generalized abbreviation are: " + result);
   }
}