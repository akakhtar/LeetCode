class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x, ans = 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            long mSq = (long)mid*mid;
            if(mSq == (long)x)
              return mid;
            else if(mSq > (long)x)
            high = mid-1;
            else
            {
                low = mid+1;
                ans = mid;
            }  
        }
        return ans;
    }
}