package controller;

import helper.FileHandlingException;
import java.util.NoSuchElementException;
import model.IFile;
import model.IImage;

public class MockModel implements IImage {
  StringBuffer sb  = new StringBuffer();

  @Override
  public void load(IFile imagePath, String imageName)
      throws IllegalAccessException, FileHandlingException {
    sb.append("load | " + imagePath + " | " + imageName);

  }

  @Override
  public void save(IFile imagePath, String imageName) throws IllegalAccessException {
    sb.append("save | " + imagePath + " | " + imageName);
  }

  @Override
  public void greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("greyScaleRed | " + imageName + " | " + desImageName);
  }

  @Override
  public void greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("greyScaleGreen | " + imageName + " | " + desImageName);
  }

  @Override
  public void greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("greyScaleBlue | " + imageName + " | " + desImageName);
  }

  @Override
  public void greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("greyScaleValue | " + imageName + " | " + desImageName);
  }

  @Override
  public void greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("greyScaleIntensity | " + imageName + " | " + desImageName);
  }

  @Override
  public void greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("greyScaleLuma | " + imageName + " | " + desImageName);
  }

  @Override
  public void horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("horizontalFlip | " + imageName + " | " + desImageName);
  }

  @Override
  public void verticalFlip(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("verticalFlip | " + imageName + " | " + desImageName);
  }

  @Override
  public void brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    sb.append("brighten | " + increment + " | " + imageName + " | " + desImageName);
  }

  @Override
  public void rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName) throws NoSuchElementException, IllegalAccessException {
    sb.append("rgbSplit | " + imageName + " | " + redDesImageName + " | " + greenDesImageName + " | " + blueDesImageName);
  }

  @Override
  public void rgbCombine(String destImageName, String redImageName, String greenImageName,
      String blueImageName) throws NoSuchElementException, IllegalAccessException {
    sb.append("rgbCombine | " + destImageName + " | " + redImageName + " | " + greenImageName + " | " +blueImageName);
  }

  public String test() {
    return sb.toString();
  }
}
