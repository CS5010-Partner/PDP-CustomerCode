package model;

import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;

public interface IImageAdvanced extends IImage {
  ImageObj filterBlur(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  ImageObj filterSharpen(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;
}
