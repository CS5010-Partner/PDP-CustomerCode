package commands;

import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class Load extends ACommand {

  public Load(IImage model, IView view, Scanner in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IllegalAccessException, IllegalStateException {
    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    model.load(imagePathHelper(imagePath), imageName);
  }
}
