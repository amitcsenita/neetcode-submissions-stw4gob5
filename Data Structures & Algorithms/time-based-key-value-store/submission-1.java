class TimeMap {
    private record TimeBasedValue(int timestamp, String value) {}
    Map<String, List<TimeBasedValue>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       if (!store.containsKey(key)) {
        store.put(key, new ArrayList<>());
       }
       store.get(key).add(new TimeBasedValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
         if (!store.containsKey(key)) {
           return "";
         }
         int low = 0;
         int high = store.get(key).size() - 1;
         
         int latestIndex = -1;

         while (low <= high) {
            int mid = low + (high - low)/2;
            int midTimestamp = store.get(key).get(mid).timestamp();
            if (midTimestamp <= timestamp) {
              latestIndex = Math.max(latestIndex, mid);
              low = mid + 1;
            } else {
                high = mid-1;
            }
         }
         return latestIndex != -1 ? store.get(key).get(latestIndex).value() : "";
        
    }
}
