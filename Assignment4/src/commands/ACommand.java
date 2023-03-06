package commands;

import java.io.InputStream;
import java.util.Scanner;
import model.IFile;
import model.IImage;
import model.PPMFile;
import view.IView;

public abstract class ACommand implements IImageCommand {

  protected final IImage model;
  protected final IView view;
  protected final Scanner in;

  public ACommand(IImage model, IView view, Scanner in) {
    this.model = model;
    this.view = view;
    this.in = in;
  }

  IFile imagePathHelper(String imagePath) {
    return new PPMFile(imagePath);
  }

  protected String getInput(Scanner sc) throws IllegalStateException {
    String input = sc.next();
    if (input.equals("#")) {
      throw new IllegalStateException("Quit command has been entered.");
    }
    return input;
  }
}
