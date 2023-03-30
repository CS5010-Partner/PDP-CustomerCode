package controller.newcommands;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImageAdvanced;
import view.IViewAdvanced;

/**
 * Dithering class is used to represent a class for the dithering source_image dest_image command.
 */
public class Dithering extends ACommandAdvanced {

  private final IImageAdvanced model;
  private final IViewAdvanced view;
  private final BufferedReader in;

  /**
   * Constructor for the Dithering class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    represents the input stream.
   */
  public Dithering(IImageAdvanced model, IViewAdvanced view, BufferedReader in) {
    super(model, view, in);
    this.model = model;
    this.view = view;
    this.in = in;
  }

  @Override
  public void execute()
      throws CloseCmdLineException, IOException, ImageNameAlreadyExistsException,
      ImageNotFoundException {
    String sourceName = getInput(in);
    String destName = getInput(in);
    this.model.dither(sourceName, destName);
    this.view.echoDither(false);
  }
}
