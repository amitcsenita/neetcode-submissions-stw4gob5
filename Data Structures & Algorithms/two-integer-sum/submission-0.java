class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> found = new HashMap<>();
        

        for (int index = 0; index < nums.length; index++) {
          int diff = target - nums[index] ;
           if (found.containsKey(diff)) {
             return new int[] {found.get(diff), index};
           } else {
              found.put(nums[index], index);
           }
        }

        return new int[] {-1, -1};
    }
}
