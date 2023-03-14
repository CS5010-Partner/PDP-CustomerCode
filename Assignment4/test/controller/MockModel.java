package controller;

import java.util.NoSuchElementException;
import model.IFile;
import model.IImage;
import model.ImageObj;

public class MockModel implements IImage {
  private StringBuffer sb;

  @Override
  public String toString() {
    if (sb == null) {
      return "";
    }
    return sb.toString();
  }

  @Override
  public ImageObj load(IFile imagePath, String imageName) {
    sb = new StringBuffer();
    sb.append("load | " + imagePath.toString() + " | " + imageName);
    return null;
  }

  @Override
  public ImageObj save(IFile imagePath, String imageName) {
    sb = new StringBuffer();
    sb.append("save | " + imagePath + " | " + imageName);
    return null;
  }

  @Override
  public ImageObj greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("greyScaleRed | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("greyScaleGreen | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("greyScaleBlue | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("greyScaleValue | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("greyScaleIntensity | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("greyScaleLuma | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("horizontalFlip | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj verticalFlip(String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("verticalFlip | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("brighten | " + increment + " | " + imageName + " | " + desImageName);
    return null;
  }

  @Override
  public ImageObj[] rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName) throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("rgbSplit | " + imageName + " | " + redDesImageName + " | " + greenDesImageName + " | " + blueDesImageName);
    return null;
  }

  @Override
  public ImageObj rgbCombine(String destImageName, String redImageName, String greenImageName,
      String blueImageName) throws NoSuchElementException {
    sb = new StringBuffer();
    sb.append("rgbCombine | " + destImageName + " | " + redImageName + " | " + greenImageName + " | " +blueImageName);
    return null;
  }
}
