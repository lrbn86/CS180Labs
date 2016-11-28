import java.io.File;

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
    public static int determinant(int[][] matrix){

        // matrix must be nxn
        if (matrix.length == matrix[0].length) {

            // if matrix has size 1 x 1, the determinant is the single element in the matrix
            if (matrix.length == 1) {

                return matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1];

            } else {

                int d = 0; // determinant variable



            }


        } else {

            System.err.println("Matrix must have an equal number of rows and columns.");
            return -1;

        }

        return 0;
    }


    /**
     * Counts the total number of files in the given directory recursively.
     *
     * @param f The current file or directory
     * @return The total number of files in f
     */
    public static int filecount(File f) {

        if (!f.isDirectory()) {

        } else {



        }

        return 0;
    }

    public static void main(String[] args) {
    }

}