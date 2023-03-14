package view;
public class View implements IView{
  private boolean verbose;

  public View() {
    this.verbose = true;
  }
  public void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride)
      System.out.println(msg);
  }

  public void toggleVerbose() {
    this.verbose = !this.verbose;
  }
  public void echoGetCommand(boolean verbose) {
    print("Enter the command", false);
  }

  public void echoCloseCmd(boolean verbose) {
    print("Program exited successfully", true);
  }

  public void echoIoError(String e, boolean verbose) {
    print(e + "There is a problem with reading the input, please try again.", true);
  }

  public void echoWrongCmdError(String e, boolean verbose) {
    print(e + " Please enter a valid command!", true);
  }

  public void echoFileHandlingError(String e, boolean verbose) {
    print(e + "File not found, Please try again!", true);
  }

  public void echoImageNameAlreadyExistsError(String e, boolean verbose) {
    print(e + " Please choose a different name!", true);
  }

  public void echoLoadSuccess(boolean verbose) {
    print("Image loaded sucessfully.", false);
  }

  public void echoSaveSuccess(boolean verbose) {
    print("Image saved successfully.", false);
  }

  public void echoGreyscaleSuccess(boolean verbose) {
    print("Image converted to greyscale successfully.", false);
  }

  public void echoBrightenSuccess(boolean verbose) {
    print("Image brightened successfully.", false);
  }
  public void echoFlipSuccess(boolean verbose) {
    print("Image flipped successfully.", false);
  }
  public void echoSplitSuccess(boolean verbose) {
    print("Image split successfully.", false);
  }
  public void echoCombineSuccess(boolean verbose) {
    print("Image combined successfully.", false);
  }
  public void echoScriptSuccess(boolean verbose) {
    print("Script has been successfully executed.", true);
  }
  public void echoInvalidInputMsg(boolean verbose) {
    print("Please Enter A Valid Input", true);
  }
}
