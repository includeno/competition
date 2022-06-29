package leetcode.problem;

import util.Helper;

public class Leetcode59 {

    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];

        int count=1;
        int x=0;
        int y=0;
        for(int level=0;level<=(n+1)/2;level++){
            System.out.println("level: "+level+" count:"+count);
            if(res[level][level]==0){
                res[level][level]=count++;
                Helper.printArray2d(res,"level *2 "+res[level][level]);
            }

            x=level;
            //左到右
            for(int i=level;i<n-1-level;i++){
                if(res[x][i]==0){
                    res[x][i]=count++;
                }
                Helper.printArray2d(res,""+res[x][i]);
                System.out.println("x:"+x+" y:"+i);
            }

            y=n-1-level;
            //左到右
            for(int i=level;i<n-1-level;i++){
                if(res[i][y]==0){
                    res[i][y]=count++;
                }
                Helper.printArray2d(res,""+res[i][y]);
                System.out.println("x:"+i+" y:"+y);
            }

            x=n-1-level;
            //左到右
            for(int i=n-1-level;i>level;i--){
                if(res[x][i]==0){
                    res[x][i]=count++;
                }
                Helper.printArray2d(res,""+res[x][i]);
                System.out.println("x:"+x+" y:"+i);
            }

            y=level;
            //左到右
            for(int i=n-1-level;i>level;i--){
                if(res[i][y]==0){
                    res[i][y]=count++;
                }
                Helper.printArray2d(res,""+res[i][y]);
                System.out.println("x:"+i+" y:"+y);
            }

        }
        return res;
    }
}
