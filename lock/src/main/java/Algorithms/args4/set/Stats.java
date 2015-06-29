package Algorithms.args4.set;

import stdlib.StdIn;
import stdlib.StdOut;

/**
 * Created by xu on 2015/6/26.
 */
public class Stats {
    public static void main(String[] args) {

        // read in numbers
        Bag<Double> numbers = new Bag<Double>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();

        // compute sample mean
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum/N;

        // compute sample standard deviation
        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum/(N-1));

        StdOut.printf("Mean:    %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
