package Algorithms.args4;

import java.util.Arrays;

/**
 * Created by xu on 2015/6/25.
 * 递归
 */
public class Recusion01 {

    public static int rank(int key,int[] a){
        return rank(key,a,0,a.length);
    }

    private static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key,a,lo,mid -1);
        else if (key > a[mid])
            return rank(key,a,mid + 1,hi);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] a = {5,322,6,2,1,8,77,43};
        Arrays.sort(a);
        int result = rank(61,a);
        System.out.println("二分查找，key的位置: " + result);
    }
}
