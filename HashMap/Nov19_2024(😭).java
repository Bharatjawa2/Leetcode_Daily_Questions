class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long ans=0;
        long curr=0;
        int left=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            curr+=nums[i];

            if(i>=k-1){
                if(map.size()==k) ans=Math.max(ans,curr);
                curr-=nums[left];
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
        }
        return ans;
    }
}
