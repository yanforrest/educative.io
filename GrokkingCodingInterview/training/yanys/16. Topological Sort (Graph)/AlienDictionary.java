import java.util.*;

class AlienDictionary {
   public static String findOrder(String[] words) {
      // TODO: Write your code here
      if( words == null ) return new String();

      Map<Character, Integer> inDegree = new HashMap<>();
      Map<Character, List<Character>> graph = new HashMap<>();

      for(String word : words){
         for(Character character : word.toCharArray()){
            inDegree.put(character, 0);
            graph.put(character, new ArrayList<>());
         }
      }

      for (int i = 0; i < words.length - 1 ; i++){
         String word0 = words[i], word1 = words[i+1];
         for(int j =0; j < Math.min(word0.length(), word1.length()); j++){
            Character parent = word0.charAt(j);
            Character child = word1.charAt(j);
            if(parent != child){
               inDegree.put(child, inDegree.get(child) + 1);
               graph.get(parent).add(child);
               break;
            }
         }
      }

      Queue<Character> queue = new LinkedList<>() ;
      for(Character cur : inDegree.keySet()){
         if (inDegree.get(cur) == 0)
            queue.add(cur);
      }

      String result = new String();
      while(!queue.isEmpty()){
         Character source = queue.poll();
         result += source;

         for( Character child : graph.get(source)){
            inDegree.put(child, inDegree.get(child) - 1);
            if(inDegree.get(child) == 0)
               queue.add(child);
         }
      }

      if(result.length()!= inDegree.size()) return "";
      return result;

   }

   public static void main(String[] args) {
      String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab"});
      System.out.println("Character order: " + result);

      result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
      System.out.println("Character order: " + result);

      result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
      System.out.println("Character order: " + result);
   }
}