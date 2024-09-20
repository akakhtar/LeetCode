class Solution {
    
    // Function to multiply two large numbers represented as strings
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        // Edge case: if one of the numbers is "0", return "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        // Create an array to store the result of the multiplication
        int[] result = new int[len1 + len2];
        
        // Reverse both numbers to make multiplication easier
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // Multiply each digit and add the result to the corresponding position in the array
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + result[p2];  // Add the current value of result[p2]
                
                // Update result array
                result[p2] = sum % 10;       // Store the remainder
                result[p1] += sum / 10;      // Carry goes to the next position
            }
        }
        
        // Convert the result array into a string
        StringBuilder str = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros
            if (!(str.length() == 0 && num == 0)) {
                str.append(num);
            }
        }
        
        return str.toString();
    }
}
