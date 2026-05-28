class MinStack {
    private record IntPair(int element, int minSoFar) {}
    private Deque<IntPair> stack;
    

    public MinStack() {
       stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int minSoFar = val;
        if (!stack.isEmpty()) {
          minSoFar = Math.min(val, stack.peek().minSoFar());
        }
        IntPair pair = new IntPair(val, minSoFar);
        stack.push(pair);
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
          stack.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
           return stack.peek().element();
        } else {
            return -1;
        }
    }
    
    public int getMin() {
         if (!stack.isEmpty()) {
           return stack.peek().minSoFar();
        } else {
            return -1;
        }
    }
}
