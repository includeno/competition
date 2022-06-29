package competition.meituan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            right = Math.max(right, nums[i]);
        }


        int[][] dec = new int[n][n];
        //求出每一对位置的差
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dec[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    for (int k = i; k <= j; k++) {
                        min = Math.min(nums[k], min);
                        max = Math.max(nums[k], max);
                    }
                    dec[i][j] = max - min;
                }
            }
        }
        int[][][] dp=new int[n][n][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][j][k]=Integer.MAX_VALUE/2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j=i;j<n;j++){
                for(int k=1;k<=m;k++){
                    dp[i][j][k]=Math.min(dp[i][j][k-1]+dec[i][j],dp[i][j][k]);
                    if(i>=1){
                        dp[i][j][k]=Math.min(dp[i][j][k],Math.min(dp[i][j-1][k-1]+dec[i][j],dp[i][j-1][k]));
                    }
                }
            }
        }

        for (int[][] t:dp){
            for (int[] p:t){
                System.out.println(Arrays.toString(p));
            }
        }

        System.out.println(dp[0][n-1][m]);

    }




//
//    //targetSum 每一组的最大值
//    public static boolean check(int[] nums,int[] dec,int lastindex,int index,int sum,int count,int targetSum,int maxCount){
//        int n=nums.length;
//        if(count>maxCount){
//            return false;
//        }
//        if(index==n){
//
//        }
//        if(sum>targetSum){
//            return false;
//        }
//
//        for(int i=index+1;i<n;i++){
//            if(check(nums,lastindex,index+1,sum+dec[lastindex][index],count+1)){
//
//            }
//        }
//
//    }
}
