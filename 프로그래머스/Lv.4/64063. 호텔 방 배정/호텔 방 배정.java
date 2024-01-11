import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Long, Long> roomMap = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long requestedRoom = room_number[i];
            answer[i] = findEmptyRoom(requestedRoom);
        }

        return answer;
    }

    private long findEmptyRoom(long requestedRoom) {
        if (!roomMap.containsKey(requestedRoom)) {
            roomMap.put(requestedRoom, requestedRoom + 1);
            return requestedRoom;
        }

        long nextRoom = findEmptyRoom(roomMap.get(requestedRoom));
        roomMap.put(requestedRoom, nextRoom);
        return nextRoom;
    }
}
