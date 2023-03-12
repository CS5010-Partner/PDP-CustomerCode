package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import helper.WrongCommandException;
import java.io.IOException;
import helper.FileHandlingException;

public interface IImageCommand {
  void execute()
      throws WrongCommandException, FileHandlingException, IOException, CloseCmdLineException, ImageNameAlreadyExistsException;
}
