import java.util.Arrays;

public class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int n = passengers.length;
        int m = buses.length;
        
        int latestTime = 0;
        int passengerIndex = 0;
        
        for (int i = 0; i < m; i++) {
            int currentCapacity = 0;
            
           
            while (currentCapacity < capacity && passengerIndex < n && passengers[passengerIndex] <= buses[i]) {
                
                if (passengerIndex == 0 || passengers[passengerIndex - 1] + 1 < passengers[passengerIndex]) {
                    latestTime = Math.max(latestTime, passengers[passengerIndex] - 1);
                }
                
                currentCapacity++;
                passengerIndex++;
            }
           
            if (currentCapacity < capacity) {
                latestTime = Math.max(latestTime, buses[i]);
            }
        }
        
        while (Arrays.binarySearch(passengers, latestTime) >= 0) {
            latestTime--;
        }
        
        return latestTime;
    }
}
