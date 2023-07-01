public class Q1{
  public static int  howManySorted(int n, int max){

    return howManySorted(n, max, 0, 1, "");
  }

  public static int howManySorted(int n, int max, int curIndex, int curNum, String expression){
    return 0;
  }

  public static void main(String[] args) {
    int total = howManySorted(2,3);
    System.out.println("Total is: " + total);
  }
}
