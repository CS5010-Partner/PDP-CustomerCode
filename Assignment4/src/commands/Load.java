package commands;

import java.io.BufferedReader;
import java.io.IOException;
import model.FileHandlingException;
import model.IImage;
import view.IView;

public class Load extends ACommand {

  public Load(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IllegalAccessException, IllegalStateException, FileHandlingException, IOException {
    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    model.load(imagePathHelper(imagePath), imageName);
  }
}
