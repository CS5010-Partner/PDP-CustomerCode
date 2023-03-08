package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import model.IImage;
import view.IView;

public class Save extends ACommand{

  public Save(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute() throws IllegalAccessException, IOException {

    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    model.save(imagePathHelper(imagePath), imageName);
  }
}
