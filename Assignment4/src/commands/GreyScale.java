package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import helper.WrongCommandException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
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
      throws WrongCommandException, IOException, CloseCmdLineException,
      ImageNameAlreadyExistsException {
    String value = getInput(in).toLowerCase();
    String sourceName = getInput(in);
    String destName = getInput(in);

    switch (value.toLowerCase()) {
      case "red":
        model.greyScaleRed(sourceName, destName);
        break;

      case "green":
        model.greyScaleGreen(sourceName, destName);
        break;

      case "blue":
        model.greyScaleBlue(sourceName, destName);
        break;

      case "value":
        model.greyScaleValue(sourceName, destName);
        break;

      case "intensity":
        model.greyScaleIntensity(sourceName, destName);
        break;

      case "luma":
        model.greyScaleLuma(sourceName, destName);
        break;

      default:
        throw new WrongCommandException("Please enter a valid metric for greyscale conversion.");
    }
  }
}
