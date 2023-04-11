package controller.newcommands;


import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImageAdvanced;
import model.ImageObj;
import view.IViewAdvanced;

/**
 * Sharpen class is used to represent a class for the below command. Sharpen source_image_name
 * destination_image_name.
 */
public class Sharpen extends ACommandAdvanced {

  private final IImageAdvanced model;
  private final IViewAdvanced view;
  private final BufferedReader in;

  /**
   * Constructor for the Sharpen class.
   *
   * @param model represents the model object.
   * @param view  represent the view object.
   * @param in    represents the input.
   */
  public Sharpen(IImageAdvanced model, IViewAdvanced view, BufferedReader in) {
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
    ImageObj img = model.filterSharpen(sourceName, destName);
    this.view.echoFilterSharpenSuccess(img,false);
  }
}
