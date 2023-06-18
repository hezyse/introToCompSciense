public class PalindromicSequence {
    public static int longestPalindrome(int[] arr) {
        return longestPalindrome(arr, 0, arr.length - 1, false);
    }


    public static int longestPalindrome(int[] arr, int start, int end, boolean previousMatched) {
        // Base case: If the start index is equal to or greater than the end index, it's a palindrome of length 1 or 0
        if (start >= end) {
            int returnSize = end - start + 1;
            return returnSize;
        }

        // Recursive case: Check if the first and last elements are the same
        if (arr[start] == arr[end]) {
            // If the first and last elements are the same, recursively check the sequence without the first and last elements
            int next_inner = longestPalindrome(arr, start + 1, end - 1, true);
            int innerPolindrome = 2 + next_inner;
            if (innerPolindrome != 2 || start + 1 >= end - 1)
                return innerPolindrome;
            else
                return 0;
        } else if (arr[start] != arr[end] && previousMatched) {
            return 0;
        } else {
            // If the first and last elements are not the same, recursively check the sequence without the last element
            int length1 = longestPalindrome(arr, start, end - 1, false);
            // Recursively check the sequence without the first element
            int length2 = longestPalindrome(arr, start + 1, end, false);
            // Return the maximum length between the two cases
            return Math.max(length1, length2);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 3, 10, 10, 3, 2, 4};
        int[] arr2 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int[] arr3 = {1, 3, 2, 3, 6, 10, 3, 2};

        int longestSeq1 = longestPalindrome(arr1);
        int longestSeq2 = longestPalindrome(arr2);
        int longestSeq3 = longestPalindrome(arr3);

        System.out.println("Longest palindromic sequence in arr1: " + longestSeq1);
        System.out.println("Longest palindromic sequence in arr2: " + longestSeq2);
        System.out.println("Longest palindromic sequence in arr2: " + longestSeq3);
    }
}
