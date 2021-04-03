import java.util.*;

class TaskScheduler {

   public static int scheduleTasks(char[] tasks, int k) {
      Map<Character, Integer> taskFreqMap = new HashMap<>();

      for( char task: tasks){
         taskFreqMap.put(task, taskFreqMap.getOrDefault(task, 0)+1);
      }
      PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());

      maxHeap.addAll(taskFreqMap.entrySet());

      Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

      int i = 0;
      String finishedTasks = "";
      while(i < tasks.length){
         if(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entity = maxHeap.poll();
            finishedTasks += entity.getKey(); i++;
            entity.setValue(entity.getValue()-1);
            queue.add(entity);
         }else{
            finishedTasks +=" ";
            queue.add(null);
         }


         if(queue.size() == k+1){
            Map.Entry<Character, Integer> entry = queue.poll();
            if( entry != null &&entry.getValue() > 0)
               maxHeap.add(entry);
         }
      }
      System.out.println("finished tasks as : " +  finishedTasks);
      return finishedTasks.length();
   }

   public static void main(String[] args) {
      char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
      System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

      tasks = new char[] { 'a', 'b', 'a' };
      System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
   }
}
