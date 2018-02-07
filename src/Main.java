public class Main {

  private static int width = 6;
  private static int height = 6;

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

  static int[] test = new int[]{
      0, 0, 0, 0, 0, 0,
      0, 0, 0, 1, 0, 0,
      0, 0, 0, 1, 0, 0,
      0, 0, 0, 1, 0, 0,
      0, 0, 0, 1, 0, 0,
      0, 0, 0, 1, 0, 0
  };


  public static void main(String[] args) {
    int[][] trainingDataArray = new int[][]{zero, one, two};
    Matrix trainingData = makeMatrix(trainingDataArray);

    DiscreteHopfieldNetwork dhn = new DiscreteHopfieldNetwork(width, height);
    dhn.train(trainingData, trainingDataArray.length);
    dhn.setNodes(Matrix.random(width*height,1));
    dhn.run(2);
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
