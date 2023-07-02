public class Q22023a {

    public static int findPeak(int[] arr){
        int i=0, j, k=arr.length-1;
        if(arr[0] >= arr[1])
            return arr[0];
        if(arr[k] >= arr[k-1])
            return arr[k];

        do{
            j = (i+k) / 2;
            if(isPeak(arr, j))
                return arr[j];
            if(arr[j+1] > arr[j]){
                i=j;
                if(isPeak(arr, i))
                    return arr[i];
            } else if (arr[j-1] > arr[j]){
                k = j;
                if(isPeak(arr, k))
                    return arr[k];
            }
        } while (k-i > 1);
        return -1;
    }

    public static boolean isPeak(int[] arr, int n){
        return arr[n] >= arr[n-1] && arr[n] >= arr[n+1];
    }

    public static void main(String[] args) {
        int[] arr = {10,20,15,2,1,90,67};
        int peak = findPeak(arr);
        System.out.println("The peak is: " + peak);
    }

}
