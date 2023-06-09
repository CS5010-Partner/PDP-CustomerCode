package controller;

import controller.commands.ACommand;
import controller.newcommands.Blur;
import controller.newcommands.Dithering;
import controller.newcommands.GreyScaleAdvanced;
import controller.newcommands.Histogram;
import controller.newcommands.LoadAdvanced;
import controller.newcommands.Mosaic;
import controller.newcommands.SaveAdvanced;
import controller.newcommands.Sepia;
import controller.newcommands.Sharpen;
import java.io.BufferedReader;
import model.IImageAdvanced;
import view.IViewAdvanced;

/**
 * ImgControllerImplAdvanced is the controller class which is called from the main. It takes input
 * from the user and calls necessary classes from the model. Parses the output to the view. It is
 * written to support the newer implementation.
 */
public class ImgControllerImplAdvanced extends ImgControllerImpl {

  private final IImageAdvanced model;
  private final IViewAdvanced view;
  private final BufferedReader in;


  /**
   * Constructor for the ImgControllerImplAdvanced class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    gives the object from where the input is read.
   */
  public ImgControllerImplAdvanced(IImageAdvanced model, IViewAdvanced view, BufferedReader in) {
    super(model, view, in);
    this.model = model;
    this.view = view;
    this.in = in;
    initCommands();
  }

  private void initCommands() {
    ACommand blur = new Blur(model, view, in);
    ACommand dither = new Dithering(model, view, in);
    ACommand sepia = new Sepia(model, view, in);
    ACommand sharpen = new Sharpen(model, view, in);
    ACommand greyscale = new GreyScaleAdvanced(model, view, in);
    ACommand loadAdvanced = new LoadAdvanced(model, view, in);
    ACommand saveAdvanced = new SaveAdvanced(model, view, in);
    ACommand hist = new Histogram(model, view, in);
    ACommand mosaic = new Mosaic(model, view, in);

    super.cMap.put("blur", blur);
    super.cMap.put("dither", dither);
    super.cMap.put("sepia", sepia);
    super.cMap.put("sharpen", sharpen);
    super.cMap.put("greyscale", greyscale);
    super.cMap.put("load", loadAdvanced);
    super.cMap.put("save", saveAdvanced);
    super.cMap.put("histogram", hist);
    super.cMap.put("mosaic", mosaic);
  }

  @Override
  public void run() {
    super.commandExecution();
  }
}
