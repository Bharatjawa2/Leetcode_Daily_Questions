class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> map=new HashMap<>();

        for(int[] i:matrix){
            int x=i[0];
            String s="";
            for(int j:i){
                if(j==x) s+="1";
                else s+="0";
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }

        int ans=0;
        for(int i:map.values()){
            ans=Math.max(ans,i);
        }
        return ans;
    }
}
