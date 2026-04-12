class Solution {
    public boolean isAnagram(String s, String t) {
        if  (s.toCharArray().length != t.toCharArray().length) return false;
        Map<Character, Integer>charCount = new HashMap<>();

        for (Character c: s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }

        for (Character c: t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0)-1);
            if(charCount.get(c) < 0) return false;
        }
        return true;
    }
}
