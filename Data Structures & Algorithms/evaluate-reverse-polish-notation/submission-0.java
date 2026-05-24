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
        Deque<String> stack = new ArrayDeque();
        Set<String> operands = Set.of("+", "-", "*", "/");


        for (int i = 0; i < tokens.length; i++) {
           String token = tokens[i];
           if (operands.contains(token)) {
                String lastNum = stack.poll();
                String secondLastNum = stack.poll();
                int result = evaluate(Integer.parseInt(secondLastNum), Integer.parseInt(lastNum), token); 
                stack.push(String.valueOf(result));
           } else {
                stack.push(token);
           }
        }
        return Integer.parseInt(stack.peek());
    }
}
