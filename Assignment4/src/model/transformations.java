package model;

public class transformations {
  public static double[][] getGreyScaleMatrix() {

    return new double[][]{{0.2126, 0.7152, 0.2126},
        {0.2126, 0.7152, 0.2126},
        {0.2126, 0.7152, 0.2126}};
  }

  public static double[][] getSepiaMatrix() {

    return new double[][]{{0.393, 0.769, 0.189},
        {0.349, 0.686, 0.168},
        {0.272, 0.534, 0.131}};
  }
}
