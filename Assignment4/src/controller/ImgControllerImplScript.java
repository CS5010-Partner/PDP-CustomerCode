package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.IImageAdvanced;
import view.IViewAdvanced;

public class ImgControllerImplScript extends ImgControllerImplAdvanced {

  private IViewAdvanced view;
  private final IImageAdvanced model;
  private String filePath;
  private CustomSystemIn in = new CustomSystemIn();
  private BufferedReader origIn;


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
    this.origIn = in;
  }

  private void actionHelper() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(this.filePath));
      StringBuilder commands = new StringBuilder();
      for (String line; (line = br.readLine()) != null; ) {
        commands.append(line).append(" \n");
      }
      in.addInput(commands.toString());
      super.commandExecution();
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found!");
    } catch (IOException e) {
      System.out.println("File not found!");
    }

  }

  @Override
  public void run() {
    actionHelper();
  }

}
