package model;

import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;

/**
 * IImageAdvanced represents the model interface and the methods that are required for the newer
 * model.
 */
public interface IImageAdvanced extends IImage {

  /**
   * blurs the source imageName and names it as the destination image name.
   *
   * @param imageName     source image name.
   * @param destImageName destination image name.
   * @return ImageObj of the blur image.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   * @throws ImageNotFoundException          thrown when the image is not found.
   */
  ImageObj filterBlur(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * sharpens the source imageName and names it as the destination image name.
   *
   * @param imageName     source image name.
   * @param destImageName destination image name.
   * @return ImageObj of the sharpen image.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   * @throws ImageNotFoundException          thrown when the image is not found.
   */
  ImageObj filterSharpen(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * transforms the source image to the greyscale image.
   *
   * @param param1 source image name
   * @param param2 destination image name
   * @return ImageObj of the greyscale image
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   * @throws ImageNotFoundException          thrown when the image is not found.
   */
  ImageObj transformGreyScale(String param1, String param2)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * sepia form of the source image and stored as the destination image name.
   *
   * @param sourceName source image name.
   * @param destName   destination image name.
   * @return ImageObj of the sepia image.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   * @throws ImageNotFoundException          thrown when the image is not found.
   */
  ImageObj transformSepia(String sourceName, String destName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * dither form of the source image and stored as the destination image name.
   *
   * @param sourceName source image name.
   * @param destName   destination image name.
   * @return ImageObj of the dithered image.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   * @throws ImageNotFoundException          thrown when the image is not found.
   */
  ImageObj dither(String sourceName, String destName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException;
}
