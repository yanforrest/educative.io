public class RemoveElement {
   public static int remove(int[] arr, int key) {
      // TODO: Write your code here
      int left = 0;
      for(int right = 0; right < arr.length; right++){
         if(arr[right] != key) {
            arr[left++] = arr[right];
         }
      }
      return left;
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
      System.out.println(RemoveElement.remove(arr, 3));

      arr = new int[] { 2, 11, 2, 2, 1 };
      System.out.println(RemoveElement.remove(arr, 2));
   }
}
