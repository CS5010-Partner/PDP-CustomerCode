package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class VerticalFlip extends ACommand{

  public VerticalFlip(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IllegalAccessException, IOException {
    String sourceName = getInput(in);
    String destName = getInput(in);
    model.verticalFlip(sourceName, destName);
  }
}
