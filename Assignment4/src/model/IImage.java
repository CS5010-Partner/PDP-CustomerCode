package model;

import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;

public interface IImage {
  void load(IFile imagePath,String imageName) throws IllegalAccessException, FileHandlingException;
  void save(IFile imagePath,String imageName) throws IllegalAccessException;
  void greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException;
  void greyScaleGreen(String imageName, String desImageName) throws NoSuchElementException, IllegalAccessException;
  void greyScaleBlue(String imageName, String desImageName) throws NoSuchElementException, IllegalAccessException;
  void greyScaleValue(String imageName, String desImageName) throws NoSuchElementException, IllegalAccessException;
  void greyScaleIntensity(String imageName, String desImageName) throws NoSuchElementException, IllegalAccessException;
  void greyScaleLuma(String imageName, String desImageName) throws NoSuchElementException, IllegalAccessException;

  void horizontalFlip(String imageName, String desImageName) throws NoSuchElementException, IllegalAccessException;
  void verticalFlip(String imageName,String desImageName) throws NoSuchElementException, IllegalAccessException;
  void brighten(int increment, String imageName, String desImageName) throws NoSuchElementException, IllegalAccessException;
  void rgbSplit(String imageName, String redDesImageName, String greenDesImageName, String blueDesImageName) throws NoSuchElementException, IllegalAccessException;
  void rgbCombine(String destImageName, String redImageName, String greenImageName, String blueImageName) throws NoSuchElementException, IllegalAccessException;

}


// 10 methods impl
//public sb
//sb.append(nameoffunctioncalled)
//unit test return sb
