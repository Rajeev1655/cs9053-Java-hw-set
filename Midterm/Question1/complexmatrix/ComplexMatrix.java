package complexmatrix;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ComplexMatrix {
	private Complex[][] matrix;
	private int m;
	private int n;
	
	public static void main(String[] args) {

	}

	// return m x n matrix of 0-value Complex numbers
	public ComplexMatrix(int m, int n) {
		Complex[][] matrix = new Complex[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = new Complex();
			}
		}
		this.matrix = matrix;
		this.m = m;
		this.n = n;
	}

	// return matrix corresponding to 2D array
	public ComplexMatrix(Complex[][] input) {
		Complex[][] matrix = new Complex[input.length][input[0].length];
		for (int i = 0; i < input.length; i++) {
			System.arraycopy(input[i], 0, matrix[i], 0, input[0].length);
		}
		this.matrix = matrix;
		this.m = input.length;
		this.n = input[0].length;
	}

	public ComplexMatrix add(ComplexMatrix cm) throws MatrixDimensionException {
		if (this.m != cm.m || this.n != cm.n) {
			throw new MatrixDimensionException(this.m, this.n, cm.m, cm.n);
		}

		ComplexMatrix newMatrix = new ComplexMatrix(this.m, this.n);
		for (int i = 0; i < cm.m; i++) {
			for (int j = 0; j < cm.n; j++) {
				newMatrix.matrix[i][j] = this.matrix[i][j].add(cm.matrix[i][j]);
			}
		}
		return newMatrix;
	}

	public ComplexMatrix mult(ComplexMatrix cm) throws MatrixDimensionException {
		if (this.n != cm.m) {
			throw new MatrixDimensionException(this.m, this.n, cm.m, cm.n);
		}

		ComplexMatrix newMatrix = new ComplexMatrix(this.m, cm.n);
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < cm.n; j++) {
				for (int k = 0; k < this.n; k++) {
					newMatrix.matrix[i][j] = newMatrix.matrix[i][j].add(this.matrix[i][k].multiply(cm.matrix[k][j]));
				}
			}
		}
		return newMatrix;
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				output.append(this.matrix[i][j].toString()).append(" ");
			}
			output.append("\n");
		}
		return output.toString();
	}

	public static ComplexMatrix read(String filename) throws IncompatibleMatrixException {
		ArrayList<ArrayList<Complex>> arrComplex = new ArrayList<>();
		int counter = 0;
		File f = new File(filename);
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String[] line = sc.nextLine().split(" ");
				for (String s : line) {
					String a = s.trim().split("_")[0];
					String b = s.trim().split("_")[1];
					Complex complex = new Complex(Double.parseDouble(a), Double.parseDouble(b));
					if (counter >= arrComplex.size()) {
						arrComplex.add(new ArrayList<>());
					}
					arrComplex.get(counter).add(complex);
				}
				counter++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		int m = arrComplex.size();
		int n = arrComplex.get(0).size();
		Complex[][] matrix = new Complex[m][n];
		// add to 2D array
		for (int i = 0; i < m; i++) {
			if (arrComplex.get(i).size() != n) {
				throw new IncompatibleMatrixException();
			}
			for (int j = 0; j < n; j++) {
				matrix[i][j] = arrComplex.get(i).get(j);
			}
		}

		return new ComplexMatrix(matrix);
	}

	public void write(String filename) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			for (Complex[] row : this.matrix) {
				for (Complex c : row) {
					out.write(c.toString().replace(" + i", "_").replace(" + -i", "_-"));
					out.write(" ");
				}
				out.write("\n");
			}
			out.close();
			System.out.println("File " + filename + " written successfully\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}