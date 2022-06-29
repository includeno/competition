package leetcode.week261;

public class Problem2029 {

    public static void main(String[] args) {
        int[] stones=new int[]{19,2,17,20,7,17};
        System.out.println(stoneGameIX(stones));
    }

    public static boolean stoneGameIX(int[] stones) {
        int len=stones.length;
        int[] state={0,0,0};
        for(int stone:stones){state[stone%3]++;}
        String winner=dfsWin("Alice",0,state[0],state[1],state[2]);
        return winner=="Alice";
    }
    // player Alice Bob
    public static String dfsWin(String player,int sum,int s0,int s1,int s2){
        if(s0==0&&s1==0&&s2==0){return "Bob";}
        //默认当前方输
        String nextPlayer="";
        if(player=="Alice"){nextPlayer="Bob";}
        else{nextPlayer="Alice";}
        String winner=nextPlayer;
        //如果sum != 0,分析当前玩家可能面临什么情况,根据情况选择最优决策。
        //情况1: (s0 == 0 && s1 == 0 && s2 == 0)->无牌可出,Bob胜。
        //情况2: (s0 > 0)-> 此时玩家存在翻盘机会, 把困境抛给另一方。
        //情况3: (sum == 1 && s1 > 0)->此时石子0已经出完了,如果出石子2,sum将可以被3整除,只能出石子1。
        //情况4: (sum == 2 && s2 > 0)->此时石子0已经出完了,如果出石子1,sum将可以被3整除,只能出石子2。
        if(sum!=0){
            //if(s0==0&&s1==0&&s2==0){return "Bob";}
            if(s0>0){
                return dfsWin(nextPlayer,sum,s0-1,s1,s2);
            }
            if(sum==1&&s1>0){
                return dfsWin(nextPlayer,2,s0,s1-1,s2);
            }
            if(sum==2&&s2>0){
                return dfsWin(nextPlayer,1,s0,s1,s2-1);
            }
        }else{
            //如果sum == 0,说明游戏刚刚开始，此时玩家有两个选择(选择余数为1的石子，选择余数为0的石子)
            //如果存在获胜决策,自己将获胜,否则落败。
            if(s1>0&&dfsWin(nextPlayer,1,s0,s1-1,s2)==player){winner=player;}
            if(s2>0&&dfsWin(nextPlayer,2,s0,s1,s2-1)==player){winner=player;}
        }
        return winner;
    }


}
