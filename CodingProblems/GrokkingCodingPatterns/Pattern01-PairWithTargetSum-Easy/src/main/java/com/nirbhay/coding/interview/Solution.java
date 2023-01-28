package com.nirbhay.coding.interview;

class Solution {

    /**
     * Time Complexity:
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given
     * array.
     *
     * Explanation : In the worst-case, the 'left' pointer could remain static at 0 index and the 'right' pointer needs
     * to be decremented until it reaches the 1 index (or vice-versa where 'right' remains static and 'left' is
     * incremented), thus covering the entire array length 'N'.
     *
     * Space Complexity:
     * The algorithm runs in constant space O(1).
     *
     * @param arr input array
     * @param targetSum target sum to be found
     * @return int[] array of 'left' and 'right' index where 'left' + 'right' = 'targetSum'
     */
    public static int[] twoPointerSearch(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right){
            int currentSum = arr[left] + arr[right];
            if (targetSum == currentSum)
                return new int[]{left, right};
            if(targetSum > currentSum)
                left++;
            else
                right--;
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = Solution.twoPointerSearch(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = Solution.twoPointerSearch(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
