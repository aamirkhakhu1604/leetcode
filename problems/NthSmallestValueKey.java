import java.util.*;

public class NthSmallestValueKey {

    // Function to find key with the nth smallest value
    public static String findNthSmallestKey(Map<String, Integer> map, int n) {
        // Check if map is null or empty
        if (map == null || map.isEmpty()) {
            return "Map is empty or null";
        }

        // Check if n is within the valid range
        if (n <= 0 || n > map.size()) {
            return "Invalid value for n";
        }

        // Create a priority queue to store map entries based on values in ascending order
        PriorityQueue<Map.Entry<String, Integer>> pq =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Add all entries from the map to the priority queue
        pq.addAll(map.entrySet());

        // Retrieve the nth smallest entry
        Map.Entry<String, Integer> nthEntry = null;
        for (int i = 0; i < n; i++) {
            nthEntry = pq.poll();
        }

        // Return the key of the nth smallest entry
        return nthEntry.getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 50);
        map.put("banana", 25);
        map.put("orange", 75);
        map.put("mango", 20);
        map.put("grape", 45);

        int n = 3;
        String result = findNthSmallestKey(map, n);
        System.out.println("The key with the " + n + "rd smallest value: " + result);
    }
}
