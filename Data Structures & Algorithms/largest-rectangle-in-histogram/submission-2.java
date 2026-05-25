class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer>stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
              while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int right = i;
                int height = heights[stack.poll()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                System.out.println("i: " + i + " | height: " + height + " | left: " + left + " | right: " + right + " | width: " + width + " | Current Area: " + (width * height));
                maxArea = Math.max(maxArea, width * height);
              }
               
                stack.push(i);
        }
        int right = heights.length;
        while (!stack.isEmpty()) {
            int height = heights[stack.poll()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = right - left - 1;
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
        
    }
}
