import java.util.*;
import java.io.*;
import static java.lang.Math.*;

// Solution for the problem from https://www.hackerrank.com/challenges/java-loops/problem
class Hakerrank_Java_Loops_II{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your data");
        System.out.println("The first line should contain an integer q, denoting the number of queries.");
        System.out.println("Each line of the subsequent lines should contain a_i, b_i, n_i for that query, space-separated.");
        int q = in.nextInt(); // number of lines
        int [] a = new int[500]; // to fit the constraint q<=500
        int [] b = new int[500];
        int [] n = new int[500];
        int[][] s = new int[q][500];
        for (int i = 0; i < q; i++) {  // each line
            a[i] = in.nextInt(); // reading input...
            b[i] = in.nextInt();
            n[i] = in.nextInt();

            s[i][0] = a[i] + b[i]; // a + 2^0 * b
            for (int j = 1; j < n[i]; j++) {
                s[i][j] = (int) (s[i][j - 1] + pow(2, j) * b[i]); /* = a + 2^0 * b + 2^1 * b + ... +
                        //+ [2^(n-1)]*b   */
            }
        }
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n[i]; j++) {
                System.out.print(s[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
