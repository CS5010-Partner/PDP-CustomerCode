package controller.newcommands;

import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImageAdvanced;
import model.ImageObj;
import view.IViewAdvanced;

public class Histogram extends ACommandAdvanced {

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
  public Histogram(IImageAdvanced model, IViewAdvanced view, BufferedReader in) {
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
    String redHistName = getInput(in);
    String greenHistName = getInput(in);
    String blueHistName = getInput(in);
    String intHistName = getInput(in);

    ImageObj[] imgs = this.model.histogram(sourceName, redHistName, greenHistName, blueHistName, intHistName);
    this.view.echoHistogramSuccess(imgs,false);
  }
}
