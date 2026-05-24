class Solution {
    int evaluate(int num1, int num2, String token) {
        if (token.equals("+")) {
                return num1 + num2;
        }
         if (token.equals("-")) {
                return num1 - num2;
        }
         if (token.equals("*")) {
                return num1 * num2;
        }
         if (token.equals("/")) {
                return num1 / num2;
        }
        return 0;
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque();
        Set<String> operands = Set.of("+", "-", "*", "/");


        for (int i = 0; i < tokens.length; i++) {
           String token = tokens[i];
           if (operands.contains(token)) {
                int lastNum = stack.poll();
                int secondLastNum = stack.poll();
                int result = evaluate(secondLastNum, lastNum, token); 
                stack.push(result);
           } else {
                stack.push(Integer.parseInt(token));
           }
        }
        return stack.peek();
    }
}
