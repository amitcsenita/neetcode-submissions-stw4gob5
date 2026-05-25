class Solution {
    record Car(int position, int speed) {}
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b.position(), a.position()));

        Deque<Double>stack = new ArrayDeque<>();

        for (int i = 0; i < n ; i++) {
            double timeToTarget = (double) (target - cars[i].position())/cars[i].speed();
            if (stack.isEmpty() || timeToTarget > stack.peek()) {
                stack.push(timeToTarget);
            }
        }

        return stack.size();
    }
}




































