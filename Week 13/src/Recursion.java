import java.io.File;
import java.util.Arrays;

/**
 * Recursion.java
 *
 * Perform recursions
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 28, 2016
 *
 */
public class Recursion {


    /**
     * Calculates the determinant of the argument matrix recursively
     *
     * @param matrix The matrix to find the determinant of
     * @return The determinant of the argument matrix
     */
    public static int determinant(int[][] matrix) {

        int d = 0;

        int length = matrix.length;

        int[][] A = new int[length][length]; // create minor matrix

        // Base case
        if (length == 1) {

            return matrix[0][0];

        } else {

            for (int i = 0; i < length; i++) {

                if (i == 0) {
                    length--;
                    continue; // skip the first row
                }

                for (int j = 0; j < length; j++) {

                    if (j == 0) {
                        length--;
                        continue; // skip the first column
                    }

                }

            }

        }

        return d;
    }

    /**
     * Counts the total number of files in the given directory recursively.
     *
     * @param f The current file or directory
     * @return The total number of files in f
     */
    public static int filecount(File f) {

        int numOfFiles = 0;

        File[] files = f.listFiles();

        // Base case
        if (f.isFile()) {

            return 1;

        } else {

            for (File file : files) { // for each file in files

                if (file.isDirectory()) { // if that file is a directory

                    numOfFiles += filecount(file); // make recursive call to that directory and store/increment into counter

                } else { // if that file is a file

                    numOfFiles++; // increment counter

                }
            }
        }

        return numOfFiles;
    }

    /**
     * Program's Main Entry Point
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {

        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(determinant(m));

    }

}