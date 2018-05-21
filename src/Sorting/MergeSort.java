package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Check null array
        if (array == null || array.length <=1){
            return array;
        }

        //Create a helper array to ensure no more than O(n) space is used.
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;

        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left; 
        int rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left] = helper[leftIndex];
                left++;
                leftIndex++;
            } else {
                array[left++] = helper[rightIndex++];
            }
        }

        //If we still have some elements on left side, copy them back to helper array
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();

        int[] array = new int[] {7, 8, 9, 1, 2, 3};
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
