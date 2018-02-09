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
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    nodes = Matrix.random(1,picWidth*picHeight);

    //JFrame setup

    width = 800 / picWidth;
    this.setVisible(true);

  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public void train(Matrix data) {


    //Calculating the Weight matrix
    Matrix U = data.multiply(data.transpose()).identityRemove();
    weights = U;
  }

  public void setNodes(Matrix in) {
    paint(this.getGraphics());
    nodes = in;
  }

  @Override
  public void paint(Graphics g){
    super.paint(g);
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
        g.fillRect(j*width + 300,i*width + 100,width,width);
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
    paint(this.getGraphics());

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
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

    if (p != 0) {
      Matrix s = weights.multiply(nodes);
      nodes = sign(s);
      run(p-1);
    }
  }

  public void asynchronous(int p) {
    if (p != 0) {
      for (int i = 0; i < picWidth * picHeight; i++) {
        paint(this.getGraphics());
        nodes.set(0, i, sign(weights.getRow(i).multiply(nodes).value()));
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("Next " + p);
      run(p-1);
    }
  }

  public Matrix getNodes() {
    return nodes;
  }
}
