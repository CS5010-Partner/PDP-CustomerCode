package controller;

import java.io.BufferedReader;
import model.IImageAdvanced;
import view.IViewAdvanced;

public class ImgControllerImplScript extends ImgControllerImplAdvanced {

  private IViewAdvanced view;
  private final IImageAdvanced model;
  private String filePath;
  private CustomSystemIn in = new CustomSystemIn();


  /**
   * Constructor for the ImgControllerImplAdvanced class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    gives the object from where the input is read.
   */
  public ImgControllerImplScript(IImageAdvanced model, IViewAdvanced view,
      BufferedReader in, String[] args) {
    super(model, view, in);
    this.view = view;
    this.model = model;
    this.filePath = args[1];
  }

  private void actionHelper() {
    String cmd = "run ";
    cmd += this.filePath;
    cmd += " ";
    cmd += "\n#\n";
    System.out.println(cmd);
    in.addInput(cmd);
    super.commandExecution();
  }

  @Override
  public void run() {
    actionHelper();
  }

}
