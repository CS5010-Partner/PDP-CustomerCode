package controller;

import controller.file.IFile;
import java.util.NoSuchElementException;
import model.IImage;
import model.ImageObj;

/**
 * This class acts as a mock implementation to the model class.
 */
public class MockModel implements IImage {

  protected StringBuffer sb = new StringBuffer();

  @Override
  public String toString() {
    if (sb == null) {
      return "";
    }
    return sb.toString();
  }

  @Override
  public ImageObj load(IFile imagePath, String imageName) {
    sb.append("load | " + imagePath.toString() + " | " + imageName + "\n");
    return null;
  }

  @Override
  public ImageObj save(IFile imagePath, String imageName) {
    sb.append("save | " + imagePath.toString() + " | " + imageName + "\n");
    return null;
  }

  @Override
  public ImageObj greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleRed | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleGreen | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleBlue | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleValue | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleIntensity | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleLuma | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("horizontalFlip | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj verticalFlip(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("verticalFlip | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("brighten | " + increment + " | " + imageName + " | " + desImageName + "\n");
    return null;
  }

  @Override
  public ImageObj[] rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName) throws NoSuchElementException {
    sb.append(
        "rgbSplit | " + imageName + " | " + redDesImageName + " | " + greenDesImageName + " | "
            + blueDesImageName + "\n");
    return null;
  }

  @Override
  public ImageObj rgbCombine(String destImageName, String redImageName, String greenImageName,
      String blueImageName) throws NoSuchElementException {
    sb.append(
        "rgbCombine | " + destImageName + " | " + redImageName + " | " + greenImageName + " " + "| "
            + blueImageName + "\n");
    return null;
  }
}
