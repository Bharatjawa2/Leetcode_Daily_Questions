class Pair{
    int pass;
    int total;
    Pair(int pass,int total){
        this.pass=pass;
        this.total=total;
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            double x=((double)(a.pass+1)/(a.total+1))-((double) a.pass/a.total);
            double y=((double)(b.pass+1)/(b.total+1))-((double)b.pass/b.total);
            return Double.compare(y,x);   // difference between (x,y)-MinHeap and (y,x)-MaxHeap
        });
        for(int[] row:classes){
            pq.add(new Pair(row[0],row[1]));
        }
        while(extraStudents>0){
            Pair curr=pq.poll();
            curr.pass++;
            curr.total++;
            pq.add(curr);
            extraStudents--;
        }
        double ans=0.0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            ans+=(double) curr.pass/curr.total;
        }
        return ans/n;
    }
}
