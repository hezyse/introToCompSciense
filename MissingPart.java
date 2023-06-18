public class MissingPart {
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

    public static void main(String[] args) {

        int[] array1 = {20, 17, 14, 8, 5, 2};


        int theMissingValue = missingValue(array1);
        System.out.println("Missing Value is: " + theMissingValue);
    }
}
