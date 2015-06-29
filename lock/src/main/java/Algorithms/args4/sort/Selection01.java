package Algorithms.args4.sort;

/**
 * Created by xu on 2015/6/29.
 */
public class Selection01 {

    private static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0;i < N;i++){
            int min = i;
            for (int j = i + 1;j < N;j++){
                if (less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;//用v < w，来表示 v.compareTo(w) < 0
    }

    public static void show(Comparable[] a){
        for (int i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] a = {4,6,1,3,9,5};
        sort(a);
        show(a);
    }
}
