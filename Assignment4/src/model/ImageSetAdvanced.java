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

  @Override
  public ImageObj[] histogram(String imageName, String redHistImgName, String blueHistImgName,
      String greenHistImgname, String intHistImgName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    checkName(new String[]{imageName},
        new String[]{redHistImgName, blueHistImgName, greenHistImgname, intHistImgName});
    ImageObj[] histograms = map.get(imageName).histograms();
    map.put(redHistImgName, histograms[0]);
    map.put(blueHistImgName, histograms[1]);
    map.put(greenHistImgname, histograms[2]);
    map.put(intHistImgName, histograms[3]);
    return histograms;
  }

  @Override
  public ImageObj[] rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName) throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName},
        new String[]{redDesImageName, greenDesImageName, blueDesImageName});
    ImageObj[] rgbSplit = map.get(imageName).rgbSplit();
    map.put(redDesImageName, rgbSplit[0]);
    map.put(greenDesImageName, rgbSplit[1]);
    map.put(blueDesImageName, rgbSplit[2]);
    return rgbSplit;
  }
}