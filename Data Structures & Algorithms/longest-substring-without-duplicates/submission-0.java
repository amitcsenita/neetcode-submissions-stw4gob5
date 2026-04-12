class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int left = 0 , right = 1, maxLength = 1;
        HashSet<Character>seen = new HashSet<>();

        seen.add(s.charAt(left));

        while (right < s.length()) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
