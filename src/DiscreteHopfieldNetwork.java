public class DiscreteHopfieldNetwork {

  private int n;

  private int m;

  private Matrix nodes;

  private Matrix weights;

  public DiscreteHopfieldNetwork(int n, int m) {
    this.n = n;

    this.m = m;

    nodes = new Matrix(1, n * m);

    weights = new Matrix(n * m, n * m);
  }

  public void train(Matrix data, int n) {
    Matrix U = Matrix.identityRemove(Matrix.transpose(data).multiply(data));
    weights = U;
  }

  public void setNodes(Matrix in) {
    nodes = in;
  }

  public void print() {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        switch (nodes.getElements()[j + i * n][0]) {
          case 1:
            System.out.print(1 + " ");
            break;
          case -1:
            System.out.print(0 + " ");
        }
      }
      System.out.println();
    }

    System.out.println("+++++++++++++++++++++");
  }

  public int sign(int val) {
    if (val < 0) {
      return -1;
    }
    return 1;
  }

  public void asynchronous() {
    print();

    for (int i = 0; i < n * m; i++) {
      nodes.set(i, 0, sign(weights.getRow(i).multiply(nodes).value()));
    }

    print();
  }
}
