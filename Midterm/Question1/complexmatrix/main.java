package complexmatrix;

import java.util.ArrayList;

public class main {

    /** test function for question 2: Complex Matrix **/
    public static void main(String[] args) {
        // test file reading & writing
        String[] files = {"././complexmatrix1.txt", "././complexmatrix2.txt", "././complexmatrix3.txt", "././brokenmatrix.txt"};
        int counter = 0;
        ComplexMatrix[] cmList = new ComplexMatrix[files.length];
        for (String file : files) {
            System.out.println("Reading file: " + file);
            try {
                cmList[counter] = ComplexMatrix.read(file);
                System.out.println(cmList[counter].toString());
                cmList[counter].write("././output" + (counter+1) + ".txt");
                counter++;
            } catch (IncompatibleMatrixException e) {
                System.out.println("\033[31;4m" + e + "\033[0m");
            }
        }

        // test calculations
        try {
            System.out.println("Adding matrix 3 and 3:\n" + cmList[2].add(cmList[2]));
        } catch (MatrixDimensionException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Multiplying matrix 1 and 2:\n" + cmList[0].mult(cmList[1]));
        } catch (MatrixDimensionException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Multiplying matrix 2 and 1:\n" + cmList[1].mult(cmList[0]));
        } catch (MatrixDimensionException e) {
            throw new RuntimeException(e);
        }
    }
}
