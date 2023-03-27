package model;

public class kernels {
  public static double[][] getImageBlurKernel() {
    double[][] kernel = {{0.0625, 0.125, 0.0625},
         {0.125, 0.25, 0.125},
         {0.0625, 0.125, 0.0625}};
    return kernel;
  }

  public static double[][] getImageSharpenKernel() {
    double[][] kernel = {{-0.125, -0.125, -0.125, -0.125, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, 0.25, 1, 0.25, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, -0.125, -0.125, -0.125, -0.125},
    };
    return kernel;
  }


}
