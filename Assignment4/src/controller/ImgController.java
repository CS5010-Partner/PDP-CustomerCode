package controller;

import exceptions.CloseCmdLineException;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.IOException;

/**
 * This interface represents the methods which are implemented in the controller.
 */
public interface ImgController {

  /**
   * This method when called from the main class takes input from the user.
   */
  void run();
}
