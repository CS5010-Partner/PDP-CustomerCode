package controller;

import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import model.IImageAdvanced;
import model.ImageObj;

/**
 * This class acts as a new mock implementation to the model class.
 */
public class MockModelAdvanced extends MockModel implements IImageAdvanced {

  @Override
  public ImageObj filterBlur(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("filterBlur | " + imageName + " | " + destImageName + "\n");
    return null;
  }

  @Override
  public ImageObj filterSharpen(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("filterSharpen | " + imageName + " | " + destImageName + "\n");
    return null;
  }

  @Override
  public ImageObj transformGreyScale(String param1, String param2)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("transformGreyScale | " + param1 + " | " + param2 + "\n");
    return null;
  }

  @Override
  public ImageObj transformSepia(String sourceName, String destName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("transformSepia | " + sourceName + " | " + destName + "\n");

    return null;
  }

  @Override
  public ImageObj dither(String sourceName, String destName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("dither | " + sourceName + " | " + destName + "\n");
    return null;
  }

  @Override
  public ImageObj[] histogram(String sourceName, String redHistImgName, String blueHistImgName,
      String greenHistImgname, String intHistImgName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("dither | " + sourceName + " | " + redHistImgName + " | " + greenHistImgname
       + " | " + blueHistImgName + " | " + intHistImgName + "\n");
    return null;
  }

  /**
   * mosaic form of the source image and store as the desination image name.
   *
   * @param sourceName source image name.
   * @param destName   destination image name.
   * @param seedValue  How many seeds to use for mosaic operation.
   * @return the image object of the mosaic image.
   */
  @Override
  public ImageObj mosaic(String sourceName, String destName, int seedValue)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("mosaic | ").append(seedValue).append(" | ").append(sourceName).append(" | ")
        .append(destName).append("\n");
    return null;
  }
}
