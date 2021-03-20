import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;

class Meeting {
   int start;
   int end;

   public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
   }
};

class MinimumMeetingRooms {

   public static int findMinimumMeetingRooms(List<Meeting> meetings) {
      // TODO: Write your code here

      Collections.sort(meetings, (a, b) ->Integer.compare(a.start, b.start));

      List<Meeting> roomList = new ArrayList<>();

      for(int i = 0; i < meetings.size() - 1; i ++){
         int j = 0;
         int start = meetings.get(i).start;
         int end = meetings.get(i).end;

         for( j = 0; j < roomList.size(); j++ ){
            if( roomList.get(j).end <= start) break;
         }
         if( j == roomList.size()){
            roomList.add(new Meeting(start, end));
         }else {
            Meeting cur = roomList.get(j);
            cur.start = Math.min(cur.start, start );
            cur.end = Math.max(cur.end, end );
         }

      }
      return roomList.size();
   }

   public static void main(String[] args) {
      List<Meeting> input = new ArrayList<Meeting>() {
         {
            add(new Meeting(1, 4));
            add(new Meeting(2, 5));
            add(new Meeting(7, 9));
         }
      };
      int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
      System.out.println("Minimum meeting rooms required: " + result);

      input = new ArrayList<Meeting>() {
         {
            add(new Meeting(6, 7));
            add(new Meeting(2, 4));
            add(new Meeting(8, 12));
         }
      };
      result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
      System.out.println("Minimum meeting rooms required: " + result);

      input = new ArrayList<Meeting>() {
         {
            add(new Meeting(1, 4));
            add(new Meeting(2, 3));
            add(new Meeting(3, 6));
         }
      };
      result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
      System.out.println("Minimum meeting rooms required: " + result);

      input = new ArrayList<Meeting>() {
         {
            add(new Meeting(4, 5));
            add(new Meeting(2, 3));
            add(new Meeting(2, 4));
            add(new Meeting(3, 5));
         }
      };
      result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
      System.out.println("Minimum meeting rooms required: " + result);
   }
}
