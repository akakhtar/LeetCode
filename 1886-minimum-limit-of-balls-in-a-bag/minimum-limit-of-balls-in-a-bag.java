class Solution {
    public boolean check(int[] nums,int m,int maxOperations)
    {
        int n=nums.length;
        int op=0;

        for(int i=0;i<n;i++)
        {
            op+=(Math.ceil(nums[i]*(1.0)/m*(1.0))-1);
        }
        return (op<=maxOperations);
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int n=nums.length;
        int res=0;

        int l=1,h=0;

        for(int i=0;i<n;i++)
            h=Math.max(h,nums[i]);

        while(l<=h)
        {
            int m=l+(h-l)/2;

            if (check(nums,m,maxOperations))
            {
                res=m;
                h=m-1;
            }
            else l=m+1;
        }
    return res;
    }
    
}