package com.nirbhay.coding.interview;

import java.util.HashMap;

class Solution {

    /**
     * Time Complexity:
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * <br>
     * <br>
     * Explanation : In the worst-case, the 'left' pointer could remain static at 0 index and the 'right' pointer needs to be decremented until it
     * reaches the 1 index (or vice-versa where 'right' remains static and 'left' is incremented), thus covering the entire array length 'N'.
     * <br>
     * <br>
     * Space Complexity:
     * The algorithm runs in constant space O(1).
     *
     * @param arr input array
     * @param targetSum target sum to be found
     * @return int[] array of 'left' and 'right' index where 'left' + 'right' = 'targetSum'
     */
    public static int[] twoSumUsing2Pointers(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right){
            int currentSum = arr[left] + arr[right];
            if (targetSum == currentSum)
                return new int[]{left, right}; // found the pair
            if(targetSum > currentSum)
                left++; // we need a pair with bigger sum
            else
                right--; // we need a pair with smaller sum
        }
        return new int[] { -1, -1 };
    }

    /**
     * Here the time complexity is O(N logN) because it uses two nested loops. The outer loop iterates through the array of integers, and for each
     * element, it performs a binary search to find the complement of the current element that would sum up to the target.
     * <br>
     * <br>
     * The outer loop has a time complexity of O(N), as it iterates through the entire array of N elements. The inner loop, which performs the binary
     * search, has a time complexity of O(log N), as it repeatedly splits the search space in half, reducing the number of elements that need to be
     * searched by a factor of 2 with each iteration.
     */
    public static int[] twoSumUsingBinarySearch(int[] nums, int target) {
        // iterate through the original array
        for (int i = 0; i < nums.length; i++) {
            // calculate the complement of the current element
            int complement = target - nums[i];
            // find the complement in the original array using a custom binary search implementation. We can also call the inbuilt Arrays.binarySearch() also.
            int index = binarySearch(nums, complement);
            // check if the complement was found, and it's not the same element
            if (index >= 0 && index < nums.length && index != i) {
                // return the indices of the two elements that add up to the target
                return new int[]{i, index};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Here, left -> first ele in the curr search range, right -> last ele in curr search range. Then (right - left) is done to get the total elements in the current search range. Then / by 2 to find middle index of this range. Then left is added to this result to get the actual mid-point.
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    /**
     * Time Complexity:
     * <br>
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * <br>
     * <br>
     * Space Complexity:
     * <br>
     * The space complexity will also be O(N), as, in the worst case, we will be pushing ‘N’ numbers in the HashTable.
     */
    private static int[] twoSumUsingHashMap(int[] arr, int target) {
        HashMap<Integer, Integer> nums = new HashMap(); // to store numbers (arr elements) as key and indices as value
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (nums.containsKey(complement))
                return new int[] {nums.get(complement), i}; // return the arr with {index of complement of element at index i, index i}
            else
                nums.put(arr[i], i); // put the number as key and index as value in the map
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        // Solution using 2 pointer approach - Time complexity is O(N)
        int[] result = Solution.twoSumUsing2Pointers(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = Solution.twoSumUsing2Pointers(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        // Solution using Binary Search - Time complexity is O(N logN)
        result = Solution.twoSumUsingBinarySearch(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = Solution.twoSumUsingBinarySearch(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = Solution.twoSumUsingHashMap(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = Solution.twoSumUsingHashMap(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
