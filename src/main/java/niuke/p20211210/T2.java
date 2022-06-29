package niuke.p20211210;

import java.util.HashSet;
import java.util.Scanner;

public class T2 {
    public static int min=Integer.MAX_VALUE;
    public static HashSet<Integer> set=new HashSet<>();
    public static HashSet<Integer> sushu=new HashSet<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //找到所有的素数
        for(int i=2;i<=100000/i;i++){
            int count=0;
            for(int k=2;k<i;k++){
                if(i%k==0){
                    count++;
                }
            }
            if(count==0){
                sushu.add(i);
            }
        }

        String input=sc.next();
        dfs(input,0,new StringBuilder(input));
        if(min==Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(min);
        }
    }

    //全排列
    public static void dfs(String input,int index,StringBuilder builder){
        if(index==input.length()-1){
            if(builder.toString().startsWith("0")){
                return;
            }
            int value=Integer.parseInt(builder.toString());
            if(set.contains(value)){
                return;
            }
            else{
                set.add(value);
                if(sushu.contains(value)){
                    min=Math.min(min,value);
                }
            }
            return;
        }

        for(int i=0;i<input.length();i++){
            if(i!=index){
                char oldch=input.charAt(i);
                char newch=input.charAt(index);
                builder.setCharAt(i,newch);
                builder.setCharAt(index,oldch);

                dfs(input,index+1,builder);
                builder.setCharAt(index,newch);
                builder.setCharAt(i,oldch);
            }
        }
    }


}
