/*
Given an array containing null values fill in the null values with most recent non-null value in the array.
Signature
integer[] returnFilledArray(integer[] input_lst)
Input
Array of integers and/or null values
Output
Array of integers and/or null values
Examples
input: [1,null,2,3,null,null,5,null]
output: [1, 1, 2, 3, 3, 3, 5, 5]

input: [null,8,null]
output: [null, 8, 8]

input: [1,null,2]
output: [1,1,2]

input: [5,null,null]
output: [5,5,5]

input: [1,null,2,3,null,null,5,null]
output: [1,1,2,3,3,3,5,5]
*/

public class ArrayNullFiller {

    // Method to fill null values in the array with the most recent non-null value
    public static Integer[] returnFilledArray(Integer[] input_lst) {
        if (input_lst == null) return null;

        Integer lastNonNull = null;  // Keep track of the last non-null value
        for (int i = 0; i < input_lst.length; i++) {
            if (input_lst[i] != null) {
                lastNonNull = input_lst[i];
            } else if (lastNonNull != null) {
                input_lst[i] = lastNonNull;
            }
        }
        return input_lst;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Integer[] test1 = new Integer[]{1, null, 2, 3, null, null, 5, null};
        Integer[] test2 = new Integer[]{null, 8, null};
        Integer[] test3 = new Integer[]{1, null, 2};
        Integer[] test4 = new Integer[]{5, null, null};
        Integer[] test5 = new Integer[]{1, null, 2, 3, null, null, 5, null};

        System.out.println("Output: " + java.util.Arrays.toString(returnFilledArray(test1)));
        System.out.println("Output: " + java.util.Arrays.toString(returnFilledArray(test2)));
        System.out.println("Output: " + java.util.Arrays.toString(returnFilledArray(test3)));
        System.out.println("Output: " + java.util.Arrays.toString(returnFilledArray(test4)));
        System.out.println("Output: " + java.util.Arrays.toString(returnFilledArray(test5)));
    }
}
