class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer>stack = new ArrayDeque<>();
        int[] output = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
           while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                output[stack.peek()] = i - stack.peek();
                stack.pop();
           }
           stack.push(i);     
        }
        return output;
        
    }
}
