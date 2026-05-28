class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
           return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = nums1.length;
        int totalLength = nums1.length + nums2.length;
        int leftHalfSize = (totalLength + 1)/2;
        int median = 0;

        while (low <= high) {
           int nums1ElementsInLeftHalf = low + (high - low)/2;
           int nums2ElementsInLeftHalf = leftHalfSize - nums1ElementsInLeftHalf;

           int maxLeft1 = nums1ElementsInLeftHalf != 0 ? nums1[nums1ElementsInLeftHalf - 1] : Integer.MIN_VALUE;
           int maxLeft2 = nums2ElementsInLeftHalf != 0 ? nums2[nums2ElementsInLeftHalf - 1] : Integer.MIN_VALUE;

           int minRight1 = nums1ElementsInLeftHalf != nums1.length ? nums1[nums1ElementsInLeftHalf] : Integer.MAX_VALUE;
           int minRight2 = nums2ElementsInLeftHalf != nums2.length ? nums2[nums2ElementsInLeftHalf] : Integer.MAX_VALUE;

           if (maxLeft1 > minRight2) {
              high = nums1ElementsInLeftHalf - 1;
           } else if ( maxLeft2 > minRight1) {
              low = nums1ElementsInLeftHalf + 1;
           } else {
              if (totalLength %2 == 0) {
                return (double)(Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2.0;
              } else {
                return Math.max(maxLeft1, maxLeft2);
              }
           }

        }
        return -1;        
    }
}
