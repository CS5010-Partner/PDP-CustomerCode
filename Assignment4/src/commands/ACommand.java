package commands;

import helper.Helper;
import java.io.BufferedReader;
import model.IFile;
import model.IImage;
import model.PPMFile;
import view.IView;

public abstract class ACommand extends Helper implements IImageCommand {

  protected final IImage model;
  protected final IView view;
  protected final BufferedReader in;

  public ACommand(IImage model, IView view, BufferedReader in) {
    this.model = model;
    this.view = view;
    this.in = in;
  }

  IFile imagePathHelper(String imagePath) {
    return new PPMFile(imagePath);
  }

}
