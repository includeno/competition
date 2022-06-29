package competition.meituan;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        BufferedReader reader=new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        String config=reader.readLine();

        int n= Integer.parseInt(config.split(" ")[0]);
        int m= Integer.parseInt(config.split(" ")[1]);
        //int[] nums=new int[n];
        String data=reader.readLine();
        String[] d=data.split(" ");
        PriorityQueue<Long> queue=new PriorityQueue<>();
        for(int i=0;i<n;i++){

            queue.offer(Long.parseLong(d[i]));
        }

        int count=0;
        Long min=null;
        while (count<m){
            min=queue.poll();
            queue.offer(min+1);
            count++;
        }
        System.out.println(queue.peek());
    }
}
