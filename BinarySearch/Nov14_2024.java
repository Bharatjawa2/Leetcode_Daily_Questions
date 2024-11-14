class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start=1;  // to avoid divide by ero error
        int end=Integer.MIN_VALUE;
        for(int i:quantities){
            end=Math.max(end,i);
        }

        int res=-1;

        while(start<=end){
            int mid=(start)+(end-start)/2;
            if(solve(quantities,mid,n)){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }

    boolean solve(int[] arr,int mid,int n){
        int c=0;
        for(int i:arr){
            c+=i/mid;
            if(i%mid!=0) c+=1;
            if(c>n) return false;
        }
        return true;
    }
}
