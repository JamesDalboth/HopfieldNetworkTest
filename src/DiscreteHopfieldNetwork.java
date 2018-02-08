import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DiscreteHopfieldNetwork extends JFrame{

  private int picWidth;
  private int picHeight;

  private int width = 50;

  private Matrix nodes;

  private Matrix weights;


  private Mode mode;

  public DiscreteHopfieldNetwork(int picWidth, int picHeight) {
    super();
    this.picWidth = picWidth;
    this.picHeight = picHeight;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public void train(Matrix data) {
    //JFrame setup
    this.setSize(picWidth * width, picHeight * width);
    this.setVisible(true);

    //Calculating the Weight matrix
    Matrix U = data.multiply(data.transpose()).identityRemove();
    weights = U;
    weights.print();
    ;
  }

  public void setNodes(Matrix in) {
    nodes = in;
  }

  public void print() {
    Graphics g = this.getGraphics();

    for (int i = 0; i < picWidth; i++) {
      for (int j = 0; j < picHeight; j++) {
        switch (nodes.getVal(0,j + i * picWidth)) {
          case 1:
            System.out.print(1 + " ");
            g.setColor(Color.BLUE);
            break;
          case -1:
            System.out.print(0 + " ");
            g.setColor(Color.red);
            break;
        }
        g.fillRect(j*width,i*width,width,width);
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

  public Matrix sign(Matrix mat) {
    for (int i = 0; i < mat.getElements().length;i++) {
      for (int j = 0; j < mat.getElements()[0].length;j++) {
        mat.set(i,j,mat.getVal(i,j) < 0 ? -1 : 1);
      }
    }
    return mat;
  }

  public void run(int p) {
    switch (mode) {
      case Sync:
        synchronous(p);
        break;
      case Async:
        asynchronous(p);
        break;
    }
  }

  public void synchronous(int p) {
    print();
    if (p != 0) {
      Matrix s = weights.multiply(nodes);
      nodes = sign(s);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronous(p-1);
    }
  }

  public void asynchronous(int p) {
    print();
    if (p != 0) {
      for (int i = 0; i < picWidth * picHeight; i++) {
        nodes.set(0, i, sign(weights.getRow(i).multiply(nodes).value()));
        print();
      }
      System.out.println("Next " + p);
      asynchronous(p-1);
    }
  }
}
