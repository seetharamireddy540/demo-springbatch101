package com.example.batchprocessing.ram;


public class ArrayApp {
    public static void main(String[] args) {
        int[] data = {1, 6, 3, 0, 5, 9};
        int subArrayLength = 3;
        int maxSubArraySum = fixMaxSubArraySum(data, subArrayLength);
        System.out.println("maxSubArraySum = " + maxSubArraySum);
    }

    private static int fixMaxSubArraySum(int[] data, int subArrayLength) {

        int startIndex = 0;
        int endIndex = subArrayLength - 1;
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
            currentSubArraySum = currentSubArraySum - data[i-1] + data[i + subArrayLength - 1];
            if (maxSubArraySum < currentSubArraySum) {
                startIndex = i;
                endIndex = i + startIndex - 1;
                maxSubArraySum = currentSubArraySum;
            }
//            maxSubArraySum = Math.max(maxSubArraySum, currentSubArraySum);
        }
        System.out.println("Sub Array StartIndex=" + startIndex + " EndIndex=" + endIndex);

        return maxSubArraySum;
    }
}
