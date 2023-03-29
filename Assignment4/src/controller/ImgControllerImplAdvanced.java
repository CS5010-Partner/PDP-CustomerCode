package controller;

import controller.commands.ACommand;
import controller.commands.Load;
import controller.commandsAdvanced.Blur;
import controller.commandsAdvanced.Dithering;
import controller.commandsAdvanced.GreyScaleAdvanced;
import controller.commandsAdvanced.Sepia;
import controller.commandsAdvanced.Sharpen;
import java.io.BufferedReader;
import model.IImage;
import model.IImageAdvanced;
import view.IView;
import view.IViewAdvanced;

public class ImgControllerImplAdvanced extends ImgControllerImpl {

  private IImageAdvanced model;
  private IViewAdvanced view;
  private BufferedReader in;


  /**
   * Constructor for the ImgControllerImpl class.
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
  }

  private void initCommands() {
    ACommand blur = new Blur(model, view, in);
    ACommand dither = new Dithering(model, view, in);
    ACommand sepia = new Sepia(model, view, in);
    ACommand sharpen = new Sharpen(model, view, in);
    ACommand greyscale = new GreyScaleAdvanced(model, view, in);

    super.cMap.put("blur", blur);
    super.cMap.put("dither", dither);
    super.cMap.put("sepia", sepia);
    super.cMap.put("sharpen", sharpen);
    super.cMap.put("greyscale", greyscale);
  }
  @Override
  public void run() {
    initCommands();
    super.commandExecution();
  }
}
