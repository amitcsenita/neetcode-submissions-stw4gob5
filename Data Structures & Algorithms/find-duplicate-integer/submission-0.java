class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.merge(num, 1, Integer::sum);
            if (countMap.get(num) > 1) return num;
        }

        return -1;
    }
}
