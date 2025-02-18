import java.util.HashMap;

public class BalancedArray {

    public static HashMap<Object, Integer> returnMissingBalancedNumbers(Object[] elements) {
        HashMap<Object, Integer> counts = new HashMap<>();
        // Count occurrences of each element
        for (Object element : elements) {
            counts.put(element, counts.getOrDefault(element, 0) + 1);
        }

        int maxCount = 0;
        // Find the maximum count
        for (Integer count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // Calculate how many more of each element are needed to balance the array
        HashMap<Object, Integer> requiredCounts = new HashMap<>();
        for (Object key : counts.keySet()) {
            int count = counts.get(key);
            if (count < maxCount) {
                requiredCounts.put(key, maxCount - count);
            }
        }

        return requiredCounts;
    }

    public static void main(String[] args) {
        Object[] elements1 = {"a", "b", "abc", "c", "a"};
        System.out.println(returnMissingBalancedNumbers(elements1));

        Object[] elements2 = {1, 3, 4, 2, 1, 4, 1};
        System.out.println(returnMissingBalancedNumbers(elements2));

        Object[] elements3 = {4, 5, 11, 5, 6, 11};
        System.out.println(returnMissingBalancedNumbers(elements3));
    }
}
