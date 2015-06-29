package Algorithms.args4;

/**
 * Created by xu on 2015/6/25.
 */
public class Array01 {

    /**
     * 最大值
     * @param a
     * @return
     */
    public static int max(int[] a){
        int max = a[0];
        for (int i = 0;i < a.length;i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    /**
     * 平均值
     * @param a
     * @return
     */
    public static double avg(int[] a){
        int N = a.length;
        double sum = 0.0;
        for (int i = 0;i < N -1;i++){
            sum += a[i];
        }
        return sum/N;
    }

    /**
     * 拷贝
     * @param a
     * @return
     */
    public static int[] copy(int[] a){
        int N = a.length;
        int[] b = new int[N];
        for (int i = 0;i < N;i++){
            b[i] = a[i];
        }
        return b;
    }

    /**
     * 反转
     * @param a
     * @return
     */
    public static int[] flip(int[] a){
        int N = a.length;
        for (int i = 0;i < N/2;i++){
            exch(a,i,N - 1 - i);
        }
        return a;
    }

    private static void exch(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void show(int[] a){
        for (int i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {3,21,67,1,8,97};
        flip(a);
        show(a);
    }
}
