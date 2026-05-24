class Solution {
    boolean isMatchingPair (char ch1, char ch2) {
        if (ch1 == '[' && ch2 == ']' ) return true;
        if (ch1 == '{' && ch2 == '}' ) return true;
        if (ch1 == '(' && ch2 == ')' ) return true;
        return false;

    }

      boolean isOpeningBrace (char ch) {
        if (ch == '[' ) return true;
        if (ch == '{')  return true;
        if (ch == '(')  return true;
        return false;

    }

    public boolean isValid(String s) {
        Stack<Character>parentheses = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (isOpeningBrace(ch)) {
                parentheses.push(ch);
            } else {
               if (parentheses.empty()) return false; 
               char top = parentheses.peek();
               if (isMatchingPair(top, ch)) parentheses.pop();
               else return false;
            }
        }

        return parentheses.empty();
    }
}
