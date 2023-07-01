public class Q12018{
  public static int  howManySorted(int n, int max){

    return howManySorted(n, max, 0, 1, "");
  }

  public static int howManySorted(int n, int max, int curIndex, int curNum, String expression){

    if(curIndex == n){
      System.out.println(expression);
      return 1;
    }
    int count = 0;
    if(curNum <= max ){
      count += howManySorted(n, max, curIndex+1, curNum, expression + " " + curNum);
      count += howManySorted(n, max, curIndex, curNum+1, expression);
    }
    return count;
  }

  public static void main(String[] args) {
    int total = howManySorted(2,3);
    System.out.println("Total is: " + total);
  }
}
