package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

/**
 * Brighten class is used to represent a class for the brighten value source_image dest_image
 * command.
 */
public class Brighten extends ACommand {

  /**
   * Constructor for the Brighten class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public Brighten(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    int incrementValue = 0;
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
