package view;

/**
 * View class represents the view object which is the accessed from the main object.
 * It implements the IView and overrides the different types of the print statements.
 */
public class View implements IView{
  private boolean verbose;

  /**
   * Constructor for the View class.
   * It initializes the verbose datamember value.
   */
  public View() {
    this.verbose = true;
  }
  private void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride)
      System.out.println(msg);
  }

  @Override
  public void toggleVerbose() {
    this.verbose = !this.verbose;
  }
  @Override
  public void echoGetCommand(boolean verbose) {
    print("Enter the command", false);
  }

  @Override
  public void echoCloseCmd(boolean verbose) {
    print("Program exited successfully", true);
  }

  @Override
  public void echoIoError(String e, boolean verbose) {
    print(e + "There is a problem with reading the input, please try again.", true);
  }

  @Override
  public void echoWrongCmdError(String e, boolean verbose) {
    print(e + " Please enter a valid command!", true);
  }

  @Override
  public void echoFileHandlingError(String e, boolean verbose) {
    print(e + "File not found, Please try again!", true);
  }

  @Override
  public void echoImageNameAlreadyExistsError(String e, boolean verbose) {
    print(e + " Please choose a different name!", true);
  }

  @Override
  public void echoLoadSuccess(boolean verbose) {
    print("Image loaded sucessfully.", false);
  }

  @Override
  public void echoSaveSuccess(boolean verbose) {
    print("Image saved successfully.", false);
  }

  @Override
  public void echoGreyscaleSuccess(boolean verbose) {
    print("Image converted to greyscale successfully.", false);
  }

  @Override
  public void echoBrightenSuccess(boolean verbose) {
    print("Image brightened successfully.", false);
  }
  @Override
  public void echoFlipSuccess(boolean verbose) {
    print("Image flipped successfully.", false);
  }
  @Override
  public void echoSplitSuccess(boolean verbose) {
    print("Image split successfully.", false);
  }
  @Override
  public void echoCombineSuccess(boolean verbose) {
    print("Image combined successfully.", false);
  }
  @Override
  public void echoScriptSuccess(boolean verbose) {
    print("Script has been successfully executed.", true);
  }
  @Override
  public void echoInvalidInputMsg(boolean verbose) {
    print("Please Enter A Valid Input", true);
  }
}
