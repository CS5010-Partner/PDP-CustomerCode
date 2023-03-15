package controller;

import controller.commands.Brighten;
import controller.commands.GreyScale;
import controller.commands.HorizontalFlip;
import controller.commands.Load;
import controller.commands.RGBCombine;
import controller.commands.RGBSplit;
import controller.commands.Save;
import controller.commands.VerticalFlip;
import controller.exceptions.CloseCmdLineException;
import controller.exceptions.FileHandlingException;
import controller.exceptions.ImageNameAlreadyExistsException;
import controller.exceptions.WrongCommandException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import model.IImage;
import view.IView;

/**
 * ImgControllerImpl is the controller class which is called from the main. It takes input from the
 * user and calls necessary classes from the model. Parses the output to the view.
 */
public class ImgControllerImpl extends Helper implements ImgController {

  private final IView view;
  private IImage model;
  private BufferedReader in;
  private BufferedReader tempIn;
  private boolean verbose;

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
    this.verbose = true;
  }

  private void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride) {
      System.out.println(msg);
    }
  }

  private void commandExecution() {

    while (true) {
      this.view.echoGetCommand(false);
      try {
        String cmd = getInput(in);
        if (cmd.equals("run")) {
          this.view.toggleVerbose();
          String scriptPath = this.getInput(in);
          BufferedReader br = new BufferedReader(new FileReader(scriptPath));
          String commands = "";
          for (String line; (line = br.readLine()) != null; ) {
            commands += line + "\n";
          }
          commands += "_run-end## ";
          br.close();

          BufferedReader overrideIn = new BufferedReader(new StringReader(commands));
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
      }
    }
  }


  private void switchHelper(String cmd)
      throws CloseCmdLineException, IOException, FileHandlingException, WrongCommandException,
      ImageNameAlreadyExistsException {
    switch (cmd) {
      case "load":
        Load load = new Load(model, view, in);
        load.execute();
        this.view.echoLoadSuccess(false);
        break;

      case "save":
        Save save = new Save(model, view, in);
        save.execute();
        this.view.echoSaveSuccess(false);
        break;

      case "greyscale":
        GreyScale greyScale = new GreyScale(model, view, in);
        greyScale.execute();
        this.view.echoGreyscaleSuccess(false);
        break;

      case "brighten":
        Brighten brighten = new Brighten(model, view, in);
        brighten.execute();
        this.view.echoBrightenSuccess(false);
        break;

      case "vertical-flip":
        VerticalFlip verticalFlip = new VerticalFlip(model, view, in);
        verticalFlip.execute();
        this.view.echoFlipSuccess(false);
        break;

      case "horizontal-flip":
        HorizontalFlip horizontalFlip = new HorizontalFlip(model, view, in);
        horizontalFlip.execute();
        this.view.echoFlipSuccess(false);
        break;

      case "rgb-split":
        RGBSplit rgbSplit = new RGBSplit(model, view, in);
        rgbSplit.execute();
        this.view.echoSplitSuccess(false);

        break;
      case "rgb-combine":
        RGBCombine rgbCombine = new RGBCombine(model, view, in);
        rgbCombine.execute();
        this.view.echoCombineSuccess(false);
        break;
      case "run":
        break;
      case "_run-end##":
        this.view.echoScriptSuccess(true);
        this.view.toggleVerbose();
        this.in = this.tempIn;
        break;
      default:
        this.view.echoInvalidInputMsg(true);
    }
  }


  @Override
  public void run() {
    commandExecution();
  }
}
