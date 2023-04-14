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
    sb.append("load | ").append(imagePath.toString()).append(" | ").append(imageName).append("\n");
    return null;
  }

  @Override
  public ImageObj save(IFile imagePath, String imageName) {
    sb.append("save | ").append(imagePath.toString()).append(" | ").append(imageName).append("\n");
    return null;
  }

  @Override
  public ImageObj greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleRed | ").append(imageName).append(" | ").append(desImageName).append("\n");
    return null;
  }

  @Override
  public ImageObj greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleGreen | ").append(imageName).append(" | ").append(desImageName)
        .append("\n");
    return null;
  }

  @Override
  public ImageObj greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleBlue | ").append(imageName).append(" | ").append(desImageName).append("\n");
    return null;
  }

  @Override
  public ImageObj greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleValue | ").append(imageName).append(" | ").append(desImageName)
        .append("\n");
    return null;
  }

  @Override
  public ImageObj greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleIntensity | ").append(imageName).append(" | ").append(desImageName)
        .append("\n");
    return null;
  }

  @Override
  public ImageObj greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("greyScaleLuma | ").append(imageName).append(" | ").append(desImageName).append("\n");
    return null;
  }

  @Override
  public ImageObj horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("horizontalFlip | ").append(imageName).append(" | ").append(desImageName)
        .append("\n");
    return null;
  }

  @Override
  public ImageObj verticalFlip(String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("verticalFlip | ").append(imageName).append(" | ").append(desImageName).append("\n");
    return null;
  }

  @Override
  public ImageObj brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException {
    sb.append("brighten | ").append(increment).append(" | ").append(imageName).append(" | ")
        .append(desImageName).append("\n");
    return null;
  }

  @Override
  public ImageObj[] rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName) throws NoSuchElementException {
    sb.append("rgbSplit | ").append(imageName).append(" | ").append(redDesImageName).append(" | ")
        .append(greenDesImageName).append(" | ").append(blueDesImageName).append("\n");
    return null;
  }

  @Override
  public ImageObj rgbCombine(String destImageName, String redImageName, String greenImageName,
      String blueImageName) throws NoSuchElementException {
    sb.append("rgbCombine | ").append(destImageName).append(" | ").append(redImageName)
        .append(" | ").append(greenImageName).append(" ").append("| ").append(blueImageName)
        .append("\n");
    return null;
  }
}
