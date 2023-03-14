package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class Brighten extends ACommand{

  public Brighten(IImage model, IView view,
      BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    int incrementValue=0;
    while (true) {
      try {
        String increment = getInput(in);
        incrementValue = Integer.parseInt(increment);
        break;
      } catch (NumberFormatException | IOException e) {
        System.out.println("Please Enter A Valid Integer");
      }
    }
    String sourceName = getInput(in);
    String destName = getInput(in);
    model.brighten(incrementValue, sourceName, destName);
  }
}