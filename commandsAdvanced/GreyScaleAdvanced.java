package controller.commandsAdvanced;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImageAdvanced;
import view.IView;

/**
 * GreyScaleAdvanced class is used to represent a class for the below command. GreyScale component
 * source_image_name destination_image_name and also GrayScale path value.
 */
public class GreyScaleAdvanced extends ACommandAdvanced {

  private final IImageAdvanced model;
  private final IView view;
  private final BufferedReader in;

  /**
   * Constructor for the GreyScaleAdvanced class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public GreyScaleAdvanced(IImageAdvanced model, IView view, BufferedReader in) {
    super(model, view, in);
    this.model = model;
    this.view = view;
    this.in = in;
  }

  @Override
  public void execute()
      throws WrongCommandException, CloseCmdLineException, ImageNameAlreadyExistsException,
      IOException, ImageNotFoundException {
    String param1 = getInput(in);
    String param2 = getInput(in);
    String param3;

    switch (param1.toLowerCase()) {
      case "red":
        param3 = getInput(in);
        this.model.greyScaleRed(param2, param3);
        break;

      case "green":
        param3 = getInput(in);
        this.model.greyScaleGreen(param2, param3);
        break;

      case "blue":
        param3 = getInput(in);
        this.model.greyScaleBlue(param2, param3);
        break;

      case "value":
        param3 = getInput(in);
        this.model.greyScaleValue(param2, param3);
        break;

      case "intensity":
        param3 = getInput(in);
        this.model.greyScaleIntensity(param2, param3);
        break;

      case "luma":
        param3 = getInput(in);
        this.model.greyScaleLuma(param2, param3);
        break;

      default:
        this.model.transformGreyScale(param1, param2);
    }
    this.view.echoGreyscaleSuccess(false);
  }
}