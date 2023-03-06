package commands;

import controller.WrongCommandException;
import model.FileHandlingException;

public interface IImageCommand {
  void execute() throws IllegalAccessException, WrongCommandException, FileHandlingException;
}
