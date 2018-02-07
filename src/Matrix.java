import java.util.Random;

public class Matrix {

  private int n;
  private int m;

  private int[][] elements;

  public Matrix(int n, int m) {
    this.n = n;
    this.m = m;

    elements = new int[n][m];
  }

  public Matrix(int n) {
    this.n = n;
    this.m = n;

    elements = new int[n][m];
  }

  public static Matrix identity(int n) {
    Matrix m = new Matrix(n);
    for (int i = 0; i < n; i++) {
      m.getElements()[i][i] = 1;
    }
    return m;
  }

  public static Matrix identityRemove(Matrix m) {
    for (int i = 0; i < m.elements.length; i++) {
      m.getElements()[i][i] = 0;
    }
    return m;
  }

  public static Matrix transpose(Matrix in) {
    int n = in.getElements().length;
    int m = in.getElements()[0].length;
    Matrix b = new Matrix(m, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        b.set(j, i, in.getElements()[i][j]);
      }
    }
    return b;
  }

  public Matrix add(Matrix other) {
    Matrix result = new Matrix(n, m);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result.set(n, m, getElements()[n][m] + other.getElements()[n][m]);
      }
    }
    return result;
  }

  public Matrix sub(Matrix other) {
    Matrix result = new Matrix(n, m);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result.set(n, m, getElements()[n][m] - other.getElements()[n][m]);
      }
    }
    return result;
  }

  public Matrix multiply(Matrix mat) {
    int n1 = elements.length;
    int m1 = elements[0].length;

    int n2 = mat.getElements().length;
    int m2 = mat.getElements()[0].length;

    if (n1 != m2) {
      throw new RuntimeException("Illegal matrix dimensions.");
    }

    Matrix c = new Matrix(n1, m2);
    for (int i = 0; i < m2; i++) {
      for (int j = 0; j < n1; j++) {
        for (int k = 0; k < m1; k++) {
          c.add(i, j, elements[i][k] * mat.getElements()[k][j]);
        }
      }
    }
    return c;
  }

  public void multiply(int val) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        elements[i][j] *= val;
      }
    }
  }

  public int[][] getElements() {
    return elements;
  }

  public void set(int n, int m, int val) {
    elements[n][m] = val;
  }

  public void add(int n, int m, int val) {
    elements[n][m] += val;
  }

  public void print() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(elements[i][j] + ",");
      }
      System.out.println();
    }
  }

  public int value() {
    return elements[0][0];
  }

  public Matrix getRow(int i) {
    return Main.makeMatrix(new int[][]{elements[i]});
  }

  public Matrix getCol(int i) {
    return Matrix.transpose(Matrix.transpose(this).getRow(i));
  }

  public static Matrix random(int n, int m) {
    Random rand = new Random();
    Matrix mat = new Matrix(n,m);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat.set(i,j,rand.nextInt(2));
      }
    }
    return mat;
  }


}
