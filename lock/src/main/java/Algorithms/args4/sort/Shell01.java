package Algorithms.args4.sort;

/**
 * Created by xu on 2015/6/29.
 */
public class Shell01 {

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3){
            h = 3*h + 1;
        }
        while (h >= 1){
            for (int i = h;i < N;i++){
                for (int j = i;j >= h && less(a[j],a[j-h]);j -= h){
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    private static void show(Comparable[] a){
        for (int i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] a = {53,656,12,41,34,565,21,11,1,5,7788,2,89};
        sort(a);
        show(a);
    }
}
