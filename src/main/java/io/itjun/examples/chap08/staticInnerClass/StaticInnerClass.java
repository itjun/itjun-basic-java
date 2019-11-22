package io.itjun.examples.chap08.staticInnerClass;

/**
 * The program demonstrates the use of static inner class
 * <p>
 * Created by iCrazyTeam on 16/6/27.
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        double[] arr = new double[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1000 * Math.random();
        }

        ArrayAlg.Pair pair = ArrayAlg.fetch(arr);
        System.out.println("min = " + pair.getStart());
        System.out.println("max = " + pair.getEnd());
    }
}

class ArrayAlg {

    /**
     * Computes both the minimum and the maximum of the pair
     *
     * @param values an array of floating-points numbers
     * @return a pair whose start element is the minimum and whose end element
     * is the maximum
     */
    public static Pair fetch(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        return new Pair(min, max);
    }

    /**
     * A pair of floating-point number
     */
    public static class Pair {
        private double start;
        private double end;

        /**
         * Constructs a pair from two floating-points number
         *
         * @param start the start number
         * @param end   the end number
         */
        public Pair(double start, double end) {
            this.start = start;
            this.end = end;
        }

        /**
         * Return the start number of the pair
         *
         * @return the start number
         */
        public double getStart() {
            return start;
        }

        /**
         * Return the end number of the pair
         *
         * @return the end number
         */
        public double getEnd() {
            return end;
        }

    }
}