package model;

import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import controller.file.IFile;

/**
 * IImage represents the model interface and the methods that are required for the model.
 */
public interface IImage {

  /**
   * loads the image from the specified path to the given name.
   *
   * @param imagePath path of file
   * @param imageName image name
   * @return ImageObj of the loaded image
   * @throws FileHandlingException           thrown when there is no file in the given path.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj load(IFile imagePath, String imageName)
      throws FileHandlingException, ImageNameAlreadyExistsException, ImageNotFoundException, IOException;

  /**
   * saves the given imagename to the specified imagepath.
   *
   * @param imagePath path of file
   * @param imageName image name
   * @return ImageObj of the saved image.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   * @throws NoSuchElementException throws when an image under the name does not exists.
   * @throws FileHandlingException thrown when there is no such directory exists.
   */
  ImageObj save(IFile imagePath, String imageName)
      throws ImageNameAlreadyExistsException, NoSuchElementException, FileHandlingException,
      ImageNotFoundException;

  /**
   * Converts the image to the grey scale red image.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Converts the image to the grey scale green image.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Converts the image to the grey scale blue image.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Converts the image to the grey scale value image.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Converts the image to the grey scale intensity image.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Converts the image to the grey scale luma image.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Flips the image horizontally.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Flips the image vertically.
   *
   * @param imageName    image name.
   * @param desImageName name of the converted image.
   * @return the converted image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj verticalFlip(String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Brightens the image by the increment factor given by the user.
   *
   * @param increment    the increment factor which can be negative or positive.
   * @param imageName    the image name on which image brightening is done.
   * @param desImageName the destination name of the changed image.
   * @return the ImageObj of the changed image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException, ImageNameAlreadyExistsException, ImageNotFoundException;

  /**
   * Splits the image into seperate red, green and blue grey components.
   *
   * @param imageName         the name of the image on which the transformation is done.
   * @param redDesImageName   name of the grey red image.
   * @param greenDesImageName name of the grey green image.
   * @param blueDesImageName  name of the grey blue image.
   * @return an array of changed images.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj[] rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName) throws NoSuchElementException, ImageNameAlreadyExistsException,
      ImageNotFoundException;

  /**
   * Combines the three components into one image.
   *
   * @param destImageName  the image in which the combined image is stored.
   * @param redImageName   name of the grey red image.
   * @param greenImageName name of the grey green image.
   * @param blueImageName  name of the grey blue image.
   * @return the ImageObj of the transformed image.
   * @throws NoSuchElementException          thrown when there is no image of that name.
   * @throws ImageNameAlreadyExistsException thrown when an image name already exists.
   */
  ImageObj rgbCombine(String destImageName, String redImageName, String greenImageName,
      String blueImageName) throws NoSuchElementException, ImageNameAlreadyExistsException,
      ImageNotFoundException;
}

