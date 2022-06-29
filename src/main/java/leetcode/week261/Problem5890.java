package leetcode.week261;

public class Problem5890 {

    public int minimumMoves(String s) {
        int n=s.length();
        int[] sums=new int[n+1];
        int[] a=new int[n];
        for(int i=1;i<=n;i++){
            int temp=0;
            if(s.charAt(i-1)=='X'){
                temp=1;
            }
            a[i-1]=temp;
            sums[i]=sums[i-1]+temp;
        }
        int count=0;
        for(int i=2;i<=n;i++){
            if(a[i-2]==0&&a[i-1]==0||a[i-2]==0){
                continue;
            }
            count++;
        }
        return count;
    }
}
