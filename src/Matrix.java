import java.util.Random;

public class Matrix {

  private final int n;
  private final int m;

  private int[][] elements;

  public Matrix(int n, int m, int[][] elements) {
    this.n = n;
    this.m = m;
    this.elements = elements;
  }

  public Matrix(int n, int m) {
    this(n,m,new int[n][m]);
  }

  public Matrix (int[][] elements) {
    this.n = elements.length;
    this.m = elements[0].length;

    this.elements = elements;
  }

  public Matrix transpose() {
    Matrix result = new Matrix(getHeight(),getWidth());

    for (int i = 0; i < result.getWidth(); i++) {
      for (int j = 0; j < result.getHeight(); j++) {
        result.set(i,j,getVal(j,i));
      }
    }
    return result;
  }

  public void set(int n, int m, int val) {
    elements[n][m] = val;
  }

  public void add(int n, int m, int val) {
    elements[n][m] += val;
  }

  public int[][] getElements() {
    return elements;
  }

  public static Matrix random(int n, int m) {
    Random rand = new Random();
    Matrix result = new Matrix(n,m);
    System.out.println(result.getWidth());
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result.set(i,j,rand.nextInt(2) * 2 - 1);
      }
    }
    return result;
  }

  public Matrix identityRemove() {
    assert(n == m) : "Not a square matrix";
    for (int i = 0; i < n; i++){
      set(i,i,0);
    }
    return this;
  }

  public Matrix multiply(Matrix B) {

    int Ax = getWidth();
    int Ay = getHeight();

    int Bx = B.getWidth();
    int By = B.getHeight();

    assert(Ax == By) : "Illegal Matrix dimensions";

    Matrix result = new Matrix(Bx,Ay);
    for (int i = 0; i < result.getWidth(); i++) {
      for (int j = 0; j < result.getHeight(); j++) {
        for (int k = 0; k < Ax; k++) {
          result.add(i,j,getVal(k,j) * B.getVal(i,k));
        }
      }
    }
    return result;
  }

  public int getWidth() {
    return n;
  }

  public int getHeight() {
    return m;
  }

  public int getVal(int n, int m) {
    return elements[n][m];
  }

  public Matrix getRow(int i) {
    int[] row = this.transpose().getElements()[i];

    Matrix result = new Matrix(1,n,new int[][]{row});

    return result.transpose();
  }

  public int value() {
    assert(n == 1 && m == 1) : "not a singleton Matrix";

    return getVal(0,0);
  }

  public void print() {
    for (int i = 0; i < getWidth(); i++) {
      for (int j = 0; j < getHeight(); j++) {
        System.out.print(getVal(i,j) + " ");
      }
      System.out.println();
    }
  }
}
