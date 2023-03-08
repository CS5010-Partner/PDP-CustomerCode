package commands;

import helper.CloseCmdLineException;
import helper.WrongCommandException;
import java.io.IOException;
import helper.FileHandlingException;

public interface IImageCommand {
  void execute()
      throws IllegalAccessException, WrongCommandException, FileHandlingException, IOException, CloseCmdLineException;
}
