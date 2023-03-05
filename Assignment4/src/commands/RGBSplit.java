package commands;

import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class RGBSplit extends ACommand{

  public RGBSplit(IImage model, IView view, Scanner in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IllegalAccessException {
    String imageName = getInput(in);
    String redImg = getInput(in);
    String greenImg = getInput(in);
    String blueImg = getInput(in);
    model.rgbSplit(imageName, redImg, greenImg, blueImg);
  }
}
