package controller.commands;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

/**
 * RGBCombine class is used to represent a class for the below command. RGBCombine
 * destination_image_name source_image_name1 source_image_name2 source_image_name3.
 */
public class RGBCombine extends ACommand {

  /**
   * Constructor for the RGBCombine class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public RGBCombine(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    String imageName = getInput(in);
    String redImg = getInput(in);
    String greenImg = getInput(in);
    String blueImg = getInput(in);
    model.rgbCombine(imageName, redImg, greenImg, blueImg);
  }
}
