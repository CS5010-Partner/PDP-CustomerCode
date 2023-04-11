package controller.newcommands;

import exceptions.CloseCmdLineException;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import model.ImageObj;
import view.IView;

/**
 * LoadAdvanced class is used to represent a class for the below command. Load image_path
 * image_name.
 */

public class LoadAdvanced extends ACommandAdvanced {

  /**
   * Constructor for the LoadAdvanced class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public LoadAdvanced(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IllegalStateException, FileHandlingException, IOException, CloseCmdLineException,
      ImageNameAlreadyExistsException, ImageNotFoundException, WrongCommandException {
    System.out.println(in);
    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    ImageObj img = model.load(imagePathHelper(imagePath), imageName);
    view.echoLoadSuccess(img, false);
  }
}
