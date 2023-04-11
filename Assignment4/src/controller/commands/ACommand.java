package controller.commands;

import controller.Helper;
import controller.file.IFile;
import controller.file.PPMFile;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import model.IImage;
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

  /**
   * Method to dispatch the load to specific file formats.
   *
   * @param imagePath represnts the path of the image file.
   * @return the IFile object of the requested path file type.
   * @throws WrongCommandException thrown when a wrong command is called by the user.
   */
  protected IFile imagePathHelper(String imagePath) throws WrongCommandException {
    String[] fileType = imagePath.split("\\.");

    if (fileType[fileType.length - 1].equals("ppm")) {
      return new PPMFile(imagePath);
    } else {
      throw new WrongCommandException("The given file format is not supported");
    }
  }

}
