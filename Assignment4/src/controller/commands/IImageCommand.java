package controller.commands;

import exceptions.CloseCmdLineException;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.WrongCommandException;
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
