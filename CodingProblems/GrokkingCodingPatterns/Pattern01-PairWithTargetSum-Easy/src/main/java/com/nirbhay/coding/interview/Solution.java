package com.nirbhay.coding.interview;

class Solution {
    public static int[] search(int[] arr, int targetSum) {
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
        int[] result = Solution.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = Solution.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
