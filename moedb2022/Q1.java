public class Q1 {
    public static int calc(int num, int result, int maxOp) {
        return calc(num, num, result, maxOp, String.valueOf(num));
    }
    public static int calc(int num, int cur_result, int result, int maxOp, String expression) {
        if (maxOp >= 0 && cur_result == result) {

                System.out.println(expression + " = " + result);
                return 1;

        }

        int count = 0;
        if (maxOp > 0) {
            count += calc(num, cur_result + num, result, maxOp - 1, expression + " + " + num);
            count += calc(num, cur_result - num, result, maxOp - 1, expression + " - " + num);
            count += calc(num, cur_result * num, result, maxOp - 1, expression + " * " + num);

            if (num != 0 ) {
                count += calc(num, cur_result / num, result, maxOp - 1, expression + " / " + num);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int num = 5;
        int result = 6;
        int maxOp = 4;
        int totalCount = calc(num, result, maxOp);
        System.out.println("Total valid expressions: " + totalCount);
    }

}