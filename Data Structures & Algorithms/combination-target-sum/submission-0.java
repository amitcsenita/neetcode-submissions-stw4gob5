class Solution {
    List<List<Integer>>allCombinations;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        allCombinations = new ArrayList<>();
        List<Integer>currentCombination = new ArrayList<>();

        int currentSum = 0;
        int currentIndex = 0;

        gatherCombinations(nums, currentIndex, target, currentSum, currentCombination);
        return allCombinations;
        
    }

    private void gatherCombinations(int[] nums, int currentIndex, int target, int currentSum,
                                    List<Integer>currentCombination) {
        if (currentSum == target) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }
        if (currentIndex == nums.length || currentSum > target ) return;                                

        currentCombination.add(nums[currentIndex]);
        currentSum += nums[currentIndex];

        gatherCombinations(nums, currentIndex, target, currentSum, currentCombination);
        
        currentCombination.removeLast();
        currentSum -= nums[currentIndex];
        gatherCombinations(nums, currentIndex + 1, target, currentSum, currentCombination);
        
                                       
    }
}
