class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        int[] ans = new int[nums.length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]) {
                dq.pollLast();
            }
            dq.offerLast(right);
            if (dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }
            if (right >= k-1) {
                ans[right - k + 1] = nums[dq.peekFirst()];
            }
        } 
        return ans;
    }
}
