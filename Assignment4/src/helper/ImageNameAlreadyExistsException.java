package helper;

/**
 * ImageNameAlreadyExistsException class throws an exception if the image name already exists.
 */
public class ImageNameAlreadyExistsException extends Exception{
  /**
   * Represents the constructor for the ImageNameAlreadyExistsException class.
   * @param errorMessage the message to be shown to the user when there the exception is raised.
   */
  public ImageNameAlreadyExistsException(String errorMessage) {
    super(errorMessage);
  }

}
