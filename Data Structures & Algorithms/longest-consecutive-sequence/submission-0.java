class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num: nums) {
            numsSet.add(num);
        }
        int maxLength = 0;

        for (int num: numsSet) {
           if (!numsSet.contains(num-1)) {
             int curLength = 1;
             while (numsSet.contains(num+1)) {
                num++;
                curLength++;
             }
             maxLength = Math.max(maxLength, curLength);
           }
        }        
        return maxLength;
    }
}
