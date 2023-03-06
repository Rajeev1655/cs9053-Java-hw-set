package complexmatrix;

public class MatrixDimensionException extends Exception{
    public MatrixDimensionException(int m, int n, int m2, int n2) {
        super("Matrix dimensions are not compatible: " + m + "x" + n + "but received: " + m2 + "x" + n2);
    }
}
