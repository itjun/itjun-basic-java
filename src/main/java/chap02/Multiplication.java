package chap02;

/**
 * Created by iCrazyTeam on 2017/04/03 0005.
 */
public class Multiplication {
    public static void main(String[] args) {
        and991();
        System.out.println("-----------------");

        and992();
        System.out.println("-----------------");

        and993();
        System.out.println("-----------------");

        and994();
    }

    public static void and991() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                if (j < i) {
                    System.out.print(String.format("%d * %d = %d \t", j, i, j * i));
                } else {
                    System.out.println(String.format("%d * %d = %d", j, i, j * i));
                }
            }
        }
    }

    public static void and992() {
        for (int i = 9; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    System.out.println(String.format("%d * %d = %d", j, i, i * j));
                } else {
                    System.out.print(String.format("%d * %d = %d \t", j, i, i * j));
                }
            }
        }
    }

    public static void and993() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i >= 10 - j) {
                    System.out.print(String.format("%d * %d = %d \t", 10 - j, i, (10 - j) * i));
                } else {
                    System.out.print("\t");
                    System.out.print("\t");
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void and994() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i <= j) {
                    System.out.print(String.format("%d * %d = %d \t", 10 - i, 10 - j, (10 - j) * (10 - i)));
                } else {
                    System.out.print("\t");
                    System.out.print("\t");
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }

}
