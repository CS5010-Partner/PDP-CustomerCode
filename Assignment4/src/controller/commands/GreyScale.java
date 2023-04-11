package controller.commands;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import model.ImageObj;
import view.IView;

/**
 * GreyScale class is used to represent a class for the below command. GreyScale component
 * source_image_name destination_image_name.
 */
public class GreyScale extends ACommand {

  /**
   * Constructor for the GreyScale class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public GreyScale(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws WrongCommandException, CloseCmdLineException,
      ImageNameAlreadyExistsException, IOException, ImageNotFoundException {
    String value = getInput(in).toLowerCase();
    String sourceName = getInput(in);
    String destName = getInput(in);
    ImageObj img;

    switch (value.toLowerCase()) {
      case "red":
        img = model.greyScaleRed(sourceName, destName);
        break;

      case "green":
        img = model.greyScaleGreen(sourceName, destName);
        break;

      case "blue":
        img = model.greyScaleBlue(sourceName, destName);
        break;

      case "value":
        img = model.greyScaleValue(sourceName, destName);
        break;

      case "intensity":
        img = model.greyScaleIntensity(sourceName, destName);
        break;

      case "luma":
        img = model.greyScaleLuma(sourceName, destName);
        break;

      default:
        throw new WrongCommandException("Please enter a valid metric for greyscale conversion.");
    }
    view.echoGreyscaleSuccess(img, false);


  }
}
