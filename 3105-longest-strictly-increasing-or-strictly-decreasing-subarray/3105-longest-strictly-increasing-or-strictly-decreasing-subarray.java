class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1;
        int ok=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]) ans++;
            else ans=1;
            ok=Math.max(ok,ans);
        }
        ans=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) ans++;
            else ans=1;
            ok=Math.max(ok,ans);
        }
        return ok;
    }
}