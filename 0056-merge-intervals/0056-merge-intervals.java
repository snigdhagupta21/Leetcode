class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]>merged=new ArrayList<>();
        merged.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] last=merged.get(merged.size()-1);
            int[] current=intervals[i];
            if(current[0]<=last[1]){
                last[1]=Math.max(last[1],current[1]);
            }
            else{
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}