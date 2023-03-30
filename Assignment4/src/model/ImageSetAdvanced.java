package model;

import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;

/**
 * ImageSetAdvanced class implements the IImageAdvanced interface, and it acts as a model.
 */
public class ImageSetAdvanced extends ImageSet implements IImageAdvanced {

  @Override
  public ImageObj filterBlur(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] kernel = Kernels.getImageBlurKernel();
    ImageObj img = map.get(imageName).filtering(kernel);
    map.put(destImageName, img);
    return img;
  }

  @Override
  public ImageObj filterSharpen(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] kernel = Kernels.getImageSharpenKernel();
    ImageObj img = map.get(imageName).filtering(kernel);
    map.put(destImageName, img);
    return img;
  }

  @Override
  public ImageObj transformGreyScale(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] matrix = Transformations.getGreyScaleMatrix();
    ImageObj img = map.get(imageName).transformation(matrix);
    map.put(destImageName, img);
    return img;
  }

  @Override
  public ImageObj transformSepia(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    double[][] matrix = Transformations.getSepiaMatrix();
    ImageObj img = map.get(imageName).transformation(matrix);
    map.put(destImageName, img);
    return img;
  }

  @Override
  public ImageObj dither(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName}, new String[]{destImageName});
    ImageObj img = map.get(imageName).dithering();
    map.put(destImageName, img);
    return img;
  }
}