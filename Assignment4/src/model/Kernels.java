package model;

/**
 * This class represents different kernels used for the image transformation.
 */
public class Kernels {

  /**
   * Returns the kernel necessary for the image blur.
   *
   * @return the double matrix of the blur kernel.
   */
  public static double[][] getImageBlurKernel() {
    return new double[][]{{0.0625, 0.125, 0.0625}, {0.125, 0.25, 0.125}, {0.0625, 0.125, 0.0625}};
  }

  /**
   * Returns the kernel necessary for the image sharpen.
   *
   * @return the double matrix of the sharp kernel.
   */

  public static double[][] getImageSharpenKernel() {
    return new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125}, {-0.125, 0.25, 1, 0.25, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125}, {-0.125, -0.125, -0.125, -0.125, -0.125},};
  }


}
