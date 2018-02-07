public class Main {

  static int[] one = new int[]{
      0, 0, 1, 0, 0, 0,
      0, 1, 0, 1, 0, 0,
      0, 0, 0, 1, 0, 0,
      0, 0, 0, 1, 0, 0,
      0, 0, 0, 1, 0, 0,
      0, 1, 1, 1, 1, 0
  };

  static int[] zero = new int[]{
      0, 1, 1, 1, 1, 0,
      1, 0, 0, 0, 0, 1,
      1, 0, 0, 0, 0, 1,
      1, 0, 0, 0, 0, 1,
      1, 0, 0, 0, 0, 1,
      0, 1, 1, 1, 1, 0
  };

  static int[] two = new int[]{
      0, 1, 1, 1, 1, 0,
      0, 0, 0, 0, 1, 0,
      0, 0, 0, 1, 0, 0,
      0, 0, 1, 0, 0, 0,
      0, 1, 0, 0, 0, 0,
      0, 1, 1, 1, 1, 0
  };

  static int[] halfTwo = new int[]{
      0, 1, 1, 1, 1, 0,
      0, 0, 0, 0, 0, 1,
      0, 0, 0, 0, 0, 1,
      0, 0, 0, 0, 0, 1,
      0, 0, 0, 0, 0, 1,
      0, 0, 0, 1, 1, 0
  };


  public static void main(String[] args) {
    Matrix trainingData = makeMatrix(new int[][]{zero, one, two});

    DiscreteHopfieldNetwork dhn = new DiscreteHopfieldNetwork(6, 6);
    dhn.train(trainingData, 3);
    dhn.setNodes(Matrix.transpose(makeMatrix(new int[][]{halfTwo})));
    dhn.asynchronous();
  }

  public static Matrix makeMatrix(int[][] data) {

    Matrix m = new Matrix(data.length, data[0].length);
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[0].length; j++) {
        m.set(i, j, 2 * data[i][j] - 1);
      }
    }
    return m;
  }

}
