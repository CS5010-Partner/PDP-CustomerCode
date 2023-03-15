package controller.commands;

import controller.exceptions.CloseCmdLineException;
import controller.exceptions.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

/**
 * RGBSplit class is used to represent a class for the below command. RGBSplit source_image_name
 * destination_image_name1 destination_image_name2 destination_image_name3.
 */
public class RGBSplit extends ACommand {

  /**
   * Constructor for the RGBSplit class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public RGBSplit(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    String imageName = getInput(in);
    String redImg = getInput(in);
    String greenImg = getInput(in);
    String blueImg = getInput(in);
    model.rgbSplit(imageName, redImg, greenImg, blueImg);
  }
}
