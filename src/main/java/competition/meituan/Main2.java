package competition.meituan;

import java.util.Scanner;

public class Main2 {
    public static boolean ans=false;
    public static int target=0;
    public static int maxCount=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        while (T>0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            maxCount=m;
            int val=sc.nextInt();
            target=val;
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            dfs(nums,n,0,0,0);
            if(ans==true){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

            T--;
        }
    }

    //index位置上操作 count放置立方之杯的数量
    public static boolean dfs(int[] nums,int n,int index,int count,int sum){
        if(count>maxCount){
            return false;
        }
        if(index==n){
            if(sum==target){
                ans=true;
                return true;
            }
        }
        if(index+1<=n){
            return
            dfs(nums,n,index+1,count+1,sum+nums[index]*nums[index]*nums[index])
            ||dfs(nums,n,index+1,count,sum+nums[index]);
        }
        else{
            return false;
        }

    }
}
