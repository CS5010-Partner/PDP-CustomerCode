package controller.commands;

import controller.Helper;
import exceptions.CloseCmdLineException;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import controller.file.IFile;
import java.io.IOException;
import model.IImage;
import controller.file.PPMFile;
import view.IView;

/**
 * ACommand is an abstract class that implements the IImageCommand interface. This class is written
 * to implement the methods which are common to all the command classes.
 */
public abstract class ACommand extends Helper implements IImageCommand {

  protected final IImage model;
  protected final IView view;
  protected final BufferedReader in;

  /**
   * Constructor for the ACommand class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    represents the input stream.
   */
  public ACommand(IImage model, IView view, BufferedReader in) {
    this.model = model;
    this.view = view;
    this.in = in;
  }

  protected IFile imagePathHelper(String imagePath) throws WrongCommandException {
    String[] fileType = imagePath.split("\\.");

    if (fileType[fileType.length - 1].equals("ppm"))
      return new PPMFile(imagePath);
    else
      throw new WrongCommandException("The given file format is not supported");
  }

  public void execute() throws WrongCommandException, CloseCmdLineException,
      ImageNameAlreadyExistsException, IOException, ImageNotFoundException, FileHandlingException {}
}
