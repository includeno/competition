package competition.meituan;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] nums=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            sum=sum+nums[i];
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->{return b-a;});
        for(int i=0;i<n;i++){
            int temp=0;
            for(int j=i;j<n;j++){
                temp=temp+nums[j];
                queue.offer(temp);
            }
        }
        int first=queue.poll();
        int se=queue.poll();
        if(first>0){
            sum=sum+9*first;
        }
        if(se>0){
            sum=sum+9*se;
        }
        System.out.println(sum);


    }
}
