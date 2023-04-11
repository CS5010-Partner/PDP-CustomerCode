package controller.commands;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import model.ImageObj;
import view.IView;

/**
 * HorizontalFlip class is used to represent a class for the below command. HorizontalFlip
 * source_image_name destination_image_name.
 */
public class HorizontalFlip extends ACommand {

  /**
   * Constructor for the HorizontalFlip class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public HorizontalFlip(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException,
      ImageNotFoundException {
    String sourceName = getInput(in);
    String destName = getInput(in);
    ImageObj img = model.horizontalFlip(sourceName, destName);
    view.echoFlipSuccess(img,false);
  }
}
