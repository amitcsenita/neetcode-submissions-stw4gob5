
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int trappedWater = 0;

        while (left <right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft < maxRight) {
                trappedWater += maxLeft - height[left];
                left++;
            } else {
                 trappedWater += maxRight - height[right];
                right--;
            }
        }
        return trappedWater;
        
    }
}
