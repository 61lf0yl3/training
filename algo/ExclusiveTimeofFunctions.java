import java.util.List;
import java.util.Stack;

class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int currID = -1;
        int lastTimestamp = 0;
        Stack<Integer> s = new Stack<>();
        for (String log : logs) {
            String[] message = log.split(":");
            int id = Integer.parseInt(message[0]);
            int timestamp = Integer.parseInt(message[2]);
            if (message[1].equals("start")) {
                if (currID != -1) {
                    res[currID] += (timestamp - lastTimestamp);
                    s.push(currID);
                }
                currID = id;
                lastTimestamp = timestamp;
            } else {
                res[currID] += (timestamp - lastTimestamp + 1);
                lastTimestamp = timestamp + 1;
                currID = s.isEmpty() ? -1 : s.pop();
            }

        }

        return res;
    }
}