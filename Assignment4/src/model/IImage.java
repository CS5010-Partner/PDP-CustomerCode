package model;

import helper.FileHandlingException;
import helper.ImageNameAlreadyExistsException;
import java.util.NoSuchElementException;

public interface IImage {
  void load(IFile imagePath,String imageName)
      throws FileHandlingException, ImageNameAlreadyExistsException;
  void save(IFile imagePath,String imageName)
      throws ImageNameAlreadyExistsException;
  void greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;

  void horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void verticalFlip(String imageName,String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void rgbSplit(String imageName, String redDesImageName, String greenDesImageName, String blueDesImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  void rgbCombine(String destImageName, String redImageName, String greenImageName, String blueImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;

}


// 10 methods impl
//public sb
//sb.append(nameoffunctioncalled)
//unit test return sb
