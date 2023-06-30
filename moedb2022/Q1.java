public class Q1 {
    public static int calc(int num, int result, int maxOp) {
        if (maxOp == 0) {
            if (num == result) {
                System.out.println(num);
                return 1;
            }
            return 0;
        }

        int count = 0;

        // Add
        count += calc(num, result - num, maxOp - 1);
        System.out.println(num + " + " + calc(num, result - num, maxOp - 1));

        // Sub
        count += calc(num, result + num, maxOp - 1);
        System.out.println(num + " - " + calc(num, result + num, maxOp - 1));

        // *
        if (num != 0 && result % num == 0) {
            count += calc(num, result / num, maxOp - 1);
            System.out.println(num + " * " + calc(num, result / num, maxOp - 1));
        }

        // /
        if (result != 0 && num % result == 0) {
            count += calc(num, result * num, maxOp - 1);
            System.out.println(num + " / " + calc(num, result * num, maxOp - 1));
        }

        return count;  // מספר הב

    }
    public static void main(String[] args) {
        int totalOptions = calc(3, 36, 5);
        System.out.println(totalOptions);
    }

}