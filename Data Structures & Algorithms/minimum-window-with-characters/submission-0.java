
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> sWindowFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>(); // Fixed typo: Charcter -> Character, tfreq -> tFreq

        for (int i = 0; i < t.length() ; i++) {
            char ch = t.charAt(i);
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        int matches = 0;
        int totalUniqueChars = tFreq.size();
        int minWindowLeft = -1, minWindowRight = -1;
        int minWindowLength = Integer.MAX_VALUE;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            sWindowFreq.put(rc, sWindowFreq.getOrDefault(rc, 0) + 1);
            
            // Fixed syntax: .equals. -> .equals()
            if (tFreq.containsKey(rc) && tFreq.get(rc).equals(sWindowFreq.get(rc))) {
                matches++;
            }
           
            while (matches == totalUniqueChars) {
                int windowLength = right - left + 1;
                if (windowLength < minWindowLength) {
                    minWindowLength = windowLength;
                    minWindowLeft = left;
                    minWindowRight = right;
                } // Added missing closing brace for the if statement

                char lc = s.charAt(left);
                // Need to decrement matches before removing from sWindowFreq to maintain logic
                if (tFreq.containsKey(lc) && sWindowFreq.get(lc).equals(tFreq.get(lc))) {
                    matches--; 
                }
                sWindowFreq.put(lc, sWindowFreq.get(lc) - 1);
                left++;
            }
        }

        // Fixed syntax: minWindowLeft is an int, use != -1 instead of .equals()
        if (minWindowLeft != -1) {
            return s.substring(minWindowLeft, minWindowRight + 1);
        } else {
            return "";
        }
    }
}