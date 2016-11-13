/**
 * Matrix.java
 *
 * This program compares matrices.
 *
 * @author Brandon Nguyen, Lab Section G06
 * @version 10/5/16
 */

public class Matrix {

    // To be symmetric, the matrix must be a square nxn
    // and the (i,j) entry must be equal to the (j,i) entry
    public boolean isSymmetric(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                if (matrix.length == matrix[row].length) { // check that matrix is square nxn
                    if (matrix[row][col] == matrix[col][row]) { // check that the [row][col] would equal [col][row]
                        return true;
                    }
                } else {
                    System.out.println("Invalid matrix input. Must be NxN");
                }
            }
        }

        return false;
    }

    // To be a diagonal matrix, all entries that do not lie on the main diagonal must equal 0.
    public boolean isDiagonal(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                if (matrix[row][col] != 0) { // the main diagonal will never be 0
                    break;
                }
                return true;
            }
        }
        return false;
    }

    // To be an identity matrix, the matrix must be square nxn matrix, all entries
    // along the main diagonal must equal 1, and all other entries must equal 0
    public boolean isIdentity(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                if (matrix.length == matrix[row].length) { // check that matrix is square nxn
                    if (matrix[row][col++] == 1 && matrix[row++][col] == 1) { // check that matrix's upper and lower are always 1

                    }
                } else {
                    System.out.println("Invalid matrix input. Must be NxN");
                }
            }
        }

        return false;
    }

    // To be an upper triangular matrix, the matrix must be a square nxn matrix and
    // all entries below the main diagonal must equal 0
    public boolean isUpperTriangular(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                if (matrix.length == matrix[row].length) { // check that the matrix is square nxn
                } else {
                    System.out.println("Invalid matrix input. Must be NxN");
                }
            }
        }

        return false;
    }

    // To be a tridiagonal matrix, the matrix must be a square nxn matrix, all entries
    // must equal 0 except the main diagonal, the upper and the lower diagonal
    public boolean isTridiagonal(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                if (matrix.length == matrix[0].length) { // check that the matrix is square nxn

                } else {
                    System.out.println("Invalid matrix input. Must be NxN");
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Matrix m = new Matrix();

        // Expecting true for all
        int[][] diagonalMatrix =
                     {{2, 0, 0, 0},
                      {0, 3, 0, 0},
                      {0, 0, 4, 0},
                      {0, 0, 0, 5}};

        int[][] identityMatrix =
                       {{0, 1, 0, 0},
                        {1, 0, 1, 0},
                        {0, 1, 0, 1},
                        {0, 0, 1, 0}};

        // Does not need to be 1's
        int[][] symmetricMatrix =
                       {{0, 5, 0, 0},
                        {5, 0, 5, 0},
                        {0, 5, 0, 5},
                        {0, 0, 5, 0}};

        // Does not need to be 1's
        int[][] upperTriangularMatrix =
                       {{5, 2, 13, 12},
                        {0, 4, 3, 10},
                        {0, 0, 9, 16},
                        {0, 0, 0, 1}};

        int[][] tridiagonalMatrix =
                       {{3, 10, 0, 0},
                        {4, 5, 12, 0},
                        {0, 9, 20, 50},
                        {0, 0, 1, 30}};

    }
}
