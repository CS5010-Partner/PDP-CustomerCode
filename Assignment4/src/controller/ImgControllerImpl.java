package controller;

import controller.commands.ACommand;
import controller.commands.Brighten;
import controller.commands.GreyScale;
import controller.commands.HorizontalFlip;
import controller.commands.Load;
import controller.commands.RGBCombine;
import controller.commands.RGBSplit;
import controller.commands.Save;
import controller.commands.VerticalFlip;
import exceptions.CloseCmdLineException;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import model.IImage;
import view.IView;

/**
 * ImgControllerImpl is the controller class which is called from the main. It takes input from the
 * user and calls necessary classes from the model. Parses the output to the view.
 */
public class ImgControllerImpl extends Helper implements ImgController{

  private final IView view;

  protected Map<String, ACommand> cMap;
  private final IImage model;
  private BufferedReader in;
  private BufferedReader tempIn;

  /**
   * Constructor for the ImgControllerImpl class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    gives the object from where the input is read.
   */
  public ImgControllerImpl(IImage model, IView view, BufferedReader in) {
    this.model = model;
    this.view = view;
    this.in = in;
    this.tempIn = in;
    cMap = new HashMap<>();

    initCommands();
  }

  private void initCommands() {
    ACommand load = new Load(model, view, in);
    ACommand save = new Save(model, view, in);
    ACommand greyscale = new GreyScale(model, view, in);
    ACommand brighten = new Brighten(model, view, in);
    ACommand verticalFlip = new VerticalFlip(model, view, in);
    ACommand horizontalFlip = new HorizontalFlip(model, view, in);
    ACommand rgbSplit = new RGBSplit(model, view, in);
    ACommand rgbCombine = new RGBCombine(model, view, in);

    cMap.put("load", load);
    cMap.put("save", save);
    cMap.put("greyscale", greyscale);
    cMap.put("brighten", brighten);
    cMap.put("vertical-flip", verticalFlip);
    cMap.put("horizontal-flip", horizontalFlip);
    cMap.put("rgb-split", rgbSplit);
    cMap.put("rgb-combine", rgbCombine);
  }

  protected void commandExecution() {
    while (true) {
      this.view.echoGetCommand(false);
      try {
        String cmd = getInput(in);
        if (cmd.equals("run")) {
          this.view.toggleVerbose();
          String scriptPath = this.getInput(in);
          BufferedReader br = new BufferedReader(new FileReader(scriptPath));
          StringBuilder commands = new StringBuilder();
          for (String line; (line = br.readLine()) != null; ) {
            commands.append(line).append("\n");
          }
          commands.append("_run-end## ");
          br.close();

          BufferedReader overrideIn = new BufferedReader(new StringReader(commands.toString()));
          this.tempIn = this.in;
          this.in = overrideIn;
          switchHelper("run");
        } else {
          switchHelper(cmd);
        }

      } catch (CloseCmdLineException e) {
        this.view.echoCloseCmd(true);
        break;
      } catch (IOException e) {
        this.view.echoIoError(e.toString(), true);
      } catch (WrongCommandException e) {
        this.view.echoWrongCmdError(e.toString(), true);
      } catch (FileHandlingException e) {
        this.view.echoFileHandlingError(e.toString(), true);
      } catch (ImageNameAlreadyExistsException e) {
        this.view.echoImageNameAlreadyExistsError(e.toString(), true);
      } catch (ImageNotFoundException e) {
        this.view.echoImageNotFoundError(e.toString(), true);
      }
    }
  }

  private void switchHelper(String cmd)
      throws CloseCmdLineException, IOException, FileHandlingException, WrongCommandException,
      ImageNameAlreadyExistsException, ImageNotFoundException {
    if (Objects.equals(cmd, "run"))
      return;

    if (Objects.equals(cmd, "_run-end##")) {
      this.view.echoScriptSuccess(true);
      this.view.toggleVerbose();
      this.in = this.tempIn;
      return;
    }

    if (!cMap.containsKey(cmd)) {
      this.view.echoInvalidInputMsg(true);
      return;
    }
    cMap.get(cmd).execute();
  }

  public void run() {commandExecution();
  }
}
