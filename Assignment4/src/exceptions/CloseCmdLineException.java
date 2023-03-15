package exceptions;

/**
 * Terminates the program when there is a CloseCmdLineException.
 */
public class CloseCmdLineException extends Exception {

  /**
   * Represents the constructor for the CloseCmdLineException class.
   *
   * @param errorMessage the message to be shown to the user when there the exception is raised.
   */
  public CloseCmdLineException(String errorMessage) {
    super(errorMessage);
  }
}
