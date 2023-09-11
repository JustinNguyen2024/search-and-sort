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

    /**
     * Returns the sorted array
     */
    public static int[] sort(int[] arr, int lArray, int rArray) {
        if (lArray <= rArray) {
            int middle = (lArray + rArray) /2;

            // part 1: split apart left and right arrays
            sort(arr, lArray, middle);
            sort(arr, middle, rArray);
            merge(arr, lArray, middle, rArray);
            //////////////////
        }
        return arr;
    }

    private static void merge(int[] arr, int lArray, int middle, int rArray) {
        int length = arr.length;

        // create 2 new sub arrays
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        // put elements in left and right arrays
        int l = 0;
        int r = 0;

        for (; l < length; l++) {
            if (l < middle) {
                leftArray[l] = arr[l];
            } else {
                rightArray[r] = arr[l];
                r++;
            }
        }

        //part 2: put back together
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int i = 0, l2 = 0, r2 = 0; // indices

        // merge smaller # first
        while (l2 < leftSize && r2 < rightSize) {
            if(leftArray[l2] < rightArray[r2]) {
                arr[i] = leftArray[l2];
                i++;
                l2++;
            } else {
                arr[i] = rightArray[r2];
                i++;
                r2++;
            }
        }

        // merge last element up if only one remains
        while(l2 < leftSize) {
            arr[i] = leftArray[l2];
            l++;
            l2++;
        }
        while(r2 < rightSize) {
            arr[i] = rightArray[r2];
            l++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    

        // Test the sort
        testSort(sort(arr, 0, arr.length - 1));
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
