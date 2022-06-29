package leetcode.week262;

public class Problem2033 {

    public int minOperations(int[][] grid, int x) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n=grid.length;
        int m= grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int temp=grid[i][j];
                max=Math.max(max,temp);
                min=Math.min(min,temp);
            }
        }
        int ans=Integer.MAX_VALUE;
        int ansValue=-1;
        int left=min;
        int right=max;
        while (left!=right){
            int[] temp=check(grid,x,left);
            if(temp[0]>=0&&ans>temp[0]){
                ans=Math.min(ans,temp[0]);
                ansValue=temp[1];
            }
            left++;
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

    //-1 失败
    public int[] check(int[][] grid, int x,int target){
        int count=0;
        int n=grid.length;
        int m= grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int temp=grid[i][j];
                if((temp-target)%x!=0){
                    return new int[]{-1,0};
                }
                count+=Math.abs(temp-target)/x;
            }
        }
        return new int[]{count,target};
    }
}
