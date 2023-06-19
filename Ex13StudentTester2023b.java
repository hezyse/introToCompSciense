import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex13StudentTester2023b {
    // ANSI escape code for red color
    public static String redColor = "\u001B[31m";
    // ANSI escape code for green color
    public static String greenColor = "\u001B[32m";
    // ANSI escape code for reset (to default color)
    public static String resetColor = "\u001B[0m";

    public static void main(String[] args) {



        System.out.println("----------------------------------------");
        System.out.println("***       Q1  - shortestRoad         ***");
        System.out.println("----------------------------------------");

        int[] road1={5,4,5,8,12,9,9,3};
        int[] road2={7,3,3,12,10,2,10,7};
        runEx1(road1, road2, 49);
        int[] road3={5};
        int[] road4={7};
        runEx1(road3, road4, 5);
        int[] road5={5,4,5};
        int[] road6={7,3,3};
        runEx1(road5, road6, 11);


        System.out.println("----------------------------------------");
        System.out.println("***     Q2  - missingValue           ***");
        System.out.println("----------------------------------------");
        {
            int []arr1 = {7,10,13,16,22,25};
            runEx2(arr1, 19);
            int []arr2 = {7,13,16,19,22,25};
            runEx2(arr2, 10);
            int []arr3 = {7,10,13,16,19,25};
            runEx2(arr3, 22);

        }

        System.out.println("----------------------------------------");
        System.out.println("***     Q3  - longestPalindrome      ***");
        System.out.println("----------------------------------------");
        {
            int[] arr0= {1,3,2,1};
            runEx3(arr0,1);
            int[] arr1= {1,3,2,3,10,10,3,2,4};
            runEx3(arr1,6);
            int[] arr2 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
            runEx3(arr2, 9);
            int[] arr3 = {1,3,2,3,7,10,3,2,4};
            runEx3(arr3,3);
            int[] arr4 = {1};
            runEx3(arr4,1);
            int[] arr5 = {1,1};
            runEx3(arr5,2);
            int[] arr6 = {1,3,2,4,5,2,3,1};
            runEx3(arr6,1);
            int[] arr7 = {2, 4, 2, 10, 12, 10, 2};
            runEx3(arr7,5);
            int[] arr8 = {3, 6, 3, 9, 5, 3, 6, 3};
            runEx3(arr8,3);
            int[] arr9 = {1, 1, 1, 1, 1, 1, 3, 6, 9, 7, 8, 9, 6, 3, 1, 1, 1, 1, 1, 1};
            runEx3(arr9,6);
        }
        System.out.println("----------------------------------------");
        System.out.println("***       Q4  - isSum                ***");
        System.out.println("----------------------------------------");
        {
            int[] arr={5,4,2,1,3};
            runEx4(arr, 0, true);
            runEx4(arr, 8, true);
            runEx4(arr, 9, true);
            runEx4(arr, 2, true);
            runEx4(arr, 11, false);
            runEx4(arr, 17, false);

            System.out.println("----------------------------------------");

        }
    }

    public static void runEx1(int[] road1, int[] road2, int expectedResult){
        System.out.println("Road1 : " + Arrays.toString(road1));
        System.out.println("Road2 : " + Arrays.toString(road2));
        int result1=Ex13.shortestRoad(road1, road2);
        printResult(result1, expectedResult);
    }

    public static void runEx2(int[] arr, int expectedResult){
        System.out.println("arr: " + Arrays.toString(arr));
        int result2=Ex13.missingValue(arr);
        printResult(result2, expectedResult);
    }

    public static void runEx3(int[] arr, int expectedResult){
        System.out.println("arr: " + Arrays.toString(arr));
        int result3=Ex13.longestPalindrome(arr);
        printResult(result3, expectedResult);
    }
    public static void runEx4(int[] arr, int num, boolean expectedResult){
        System.out.println("arr: " + Arrays.toString(arr) + " num: " + num);
        boolean result4=Ex13.isSum(arr, num);
        printResult(result4, expectedResult);

    }

    public static void printResult(boolean result, boolean expectedResult){
        if (result == expectedResult)
            System.out.println(greenColor + "Passed" + resetColor + ", result is " + expectedResult);
        else
            System.out.println( redColor + "Failed,  " + resetColor + "expected: " + expectedResult +"   student's result: "+result);
    }
    public static void printResult(int result, int expectedResult){
        if (result == expectedResult)
            System.out.println(greenColor + "Passed" + resetColor + ", result is " + expectedResult);
        else
            System.out.println( redColor + "Failed,  " + resetColor + "expected: " + expectedResult +"   student's result: "+result);
    }

}
