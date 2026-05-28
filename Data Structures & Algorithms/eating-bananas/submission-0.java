class Solution {
    int calculateTotalHours(int[] piles, int perHourRate) { 
        int totalHours = 0;
        for (int pile: piles) {
            totalHours += Math.ceil((double)pile/perHourRate);
        }
        return totalHours;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().orElse(0);
        int lowPerHourRate = 1;
        int highPerHourRate = maxPile;
        System.out.println("start -> low: " + lowPerHourRate + ", high: " + highPerHourRate );


        int minPerHourRate = Integer.MAX_VALUE;

        while (lowPerHourRate <= highPerHourRate) {
            int midPerHourRate = lowPerHourRate + (highPerHourRate - lowPerHourRate)/2;
            int hoursNeeded = calculateTotalHours(piles, midPerHourRate);
            if (hoursNeeded <= h) {
                minPerHourRate = Math.min(minPerHourRate, midPerHourRate);
                highPerHourRate = midPerHourRate - 1;
            } else {
                lowPerHourRate = midPerHourRate + 1;
            }
            System.out.println("low: " + lowPerHourRate + ", mid: " + midPerHourRate + ", high: " + highPerHourRate + ", hoursNeeded: " + hoursNeeded);
        }
        return minPerHourRate;
    }
}
