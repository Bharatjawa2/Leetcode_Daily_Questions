class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int a=0,b=0;

        if(n%2!=0){
            for(int i:nums2){
                b^=i;
            }
        }

        if(m%2!=0){
            for(int i:nums1){
                a^=i;
            }
        }

        return a^b;
    }
}