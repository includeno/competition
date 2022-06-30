package leetcode.problem;

//https://leetcode.cn/problems/prime-arrangements/
public class Leetcode1175 {

    public static int MOD = (int)1e9+7;
    public static int[] primeNumber=new int[110];

    static{
        for (int i = 2; i <= 100; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) ok = false;
            }
            if (ok) {
                primeNumber[i]=primeNumber[i-1]+1;//当前数字为质数 数量+1
            }
            else{
                primeNumber[i]=primeNumber[i-1];//当前数字不是质数 保持上一个结果
            }
        }
    }
    public int numPrimeArrangements(int n) {
        int a = primeNumber[n], b = n - a;
        long ans = 1;
        for (int i = b; i > 1; i--) ans = ans * i % MOD ;
        for (int i = a; i > 1; i--) ans = ans * i % MOD ;
        return (int)ans;
    }
}
