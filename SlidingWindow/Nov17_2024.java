class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();

        long[] arr=new long[n];
        int ans=Integer.MAX_VALUE;
        int j=0;

        while(j<n){
            if(j==0) arr[j]=nums[j];
            else arr[j]=arr[j-1]+nums[j];

            if(arr[j]>=k) ans=Math.min(ans,j+1);

            while(!dq.isEmpty() && arr[j]-arr[dq.peekFirst()]>=k){
                ans=Math.min(ans,j-dq.peekFirst());
                dq.removeFirst();
            }

            while(!dq.isEmpty() && arr[j]<=arr[dq.peekLast()]){
                dq.removeLast();
            }


            dq.add(j);
            j++;
        }
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
}
