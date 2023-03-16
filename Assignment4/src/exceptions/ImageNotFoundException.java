package exceptions;

/**
 * ImageNotFoundException class throws an exception if the image name not found.
 */
public class ImageNotFoundException extends Exception{
  /**
   * Represents the constructor for the ImageNotFoundException class.
   *
   * @param errorMessage the message to be shown to the user when there the exception is raised.
   */
  public ImageNotFoundException(String errorMessage) {
    super(errorMessage);
  }

}
