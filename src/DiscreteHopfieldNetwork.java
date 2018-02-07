import java.awt.Graphics;
import javax.swing.JFrame;

public class DiscreteHopfieldNetwork {

  private JFrame frame;
  private int width = 100;

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
    Graphics g = frame.getGraphics();
    g.clearRect(0,0,width*n,width*m);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        switch (nodes.getElements()[j + i * n][0]) {
          case 1:
            System.out.print(1 + " ");
            g.fillRect(j*width,i*width,width,width);
            break;
          case -1:
            System.out.print(0 + " ");
            break;
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
  public void run(int p) {
    frame = new JFrame();
    frame.setSize(n * width, m * width);
    frame.setVisible(true);

    asynchronous(p);
  }

  public void asynchronous(int p) {
    if (p == 0) {
      print();
    } else {
      print();

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      for (int i = 0; i < n * m; i++) {
        nodes.set(i, 0, sign(weights.getRow(i).multiply(nodes).value()));
        print();
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      asynchronous(p-1);
    }
  }
}
