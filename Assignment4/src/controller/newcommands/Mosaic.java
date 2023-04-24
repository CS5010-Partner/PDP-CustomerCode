package controller.newcommands;

import exceptions.CloseCmdLineException;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import model.IImageAdvanced;
import model.ImageObj;
import view.IViewAdvanced;

public class Mosaic extends ACommandAdvanced {

  private final IImageAdvanced model;
  private final IViewAdvanced view;
  private final BufferedReader in;

  /**
   * Constructor for the ACommandAdvanced class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    represents the input stream.
   */
  public Mosaic(IImageAdvanced model, IViewAdvanced view, BufferedReader in) {
    super(model, view, in);
    this.model = model;
    this.view = view;
    this.in = in;
  }

  @Override
  public void execute()
      throws WrongCommandException, FileHandlingException, IOException, CloseCmdLineException,
      ImageNameAlreadyExistsException, ImageNotFoundException {
    int seedValue;
    while (true) {
      try {
        String increment = getInput(in);
        seedValue = Integer.parseInt(increment);
        break;
      } catch (NumberFormatException | IOException e) {
        System.out.println("Please Enter A Valid Integer");
      }
    }
    String sourceName = getInput(in);
    String destName = getInput(in);
    ImageObj img = this.model.mosaic( sourceName, destName, seedValue);
    this.view.echoMosaicSuccess(img, false);


  }
}
