package util;

import java.util.Arrays;

public class Helper {

    public static void printArray2d(int[][] array){
        System.out.println();
        System.out.println("======================");
        for(int i=0;i<array.length;i++){
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println("======================");
        System.out.println();
    }

    public static void printArray2d(int[][] array,String message){
        System.out.println();
        System.out.println(message);
        System.out.println("======================");
        for(int i=0;i<array.length;i++){
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println("======================");
        System.out.println();
    }
}
