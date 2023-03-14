package controller.commands;

import controller.helper.CloseCmdLineException;
import controller.helper.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

/**
 * VerticalFlip class is used to represent a class for the below command. VerticalFlip
 * source_image_name destination_image_name.
 */
public class VerticalFlip extends ACommand {

  /**
   * Constructor for the VerticalFlip class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public VerticalFlip(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    String sourceName = getInput(in);
    String destName = getInput(in);
    model.verticalFlip(sourceName, destName);
  }
}
