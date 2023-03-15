package controller.commands;

import controller.exceptions.CloseCmdLineException;
import controller.exceptions.FileHandlingException;
import controller.exceptions.ImageNameAlreadyExistsException;
import controller.exceptions.WrongCommandException;
import java.io.IOException;

/**
 * IImageCommand is an interface which represents the methods that needs to be implemented by the
 * command classes which implement this method.
 */
public interface IImageCommand {

  void execute()
      throws WrongCommandException, FileHandlingException, IOException, CloseCmdLineException,
      ImageNameAlreadyExistsException;
}
