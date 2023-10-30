class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] intArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // custom comparator to sort by bit and then numerically
        Comparator<Integer> comparator = new BitCountComparator();

        Arrays.sort(intArr, comparator);

        return Arrays.stream(intArr).mapToInt(Integer::intValue).toArray();
    }

     
}

class BitCountComparator implements Comparator<Integer> {

    private int findBitCount(Integer n) {
        int count = 0;
        while (n > 0) {
            count = count + (n & 1);
            n = n >> 1;
        }
        return count;
    }

    @Override
    public int compare(Integer a, Integer b) {

        int bitCountA = findBitCount(a);
        int bitCountB = findBitCount(b);

        // if bit count is same then compare numerically
        if (bitCountA == bitCountB) {
            return a - b;
        } 
        return bitCountA - bitCountB;
    }
}
