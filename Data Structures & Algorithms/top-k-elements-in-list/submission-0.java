class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> freqMap = new HashMap<>();
       for (int num: nums) {
        freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
       }

       PriorityQueue<int[]>freqPriorityQueue = new PriorityQueue<>(
         (a, b) -> a[1] - b[1]
       );

       for (int key : freqMap.keySet()) {
        freqPriorityQueue.offer(new int[]{key, freqMap.get(key)});
        if (freqPriorityQueue.size() > k) {
            freqPriorityQueue.poll();
        }    
       }

       int[] result = new int[k];
       for (int i=0; i < k ; i++) {
          result[i] = freqPriorityQueue.poll()[0];
       }

       return result;
    }
}
