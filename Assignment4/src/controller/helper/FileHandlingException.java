package controller.helper;

/**
 * FileHandling exception is thrown when there is no file at the specified location.
 */
public class FileHandlingException extends Exception{

  /**
   * Represents the constructor for the FileHandlingException class.
   * @param errorMessage the message to be shown to the user when there the exception is raised.
   */
  public FileHandlingException(String errorMessage) {
    super(errorMessage);
  }

}
