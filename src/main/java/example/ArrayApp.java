package example;

public class ArrayApp {
    public static void main(String[] args) {
        int[] data = {1, 6, 3, 0, 5, 1};
        int subArrayLength = 13;
        int maxSubArraySum = findMinSubArrayLength(data, subArrayLength);
        System.out.printf("maxSubArraySum = " + maxSubArraySum);
    }

    private static int findMinSubArrayLength(int[] data, int subArrayLength) {

        if (data == null || subArrayLength > data.length) {
            return -1;
        }
        int maxSubArraySum = 0;
        int currentSubArraySum = 0;
        for (int i = 0; i < subArrayLength; i++) {
            currentSubArraySum = currentSubArraySum + data[i];
        }
        maxSubArraySum = currentSubArraySum;
        for (int i = 1; i < data.length - subArrayLength + 1; i++) {
            currentSubArraySum = currentSubArraySum - data[i - 1];
            currentSubArraySum = currentSubArraySum + data[i + subArrayLength - 1];
            maxSubArraySum = Math.max(maxSubArraySum, currentSubArraySum);
        }

        return maxSubArraySum;
    }
}
