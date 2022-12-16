package com.example.batchprocessing.ram.sorting;

public class MergeSoftApp {

    public static void main(String[] args) {

        int data[] = {2, 3, 4, 1, 5};

        sort(data);
    }

    public static void sort(int[] data) {

        int startIndex = 0;
        int endIndex = data.length - 1;
        mergeSoft(data, startIndex, endIndex);
    }

    private static void mergeSoft(int[] data, int startIndex, int endIndex) {

        while (startIndex <= endIndex) {
            int middle = (startIndex + endIndex) / 2;
            mergeSoft(data, startIndex, middle);
            mergeSoft(data, middle + 1, endIndex);

        }
    }
}
