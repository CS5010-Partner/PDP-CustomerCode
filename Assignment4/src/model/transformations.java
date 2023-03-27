package model;

public class transformations {
  public static double[][] getGreyScaleMatrix() {
    double[][] matrix = {{0.2126, 0.7152, 0.2126},
        {0.2126, 0.7152, 0.2126},
        {0.2126, 0.7152, 0.2126}};

    return matrix;
  }

  public static double[][] getSepiaMatrix() {
    double[][] matrix = {{0.393, 0.769, 0.189},
        {0.349, 0.686, 0.168},
        {0.272, 0.534, 0.131}};

    return matrix;
  }
}
