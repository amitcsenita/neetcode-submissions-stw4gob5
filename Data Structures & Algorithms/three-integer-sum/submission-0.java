class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>triplets = new ArrayList<>();
        int numsLength = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < numsLength -2 ; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            int j = i+1, k = numsLength-1;
            while(j < k) {
                    if (nums[j] + nums[k] == target) {
                        triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j-1]) {
                            j++;
                        }
                        while (j < k  && nums[k] == nums[k+1]) {
                            k--;
                        }
                    } else if (nums[j] + nums[k] < target) {
                        j++;
                    } else {
                        k--;
                    }
            }
        }        
        return triplets;
    }
}
