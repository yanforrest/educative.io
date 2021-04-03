import java.util.*;
class Element {
   int number;
   int frequency;
   int sequenceNumber;
   public Element( int number, int frequency, int sequenceNumber){
      this.number = number;
      this.frequency = frequency;
      this.sequenceNumber = sequenceNumber;
   }
}

class ElementComparator implements Comparator<Element>
{
   @Override
   public int compare(Element o1, Element o2) {
      if(o1.frequency != o2.frequency)
         return o2.frequency - o1.frequency;
      return o2.sequenceNumber - o1.sequenceNumber;
   }
};

class FrequencyStack {
   int sequenceNumber = 0;
   Map<Integer, Integer> numFreqMap = new HashMap<>();
   PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());

   public void push(int num) {
      // TODO: Write your code here
      numFreqMap.put(num, numFreqMap.getOrDefault(num, 0)+1);

      maxHeap.add(new Element(num, numFreqMap.get(num), sequenceNumber++ ));

   }

   public int pop() {
      Element cur = maxHeap.poll();
      if(cur.frequency > 0)
         numFreqMap.put(cur.number, numFreqMap.getOrDefault(cur.number, 0) - 1);
      else
         numFreqMap.remove(cur.number);

      sequenceNumber--;


      return cur.number;
   }

   public static void main(String[] args) {
      FrequencyStack frequencyStack = new FrequencyStack();
      frequencyStack.push(1);
      frequencyStack.push(2);
      frequencyStack.push(3);
      frequencyStack.push(2);
      frequencyStack.push(1);
      frequencyStack.push(2);
      frequencyStack.push(5);
      System.out.println(frequencyStack.pop());
      System.out.println(frequencyStack.pop());
      System.out.println(frequencyStack.pop());
   }
}