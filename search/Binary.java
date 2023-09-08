package search;

/**
 * Write a description of class Binary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Binary
{

    /**
     * Returns the index of the target value, or -1 if not found
     */
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        boolean targetFound = false;
        while (!targetFound) {

            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                targetFound = true;
                return mid;     
            } else if (target < arr[mid]) {
                // target is in lower half
                high = mid;
                mid = (low + high) / 2;
            } else if (target > arr[mid]) {
                // target is in upper half
                low = mid;
                mid = (low + high) / 2;
            }

            if (low == high) {
                return -1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};

        // Remember that a binary search requires a sorted array!
        // You can use one of your sorting methods here.
        int temporary;
        for (int index = 1; index < arr.length; index++) {

            int sub = index;
            while (arr[sub] < arr[sub - 1] && sub > 0) {
                // put lesser into temporary
                temporary = arr[sub];
                // put larger where smaller used to be
                arr[sub] = arr[sub - 1];
                // bring smaller down
                arr[sub - 1] = temporary;
                // decrement
                sub--;
                // check
                if (sub == 0) {
                    break;
                }
            }

        }

        ////////////////////////////////////////////////////////////
        // Do not change anything below this line!!
        ////////////////////////////////////////////////////////////
        boolean isSorted = true;
        for (int i=0; i<arr.length-1 && isSorted; i++) {
            if (arr[i] > arr[i+1]) {
                isSorted = false;
            }
        }
        printResult("Is sorted?", isSorted);
        printResult(82, search(arr, 82) == 44); // Find index in unsorted or sorted array
        printResult(49, search(arr, 49) == 24);
        printResult(-4, search(arr, -4) == -1);
    }

    public static void printResult(int target, boolean result) {
        System.out.println("Search for "+target+": "+((result) ? "CORRECT" : "INCORRECT"));
    }

    public static void printResult(String target, boolean result) {
        System.out.println(target+": "+((result) ? "CORRECT" : "INCORRECT"));
    }

}
