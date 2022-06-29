package competition.vm;

import java.util.Scanner;

public class Main3 {
    public static int ans=Integer.MAX_VALUE;

    public static int[][] directions=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        String t=sc.nextLine();
        int n=Integer.parseInt(t.split(" ")[0]);//行
        int m=Integer.parseInt(t.split(" ")[1]);//列

        char[][] nums=new char[n][m];
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            t=sc.nextLine();

            for(int j=0;j<t.length();j++){
                nums[i][j]=t.charAt(j);
            }
        }
        dfs(nums,0,0,-1,0,visited);
        if(ans==Integer.MAX_VALUE){
            System.out.println("Failure");
        }
        else {
            System.out.println(ans);
        }


    }

    //lastdir 上一次走的方向是什么
    public static void dfs(char[][] nums,int x,int y,int lastdir,int sum,int[][] visited){
        visited[x][y]=1;
        if(nums[x][y]=='#'){
            visited[x][y]=0;
            return;
        }
        if(nums[x][y]=='B'){
            ans=Math.min(ans,sum);
            visited[x][y]=0;
            return;
        }

        //通过时间
        if(nums[x][y]=='0'||nums[x][y]=='@'){
            sum=sum+1;
        }
        else if(nums[x][y]=='*'){
            sum=sum+3;
        }

        int temp=lastdir;
        //定向
        if(nums[x][y]=='@'){
            int newX=x+directions[(temp+2)%4][0];
            int newY=x+directions[(temp+2)%4][1];

            dfs(nums,newX,newY,(temp+2)%4,sum,visited);

        }
        else{
            for(int i=0;i<directions.length;i++){
                int newX=x+directions[i][0];
                int newY=y+directions[i][1];
                if(newX>=0&&newX<nums.length&&newY>=0&&newY<nums[0].length&&visited[newX][newY]==0){
                    dfs(nums,newX,newY,i,sum,visited);
                }

            }
        }
        visited[x][y]=0;

    }
}

//4 4
//S0*#
//#**#
//0@*#
//0#B#

//10