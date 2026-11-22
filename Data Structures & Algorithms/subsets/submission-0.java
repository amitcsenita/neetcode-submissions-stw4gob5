class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        gatherSubsets(nums, 0, currentSubset, allSubsets);
        return allSubsets;
    }

    void gatherSubsets(int [] nums, int currentIndex, 
                       List<Integer> currentSubset,
                       List<List<Integer>> allSubsets
                       ) {
        if (currentIndex == nums.length) {
          allSubsets.add(new ArrayList<>(currentSubset));
          return;  
        }
        currentSubset.add(nums[currentIndex]);
        gatherSubsets(nums, currentIndex+1, currentSubset, allSubsets);
        currentSubset.removeLast();
        gatherSubsets(nums, currentIndex+1, currentSubset, allSubsets);               
    }
}
