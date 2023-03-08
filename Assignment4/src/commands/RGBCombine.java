package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class RGBCombine extends ACommand{

  public RGBCombine(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IllegalAccessException, IOException {
    String imageName = getInput(in);
    String redImg = getInput(in);
    String greenImg = getInput(in);
    String blueImg = getInput(in);
    model.rgbCombine(imageName, redImg, greenImg, blueImg);
  }
}
