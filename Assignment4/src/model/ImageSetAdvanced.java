package model;

import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;

public class ImageSetAdvanced extends ImageSet implements IImageAdvanced {

  public ImageObj filterBlur(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] kernel= kernels.getImageBlurKernel();
    ImageObj img = map.get(imageName).filtering(kernel);
    map.put(destImageName, img);
    return img;
  }

  public ImageObj filterSharpen(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] kernel = kernels.getImageSharpenKernel();
    ImageObj img = map.get(imageName).filtering(kernel);
    map.put(destImageName, img);
    return img;
  }

  public ImageObj transformGreyScale(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] matrix = transformations.getGreyScaleMatrix();
    ImageObj img = map.get(imageName).transformation(matrix);
    map.put(destImageName, img);
    return img;
  }

  public ImageObj transformSepia(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] matrix = transformations.getSepiaMatrix();
    ImageObj img = map.get(imageName).transformation(matrix);
    map.put(destImageName, img);
    return img;
  }

  public ImageObj dither(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    ImageObj img = map.get(imageName).dithering();
    map.put(destImageName, img);
    return img;
  }
}