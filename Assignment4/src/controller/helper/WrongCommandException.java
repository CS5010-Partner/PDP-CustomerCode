package controller.helper;

/**
 * WrongCommandException is thrown when there is no valid command exists for the current given
 * command.
 */
public class WrongCommandException extends Exception {

  /**
   * Represents the constructor for the WrongCommandException class.
   *
   * @param errorMessage the message to be shown to the user when there the exception is raised.
   */
  public WrongCommandException(String errorMessage) {
    super(errorMessage);
  }

}
