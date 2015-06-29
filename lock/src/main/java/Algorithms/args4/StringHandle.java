package Algorithms.args4;

/**
 * Created by xu on 2015/6/12.
 */
public class StringHandle {
    /**
     * 判断字符串是否是一条回文
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){
        int N = s.length();
        for (int i = 0;i < N/2;i++){
            if (s.charAt(i) != s.charAt(N-1-i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 提取文件名和扩展名
     */
    private static void extract() {
        String s = "aa.jpg";
        int dot = s.indexOf(".");
        String base = s.substring(0, dot);
        String extension = s.substring(dot + 1,s.length());
        System.out.println(base+ "\n" + extension);
    }

    /**
     * 数组是否按照字母表排序
     * @param a
     * @return
     */
    public static boolean isSorted(String[] a){
        for (int i = 1;i < a.length;i++){
            if (a[i-1].compareTo(a[i]) > 0){
                return false;
            }
        }
        return true;
    }

    public static int gcd(int p,int q){
        if (q == 0){
            return 0;
        }
        int r = p % q;
        return gcd(q,r);
    }

    public static void main(String[] args) {
        //String a[] = {"a","b","c","f","e"};
        //System.out.println(isSorted(a));

        System.out.println(gcd(7,3));

    }


}
