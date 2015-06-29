package Algorithms.args4.sort;

/**
 * Created by xu on 2015/6/29.
 */
public class Quick01 {

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}
