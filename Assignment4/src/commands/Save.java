package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

public class Save extends ACommand{

  public Save(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    model.save(imagePathHelper(imagePath), imageName);
  }
}
