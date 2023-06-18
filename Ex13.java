public class Ex13 {
    public static boolean isSum(int[] a, int num) {
        return isSum(a, num, 0, 1);
    }

    private static boolean isSum(int[] a, int num, int index, int toalSeq) {
        // Base cases:
        if (num == 0) {
            // If the desired sum is 0, an empty subset is valid
            return true;
        }
        if (index >= a.length) {
            // If we have reached the end of the array and the desired sum is not 0, no valid subset exists
            return false;
        }

        // Recursive cases:
        // Check if we can include the current element in the subset
        if (num >= a[index] && !(toalSeq == 3)) {
            if (isSum(a, num - a[index], index + 1, toalSeq + 1)) {
                return true;
            }
        }

        // Skip the current element and move to the next index
        return isSum(a, num, index + 1, 1);
    }
    
    public static int missingValue (int [] arr) {
        int length = arr.length;
        int delta = arr[1] - arr[0];
        int retVal = Integer.MAX_VALUE;
        for (int i=2; i < length; i++) {
            int curDelta = arr[i] - arr[i - 1];
            if (curDelta / delta == 0) {
                retVal = arr[i - 1] - curDelta;
                break;
            }
            else if (curDelta / delta == 2) {
                retVal = arr[i] - delta;
                break;
            }
        }
        return retVal;
    }
    
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
    
     public static int shortestRoad(int[] road1, int[] road2) {
        int n = road1.length;
        int totalTime = 0;

        // Calculate the total time if the driver stays on road 1 without switching
        for (int i = 0; i < n; i++) {
            totalTime += road1[i];
        }

        // Calculate the total time if the driver switches from road 1 to road 2
        // Find the minimum time to switch by comparing the time at each index
        int switchTime = Integer.MAX_VALUE;
        int currentTotalTime = 0;
        for (int i = 0; i < n; i++) {
            currentTotalTime += road1[i];
            int remainingTime = getTotalTime(road2, i + 1, n);
            switchTime = Math.min(switchTime, currentTotalTime + remainingTime);
        }

        // Calculate the total time if the driver switches from road 2 to road 1
        // Find the minimum time to switch by comparing the time at each index
        currentTotalTime = 0;
        for (int i = 0; i < n; i++) {
            currentTotalTime += road2[i];
            int remainingTime = getTotalTime(road1, i + 1, n);
            switchTime = Math.min(switchTime, currentTotalTime + remainingTime);
        }

        // Return the minimum time among the three possibilities
        return Math.min(totalTime, switchTime);
    }

    private static int getTotalTime(int[] road, int startIndex, int endIndex) {
        int totalTime = 0;
        for (int i = startIndex; i < endIndex; i++) {
            totalTime += road[i];
        }
        return totalTime;
    }


    
}
