package com.nirbhay.coding.interview;

public class Solution {

    /**
     * Time Complexity:
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * <br>
     * <br>
     * Space Complexity:
     * The algorithm runs in constant space O(1).
     * <br>
     * <br>
     * Algo - here we keep 2 pointers, 1st to iterate the array, the 2nd pointer points to the index ahead (next) of the last non-duplicate element (nextNonDuplicate).
     * As the array is sorted, the resultant array will preserve the relative order.
     * This method returns the length 'k' of the subarray with 0 duplicate elements. It does not matter what is left in the array after 'k - 1' index.
     */
    private static int removeDuplicates(int arr[]) {
        int nextNonDuplicate = 1; // starts at index 1
        for (int i = 0; i < arr.length; i++) {
            if(arr[nextNonDuplicate - 1] != arr[i]){ // compare the current element with the element to the left of nextNonDuplicate
                arr[nextNonDuplicate] = arr[i]; // save the current element to the right of the last non-duplicate element i.e. at the element pointed by nextNonDuplicate.
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate; // this will be the length of the portion of array with no duplicates.
    }

    public static void main(String[] args) {
        int result = Solution.removeDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9});
        System.out.println(result);
    }


}
