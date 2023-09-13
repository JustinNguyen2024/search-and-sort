package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{
    void merge(int arr[], int left, int mid, int right)
    {
        // Find sizes of two subarrays to be merged
        int lSize = mid - left + 1;
        int rSize = right - mid;

        // Create temp arrays
        int lArray[] = new int[lSize];
        int rArray[] = new int[rSize];

        // put values into temp arrays
        for (int i = 0; i < lSize; ++i)
            lArray[i] = arr[left + i];
        for (int j = 0; j < rSize; ++j)
            rArray[j] = arr[mid + 1 + j];

        // Initial indices of first and second subarrays
        int lPointer = 0, rPointer = 0;

        // merge and sort starting from bottom
        int k = left;
        while (lPointer < lSize && rPointer < rSize) {
            if (lArray[lPointer] <= rArray[rPointer]) {
                arr[k] = lArray[lPointer];
                lPointer++;
            }
            else {
                arr[k] = rArray[rPointer];
                rPointer++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (lPointer < lSize) {
            arr[k] = lArray[lPointer];
            lPointer++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (rPointer < rSize) {
            arr[k] = rArray[rPointer];
            rPointer++;
            k++;
        }
    }

    public void sortArr(int arr[], int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /**
     * Returns the sorted array
     */
    public static int[] sort(int arr[], int l, int r)
    {
        Merge mergeSort = new Merge();
        mergeSort.sortArr(arr, l, r);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    

        // Test the sort
        testSort(sort(arr, 0, arr.length - 1));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void testSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("FAIL at index "+i);
                System.out.println(Arrays.toString(arr));
                return;
            }
        }
        System.out.println("SUCCESS!");
    }

}