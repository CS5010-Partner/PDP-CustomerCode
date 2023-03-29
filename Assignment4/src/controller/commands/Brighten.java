package controller.commands;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

/**
 * Brighten class is used to represent a class for the brightened value source_image dest_image
 * command.
 */
public class Brighten extends ACommand {

  /**
   * Constructor for the Brightened class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public Brighten(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException,
      ImageNotFoundException {
    int incrementValue;
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
    view.echoBrightenSuccess(false);

  }
}
