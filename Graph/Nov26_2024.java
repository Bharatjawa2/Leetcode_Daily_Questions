class Solution {
    public int findChampion(int n, int[][] edges) {
        int x=edges.length;
        int[] ans=new int[n];
        for(int i=0;i<x;i++){
            ans[edges[i][1]]++;
        }
        int res=-1;
        int count=0;

        for(int i=0;i<n;i++){
            if(ans[i]==0){
                res=i;
                count++;
            }
        }

        if(count==1) return res;
        return -1;
    }
}
