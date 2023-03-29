package model;

public class kernels {
  public static double[][] getImageBlurKernel() {
    return new double[][]{{0.0625, 0.125, 0.0625},
         {0.125, 0.25, 0.125},
         {0.0625, 0.125, 0.0625}};
  }

  public static double[][] getImageSharpenKernel() {
    return new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, 0.25, 1, 0.25, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, -0.125, -0.125, -0.125, -0.125},
    };
  }


}
