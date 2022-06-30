package leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leetcode1175Test {

    public static Leetcode1175 instance=new Leetcode1175();

    @Test
    public void example1(){
        assertEquals(12,instance.numPrimeArrangements(5));
    }

    @Test
    public void example2(){
        assertEquals(682289015,instance.numPrimeArrangements(100));
    }

}