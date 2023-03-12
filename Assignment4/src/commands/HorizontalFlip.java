package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

public class HorizontalFlip extends ACommand{

  public HorizontalFlip(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    String sourceName = getInput(in);
    String destName = getInput(in);
    model.horizontalFlip(sourceName, destName);
  }
}
