class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        while(left <= right){
            int mid = (left+right+1)/2;
            int index = letters[mid]-'a';
            int t = target - 'a';
            if(index>t) right = mid-1;
            else left = mid + 1;
        }
        return letters[left%letters.length];
    }
}