package controller.commandsAdvanced;


import controller.commands.ACommand;
import exceptions.CloseCmdLineException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import model.IImageAdvanced;
import view.IViewAdvanced;

public class Sharpen extends ACommand {

  private IImageAdvanced model;
  private IViewAdvanced view;
  private BufferedReader in;

  public Sharpen(IImageAdvanced model, IViewAdvanced view, BufferedReader in) {
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
    this.model.filterSharpen(sourceName, destName);
    this.view.echoFilterSharpenSuccess(false);
  }
}
