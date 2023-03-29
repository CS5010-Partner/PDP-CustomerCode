package controller.commandsAdvanced;

import exceptions.CloseCmdLineException;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import view.IView;

public class SaveAdvanced extends ACommandAdvanced {

  /**
   * Constructor for the ACommand class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    represents the input stream.
   */
  public SaveAdvanced(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  public void execute()
      throws IOException, CloseCmdLineException, ImageNameAlreadyExistsException,
      FileHandlingException, ImageNotFoundException, WrongCommandException {
    String imagePath = this.getInput(in);
    String imageName = this.getInput(in);
    model.save(imagePathHelper(imagePath), imageName);
    view.echoSaveSuccess(false);
  }
}
