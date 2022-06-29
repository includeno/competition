package leetcode.problem;

//https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
public class Leetcode2269 {

    public static void main(String[] args) {
        int ans=divisorSubstrings(240,2);
        System.out.println(ans);
    }

    public static int divisorSubstrings(int num, int k) {
        int res=0;
        String str=String.valueOf(num);
        int n=str.length();
        for(int i=0;i+k<=n;i++){
            int v=Integer.parseInt(str.substring(i,i+k));
            if(v!=0&&num%v==0){
                res++;
            }
        }
        return res;
    }

}
