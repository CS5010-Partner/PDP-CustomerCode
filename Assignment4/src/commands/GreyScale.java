package commands;

import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class GreyScale extends ACommand{

  public GreyScale(IImage model, IView view, Scanner in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IllegalAccessException {
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
        System.out.println("Please Enter the Command Again");
    }
  }
}
