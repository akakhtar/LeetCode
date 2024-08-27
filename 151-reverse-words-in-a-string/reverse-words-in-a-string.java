class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(str.length()>0){
                    st.push(str.toString());
                    str.setLength(0);
                }
            }
            else 
            str.append(s.charAt(i));
        }
        if(str.length()>0)
        st.push(str.toString());
        String result = "";
        while(!st.isEmpty()){
            result += st.pop();
            if(!st.isEmpty())
            result += " ";
        }
        return result;
    }
}