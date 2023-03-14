package controller;

import commands.Brighten;
import commands.GreyScale;
import commands.HorizontalFlip;
import commands.Load;
import commands.RGBCombine;
import commands.RGBSplit;
import commands.Save;
import commands.VerticalFlip;
import helper.CloseCmdLineException;
import helper.FileHandlingException;
import helper.Helper;
import helper.ImageNameAlreadyExistsException;
import helper.WrongCommandException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
  private BufferedWriter out;
  private boolean verbose;

  /**
   * Constructor for the ImgControllerImpl class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    gives the object from where the input is read.
   * @param out   gives the object through which the output is sent.
   */
  public ImgControllerImpl(IImage model, IView view, BufferedReader in, BufferedWriter out) {
    this.model = model;
    this.view = view;
    this.in = in;
    this.tempIn = in;
    this.out = out;
    this.verbose = true;
  }

  private void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride)
    System.out.println(msg);
  }

  private void commandExecution() {
  
    while (true)
    {
//      print("Enter the command", false);
      this.view.echoGetCommand(false);
      try {
        String cmd = getInput(in);
        if (cmd.equals("run")) {

//          this.verbose = false;
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
//        print("Program exited successfully", true);
        this.view.echoCloseCmd(true);
        break;
      } catch (IOException e) {
//        print(e + "There is a problem with reading the input, please try again.",true);
        this.view.echoIoError(e.toString(), true);
      } catch (WrongCommandException e) {
//        print(e + " Please enter a valid command!", true);
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
//          print("Image loaded sucessfully.", false);
          this.view.echoLoadSuccess(false);
          break;

        case "save":
          Save save = new Save(model, view, in);
          save.execute();
//          print("Image saved successfully.", false);
          this.view.echoSaveSuccess(false);
          break;

        case "greyscale":
          GreyScale greyScale = new GreyScale(model, view, in);
          greyScale.execute();
//          print("Image converted to greyscale successfully.", false);
          this.view.echoGreyscaleSuccess(false);
          break;

        case "brighten":
          Brighten brighten = new Brighten(model, view, in);
          brighten.execute();
//          print("Image brightened successfully.", false);
          this.view.echoBrightenSuccess(false);
          break;

        case "vertical-flip":
          VerticalFlip verticalFlip = new VerticalFlip(model, view, in);
          verticalFlip.execute();
//          print("Image flipped successfully.", false);
          this.view.echoFlipSuccess(false);
          break;

        case "horizontal-flip":
          HorizontalFlip horizontalFlip = new HorizontalFlip(model, view, in);
          horizontalFlip.execute();
//          print("Image flipped successfully.", false);
          this.view.echoFlipSuccess(false);
          break;

        case "rgb-split":
          RGBSplit rgbSplit = new RGBSplit(model, view, in);
          rgbSplit.execute();
//          print("Image split successfully.", false);
          this.view.echoSplitSuccess(false);

          break;
        case "rgb-combine":
          RGBCombine rgbCombine = new RGBCombine(model, view, in);
          rgbCombine.execute();
//          print("Image combined successfully.", false);
          this.view.echoCombineSuccess(false);
          break;
        case "run":
          break;
        case "_run-end##":
//          print("Script has been successfully executed.", true);
          this.view.echoScriptSuccess(true);
          this.view.toggleVerbose();
          this.in = this.tempIn;
          break;
        default:
//          print("Please Enter A Valid Input", true);
          this.view.echoInvalidInputMsg(true);
      }
  }


  @Override
  public void go() {
    commandExecution();
  }
}
