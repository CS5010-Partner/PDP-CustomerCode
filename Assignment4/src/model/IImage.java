package model;

import helper.FileHandlingException;
import helper.ImageNameAlreadyExistsException;
import java.util.NoSuchElementException;

public interface IImage {
  ImageObj load(IFile imagePath,String imageName)
      throws FileHandlingException, ImageNameAlreadyExistsException;
  ImageObj save(IFile imagePath,String imageName)
      throws ImageNameAlreadyExistsException;
  ImageObj greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;

  ImageObj horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj verticalFlip(String imageName,String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj[] rgbSplit(String imageName, String redDesImageName, String greenDesImageName, String blueDesImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;
  ImageObj rgbCombine(String destImageName, String redImageName, String greenImageName, String blueImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException;

}


// 10 methods impl
//public sb
//sb.append(nameoffunctioncalled)
//unit test return sb
