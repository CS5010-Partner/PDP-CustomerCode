package commands;

import helper.CloseCmdLineException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class RGBSplit extends ACommand{

  public RGBSplit(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IllegalAccessException, IOException, CloseCmdLineException {
    String imageName = getInput(in);
    String redImg = getInput(in);
    String greenImg = getInput(in);
    String blueImg = getInput(in);
    model.rgbSplit(imageName, redImg, greenImg, blueImg);
  }
}
