package commands;

import helper.Helper;
import java.io.BufferedReader;
import model.IFile;
import model.IImage;
import model.PPMFile;
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

  protected IFile imagePathHelper(String imagePath) {
    return new PPMFile(imagePath);
  }

}
