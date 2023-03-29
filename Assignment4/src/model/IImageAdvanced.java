package model;

import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;

public interface IImageAdvanced extends IImage {
  ImageObj filterBlur(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  ImageObj filterSharpen(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  ImageObj transformGreyScale(String param1, String param2) throws ImageNameAlreadyExistsException, ImageNotFoundException;

  ImageObj transformSepia(String sourceName, String destName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  ImageObj dither(String sourceName, String destName) throws ImageNameAlreadyExistsException, ImageNotFoundException;
}
