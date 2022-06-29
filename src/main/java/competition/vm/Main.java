package competition.vm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();



        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.offer(2);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);

        for(int i=1;i<n;i++){
            Integer cur= queue.poll();
            String a=String.valueOf(cur);
            queue.offer(Integer.parseInt(a+"2"));
            queue.offer(Integer.parseInt(a+"3"));
            queue.offer(Integer.parseInt(a+"5"));
            queue.offer(Integer.parseInt(a+"7"));

        }
        Integer cur= queue.poll();
        System.out.println(cur);
    }
}
