package controller.commandsAdvanced;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImageAdvanced;
import view.IViewAdvanced;

public class Blur extends ACommandAdvanced {


  private final IImageAdvanced model;
  private final IViewAdvanced view;
  private final BufferedReader in;

  /**
   * Constructor for the ACommand class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    represents the input stream.
   */
  public Blur(IImageAdvanced model, IViewAdvanced view, BufferedReader in) {
    super(model, view, in);
    this.model = model;
    this.view = view;
    this.in = in;
  }

  @Override
  public void execute()
      throws CloseCmdLineException, IOException, ImageNameAlreadyExistsException, ImageNotFoundException {
    String sourceName = getInput(in);
    String destName = getInput(in);
    this.model.filterBlur(sourceName, destName);
    this.view.echoFilterBlurSuccess(false);
  }
}
