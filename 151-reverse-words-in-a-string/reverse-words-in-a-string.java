class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        
        // Split the string by spaces and push non-empty words onto the stack
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (str.length() > 0) {
                    st.push(str.toString());
                    str.setLength(0); // Reset the StringBuilder
                }
            } else {
                str.append(ch);
            }
        }
        
        // Push the last word if there is one
        if (str.length() > 0) {
            st.push(str.toString());
        }
        
        // Pop words from the stack to form the reversed string
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
            if (!st.isEmpty()) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
