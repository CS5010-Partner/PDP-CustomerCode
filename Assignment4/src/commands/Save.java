package commands;

import helper.CloseCmdLineException;
import helper.ImageNameAlreadyExistsException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;
/**
 * Save class is used to represent a class for the below command.
 * Save image_path image_name.
 */
public class Save extends ACommand{

  /**
   * Constructor for the Save class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public Save(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException {
    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    model.save(imagePathHelper(imagePath), imageName);
  }
}
