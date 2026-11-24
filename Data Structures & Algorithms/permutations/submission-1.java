class Solution {
    List<List<Integer>> allPermutations;
    public List<List<Integer>> permute(int[] nums) {
      allPermutations = new ArrayList<>();
      getPermutations(nums, 0);
      return allPermutations;
    }

     public void getPermutations(int[] nums, int currentIndex) {
        if (currentIndex == nums.length) {
           List<Integer> currentList = new ArrayList<>();
            for (int num : nums) {
                currentList.add(num);
            }
            allPermutations.add(currentList);
            return;
        }

        for (int swapIndex = currentIndex ; swapIndex < nums.length; swapIndex++) {
            swap(nums, swapIndex, currentIndex);
            getPermutations(nums, currentIndex + 1);
            swap(nums, swapIndex, currentIndex);
        }
        }
        private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

      
    }
   
}
