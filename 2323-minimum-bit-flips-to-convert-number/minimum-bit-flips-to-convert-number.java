class Solution {
      void decimal_to_binary(int n,Stack<Integer> st){
        while(n>0){
            st.push(n%2);
            n /= 2;
        }
    }

    public int minBitFlips(int start, int goal) {
        Stack<Integer> startSt = new Stack<>();
        Stack<Integer> goalSt  = new Stack<>();
        decimal_to_binary(start,startSt);
        decimal_to_binary(goal,goalSt);
        int count = 0;
        int k = Math.abs(startSt.size()-goalSt.size());
        count += k;
        if(startSt.size()>goalSt.size())
        {
            while(k>0) {if(startSt.pop()==0) count--; k--;}
        }
        else{
            while(k>0) { if(goalSt.pop()==0) count--;k--;}
        }
        while(!startSt.isEmpty() && !goalSt.isEmpty()){
            if(startSt.pop() != goalSt.pop()){
                count++;
            }
        }
        return count;
    }
}