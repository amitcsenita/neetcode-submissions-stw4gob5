class Solution {
    List<List<Integer>> allPermutations;
    public List<List<Integer>> permute(int[] nums) {
      allPermutations = new ArrayList<>();
      getPermutations(nums, 0);
      return allPermutations;
    }

     public void getPermutations(int[] nums, int currentIndex) {
        if (currentIndex == nums.length) {
            List<Integer> completedPermutation = new ArrayList<>();
            for (int number: nums) {
                completedPermutation.add(number);
            }
            allPermutations.add(completedPermutation);
            return;
        }

        for (int swapIndex = currentIndex ; swapIndex < nums.length; swapIndex++) {
             swap(nums, swapIndex, currentIndex);
             getPermutations(nums, currentIndex + 1);
              swap(nums, swapIndex, currentIndex);
        }
      
    }

     private void swap(int[] nums, int firstIndex, int secondIndex) {
        int savedValue = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = savedValue;
    }
}
