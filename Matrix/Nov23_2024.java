class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        char[][] ans=new char[n][m];

        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(box[i][j]=='#') solve(box,i,j);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[j][m-i-1]=box[i][j];
            }
        }
        return ans;
    }

    void solve(char[][] box,int row,int col){
        int x=col;
        int n=box[0].length;
        while(x<n-1 && box[row][x+1]=='.') x++;
        if(x!=col){
            box[row][col]='.';
            box[row][x]='#';
        }
    }
}
