package controller.commands;

import controller.helper.CloseCmdLineException;
import controller.helper.FileHandlingException;
import controller.helper.ImageNameAlreadyExistsException;
import controller.helper.WrongCommandException;
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
