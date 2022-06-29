package acwing.holiday202201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://www.acwing.com/problem/content/1936/
//二路归并算法
public class Problem1934 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        List<Integer> T=new ArrayList<>();
        List<Integer> D=new ArrayList<>();
        while (n>0){
            String line=sc.nextLine();
            if(line.startsWith("T")){
                T.add(Integer.parseInt(line.split(" ")[1]));
            }
            else {
                D.add(Integer.parseInt(line.split(" ")[1]));
            }
            n--;
        }
        D.add(1000);
        Collections.sort(T);
        Collections.sort(D);
        double v=1;//速度的倒数
        double t=0;
        double s=0;

        int i=0;
        int j=0;
        while (i<T.size()||j<D.size()){
            if(j==D.size()||(i<T.size()&&T.get(i)-t<(D.get(j)-s)*v)){
                s=s+(T.get(i)-t)/v;
                t=T.get(i);
                v++;
                i++;
            }
            else{
                t=t+(D.get(j)-s)*v;
                s=D.get(j);
                v++;
                j++;
            }
        }

        System.out.printf("%.0lf\n",t);
    }
}
