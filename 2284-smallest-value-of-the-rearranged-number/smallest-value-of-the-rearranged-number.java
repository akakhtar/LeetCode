import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long smallestNumber(long num) {
        ArrayList<Integer> arr = new ArrayList<>();
        int flag = 0;

        // If number is negative, mark flag and work with positive equivalent
        if (num < 0) {
            num = -num;
            flag = 1;
        }

        // Extract digits and add them to the list
        if (num == 0) {
            arr.add(0); // Handle the case where the number is 0
        }
        
        while (num > 0) {
            arr.add((int)(num % 10));
            num /= 10;
        }

        // If the number is positive, sort in ascending order
        if (flag == 0) {
            Collections.sort(arr);

            // If the smallest number is 0, swap with the first non-zero digit
            if (arr.get(0) == 0) {
                for (int i = 1; i < arr.size(); i++) {
                    if (arr.get(i) != 0) {
                        Collections.swap(arr, 0, i);
                        break;
                    }
                }
            }
        } 
        // If the number is negative, sort in descending order
        else {
            Collections.sort(arr, Collections.reverseOrder());
        }

        // Convert the sorted digits back into a number
        StringBuilder numberAsString = new StringBuilder();
        for (Integer digit : arr) {
            numberAsString.append(digit);
        }

        long result = Long.parseLong(numberAsString.toString());

        // Return the result as negative if the original number was negative
        if (flag == 1) {
            return -result;
        }

        return result;
    }
}
