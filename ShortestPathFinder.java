public class ShortestPathFinder {

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

    public static void main(String[] args) {
       // int[] array1 = {5, 4, 5, 8, 12, 9, 9, 3};
       // int[] array2 = {7, 3, 3, 12, 10, 2, 10, 7};
        int[] array1 = {5, 4, 5};
        int[] array2 = {7, 3, 3};

        int shortestPathH = shortestRoad(array1, array2);
        System.out.println("Shortest Path: " + shortestPathH);
    }
}
