package model;

/**
 * This class represents the different matrices used for the image transformations.
 */
public class Transformations {

  /**
   * Returns the matrix used for grey scale transformation.
   *
   * @return the double matrix of the grey scale transformation.
   */
  public static double[][] getGreyScaleMatrix() {

    return new double[][]{{0.2126, 0.7152, 0.2126}, {0.2126, 0.7152, 0.2126},
        {0.2126, 0.7152, 0.2126}};
  }

  /**
   * Returns the matrix used for sepia transformation.
   *
   * @return the double matrix of the sepia transformation.
   */
  public static double[][] getSepiaMatrix() {

    return new double[][]{{0.393, 0.769, 0.189}, {0.349, 0.686, 0.168}, {0.272, 0.534, 0.131}};
  }
}
