package commands;

import controller.WrongCommandException;
import java.io.IOException;
import model.FileHandlingException;

public interface IImageCommand {
  void execute()
      throws IllegalAccessException, WrongCommandException, FileHandlingException, IOException;
}
