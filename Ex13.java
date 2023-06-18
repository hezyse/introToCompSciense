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


    
}
