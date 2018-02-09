import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {

  static int[] one = new int[]{
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,
      0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
  };
  static int[] zero = new int[]{
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0,
      0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0,
      0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0,
      1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
      1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
      1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
      0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0,
      0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0,
      0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
  };
  static int[] two = new int[]{
      0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,
      1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,
      1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
      1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
      1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
  };
  static int[] three = new int[]{
      0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0,
      0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,
      0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,
      0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0,
      0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0,
      0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0,
      0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0,
      0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0
  };

  static int[] test = new int[]{
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
  };
  private static int width = 12;
  private static int height = 12;

  public static void main(String[] args) {


    int[][] trainingDataArray = new int[][]{fix(zero), fix(one), fix(two),fix(three)};
    Matrix trainingData = new Matrix(trainingDataArray);
    DiscreteHopfieldNetwork dhn = new DiscreteHopfieldNetwork(width, height);
    dhn.train(trainingData);
    dhn.setNodes(Matrix.random(1,width * height));

    dhn.setMode(Mode.Async);



    JButton run = new JButton("RUN");
    run.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dhn.run(1);
      }
    });

    JPanel p = new JPanel();
    p.setLayout(null);
    run.setBounds(50, 50, 200, 50);
    p.add(run);

    JButton distort = new JButton("Distory 10%");
    distort.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dhn.setNodes(Matrix.distort(dhn.getNodes(),0.10f));
        dhn.paint(dhn.getGraphics());
        System.out.println("Distorted");
      }

    });
    distort.setBounds(50,600,200,50);
    p.add(distort);


    DefaultListModel<String> list = new DefaultListModel<String>();
    list.addElement("Zero");
    list.addElement("One");
    list.addElement(" Two");
    list.addElement("Three");
    list.addElement("Random");
    JList<String> l = new JList<>(list);
    l.setBounds(50,150,200,150);

    l.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
        switch (l.getSelectedIndex()) {
          case 0:
            dhn.setNodes(Matrix.makeMatrix(zero));
            break;
          case 1:
            dhn.setNodes(Matrix.makeMatrix(one));
            break;
          case 2:
            dhn.setNodes(Matrix.makeMatrix(two));
            break;
          case 3:
            dhn.setNodes(Matrix.makeMatrix(three));
            break;
          case 4:
            dhn.setNodes(Matrix.random(1,width*height));
        }

        dhn.paint(dhn.getGraphics());
        System.out.println("b");
      }
    });

    p.add(l);

    DefaultListModel<String> modes = new DefaultListModel<String>();
    modes.addElement("Async");
    modes.addElement("Sync");
    JList<String> m = new JList<>(modes);
    m.setBounds(50,450,200,40);

    m.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
        switch (m.getSelectedIndex()) {
          case 0:
            dhn.setMode(Mode.Async);
            break;
          case 1:
            dhn.setMode(Mode.Sync);
            break;
        }

        dhn.paint(dhn.getGraphics());
        System.out.println("b");
      }
    });

    p.add(m);

    dhn.add(p);

    dhn.setSize(1200,1000);
  }

  public static int[] fix(int[] data) {
    for (int i = 0; i < data.length; i++) {
      data[i] = data[i] == 0 ? -1 : 1;
    }
    return data;
  }


}
