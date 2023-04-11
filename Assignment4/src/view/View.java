package view;

import java.io.BufferedWriter;
import java.io.IOException;
import model.ImageObj;

/**
 * View class represents the view object which is the accessed from the main object. It implements
 * the IView and overrides the different types of the print statements.
 */
public class View implements IView {

  private boolean verbose;
  private BufferedWriter out;
  private boolean masterVerbose;


  /**
   * Constructor for the View class. It initializes the verbose datamember value.
   */
  public View(BufferedWriter out) {
    this.verbose = true;
    this.out = out;
    this.masterVerbose = true;
  }

  protected boolean getVerbose() {
    return verbose;
  }
  protected void print(String msg, boolean verboseOveride) {
    if (!this.masterVerbose) {
      return;
    }
    try {
      if (this.verbose || verboseOveride) {
        this.out.write(msg);
        this.out.newLine();
        this.out.flush();
      }
    }
    catch (IOException e) {
      System.out.println("There is a problem with output generator.");
    }
  }

  @Override
  public void toggleMasterVerbose() {
    this.masterVerbose = !this.masterVerbose;
  }

  @Override
  public void toggleVerbose() {
    this.verbose = !this.verbose;
  }

  @Override
  public void echoGetCommand(boolean verbose) {
    print("Enter the command",
        verbose);
  }

  @Override
  public void echoCloseCmd(boolean verbose) {
    print("Program exited successfully",
        verbose);
  }

  @Override
  public void echoIoError(String e, boolean verbose) {
    print(e + " There is a problem with reading the input, please try again.",
        verbose);
  }

  @Override
  public void echoWrongCmdError(String e, boolean verbose) {
    print(e + " Please enter a valid command!", verbose);
  }

  @Override
  public void echoFileHandlingError(String e, boolean verbose) {
    print(e + " File not found, Please try again!", verbose);
  }

  @Override
  public void echoImageNotFoundError(String e, boolean verbose) {
    print(e + " Image Name not found. Please try again!", verbose);
  }

  @Override
  public void echoImageNameAlreadyExistsError(String e, boolean verbose) {
    print(e + " Please choose a different name!", verbose);
  }

  @Override
  public void echoLoadSuccess(ImageObj img, boolean verbose) {
    print("Image loaded sucessfully.",
        verbose);
  }

  @Override
  public void echoSaveSuccess(ImageObj img, boolean verbose) {
    print("Image saved successfully.",
        verbose);
  }

  @Override
  public void echoGreyscaleSuccess(ImageObj img, boolean verbose) {
    print("Image converted to greyscale successfully.", verbose);
  }

  @Override
  public void echoBrightenSuccess(ImageObj img, boolean verbose) {
    print("Image brightened successfully.", verbose);
  }

  @Override
  public void echoFlipSuccess(ImageObj img, boolean verbose) {
    print("Image flipped successfully.",
        verbose);
  }

  @Override
  public void echoSplitSuccess(ImageObj[] imgs, boolean verbose) {
    print("Image split successfully.",
        verbose);
  }

  @Override
  public void echoCombineSuccess(ImageObj img, boolean verbose) {
    print("Image combined successfully.",
        verbose);
  }

  @Override
  public void echoScriptSuccess(boolean verbose) {
    print("Script has been successfully executed.", verbose);
  }

  @Override
  public void echoInvalidInputMsg(boolean verbose) {
    print("Please Enter A Valid Input",
        verbose);
  }
}
