package leetcode.week262;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Problem2034 {

    public static void main(String[] args) {
        StockPrice use=new StockPrice();
        use.update(1,10);
        System.out.println(use.current());
        System.out.println(use.maximum());
        System.out.println(use.minimum());
    }
}

class StockPrice {

    public HashMap<Integer,Integer> map=new HashMap<>();//key time value price
    public PriorityQueue<Integer> maxQueue=new PriorityQueue<>((a,b)->{
        int i = -map.get(a) + map.get(b);
        return i;
    });
    public PriorityQueue<Integer> minQueue=new PriorityQueue<>((a,b)->{
        int i = map.get(a) - map.get(b);
        return i;
    });
    public PriorityQueue<Integer> latestQueue=new PriorityQueue<>((a,b)->{
        int i = b-a;
        return i;
    });

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        if(map.get(timestamp)==null){
            map.put(timestamp,price);
            maxQueue.offer(timestamp);
            minQueue.offer(timestamp);
            latestQueue.offer(timestamp);
        }
        else{
            map.put(timestamp,price);
            List<Integer> index=new ArrayList<>();
            index.add(timestamp);
            maxQueue.removeAll(index);
            minQueue.removeAll(index);
            latestQueue.removeAll(index);

            maxQueue.offer(timestamp);
            minQueue.offer(timestamp);
            latestQueue.offer(timestamp);
        }

    }

    public int current() {
        return map.get(latestQueue.peek());
    }

    public int maximum() {
        return map.get(maxQueue.peek());
    }

    public int minimum() {
        return map.get(minQueue.peek());
    }
}

class StockItem{
    int time;
    int price;

    StockItem(){

    }
}