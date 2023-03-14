package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import helper.FileHandlingException;
import model.IImage;
import view.IView;

public class Load extends ACommand {

  public Load(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IllegalStateException, FileHandlingException, IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    model.load(imagePathHelper(imagePath), imageName);
  }
}