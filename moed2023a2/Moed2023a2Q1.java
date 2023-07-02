public class Moed2023a2Q1 {
    public static int findPairs(int n){
        return findPairs(n,0,0,"");
    }

    public static int findPairs(int n, int left, int right, String expression){
        if(right == n && right==left){
            System.out.println(expression);
            return 1;
        }

        int count = 0;
        if(left <= n && (right<=left)) {
            count += findPairs(n, left + 1, right, expression + "(");
            count += findPairs(n, left, right + 1, expression + ")");
        }
        return count;


    }

    public static void main(String[] args) {
        int numOfPairs = findPairs(3);
        System.out.println("Total pairs are: " + numOfPairs);
    }
}
