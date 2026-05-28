class Solution {
    public int findMin(int[] nums) {
      int minElement = Integer.MAX_VALUE;
      
      int low = 0;
      int high = nums.length - 1; 

      while (low <= high) {
        int mid = low + (high - low)/2;
        if (nums[mid] <= nums[high]) {
          minElement = Math.min(minElement, nums[mid]);
          high = mid - 1;
        } else {
           low = mid + 1;
        }
      }
      return minElement;
    }
}
