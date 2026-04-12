class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 1;
        int left = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        int maxCount = 1;

        for (int right = 0; right < s.length(); right++) {
            countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0)+1);
            maxCount = Math.max(maxCount, countMap.get(s.charAt(right)));
            int windowLength = right - left + 1 ;
            if (windowLength - maxCount <= k) {
                maxLength = Math.max(maxLength, windowLength);
            } else {
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                left++;
            }
        }

        return maxLength;
    }
}
