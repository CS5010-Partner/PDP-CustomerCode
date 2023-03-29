package controller.commandsAdvanced;

import controller.commands.ACommand;
import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImage;
import model.IImageAdvanced;
import view.IView;
import view.IViewAdvanced;

public class Blur extends ACommand {

  /**
   * Constructor for the ACommand class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    represents the input stream.
   */
  private IImageAdvanced model;
  private IViewAdvanced view;
  private BufferedReader in;

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
