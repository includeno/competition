package competition.tencent;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        //筛选所有的数字 4个不同因子
        HashMap<Integer, List<Integer>> map=filter();
        while (T>0){
            int n=sc.nextInt();
            List<Integer> values=map.get(n);
            int min=Integer.MAX_VALUE;
            for(int i=0;i<values.size();i++){
                if(values.get(i)<min){
                    min=values.get(i);
                }
            }
            System.out.println(min);

            T--;
        }
    }


    public static int findPrimes(int n) {
        int count=1;
        int min=Integer.MAX_VALUE;
        List<Integer> yinzi=new ArrayList<>();
        yinzi.add(1);
        for(int i=2;i<=n/i;i++){
            if(n%i==0){
                count++;
                yinzi.add(i);
                if(n%(n/i)==0){
                    count++;
                    yinzi.add(n/i);
                }
            }
        }
        if(yinzi.size()<4){
            return 0;
        }
        Collections.sort(yinzi);
        for(int i=1;i<yinzi.size();i++){
            if(min>yinzi.get(i)-yinzi.get(i-1)){
                min=yinzi.get(i)-yinzi.get(i-1);
            }
        }

        return min;
    }

    public static HashMap<Integer, List<Integer>> filter(){
        HashMap<Integer, List<Integer>> ans=new HashMap<>();
        for(int i=4;i<10000000;i++){
            int min=findPrimes(i);
            if(min!=0){
                if(ans.get(min)==null){
                    List<Integer> d=new ArrayList<>();
                    d.add(i);
                    ans.put(min,d);
                }
                else{
                    List<Integer> d=ans.get(min);
                    d.add(i);
                    ans.put(min,d);
                }

            }
        }
        return ans;
    }
}
