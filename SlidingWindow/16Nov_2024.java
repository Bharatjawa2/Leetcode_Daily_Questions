class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int [] ans=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            ans[i]=solve(nums,i,k-1+i);
        }
        return ans;
    }

    int solve(int []nums,int start,int end){
        while(start<end){
            if(nums[start+1]-nums[start]!=1 || nums[start]>nums[start+1]) return -1;
            start++;
        }
        return nums[end];
    }
}
