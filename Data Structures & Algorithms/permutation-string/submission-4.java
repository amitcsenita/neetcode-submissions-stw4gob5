class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2WindowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == s2WindowFreq[i]) matches++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            s2WindowFreq[s2.charAt(right) - 'a']++;
            if (s2WindowFreq[s2.charAt(right) - 'a'] == s1Freq[s2.charAt(right) - 'a']) matches++;
            if (s2WindowFreq[s2.charAt(right) - 'a'] - 1 == s1Freq[s2.charAt(right) - 'a']) matches--;

            if (right - left + 1 > s1.length()) {
                s2WindowFreq[s2.charAt(left) - 'a']--; 
                if (s2WindowFreq[s2.charAt(left) - 'a'] == s1Freq[s2.charAt(left) - 'a']) matches++;
                if (s2WindowFreq[s2.charAt(left) - 'a'] + 1  == s1Freq[s2.charAt(left) - 'a']) matches--;
                left++;
            }
            if (matches == 26) return true;

        }

        return false;
    }
}
