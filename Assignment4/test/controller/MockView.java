package controller;

import model.ImageObj;
import view.IView;

/**
 * This class acts as a mock implementation to the view class.
 */
public class MockView implements IView {

  protected boolean verbose;
  protected StringBuffer sb = new StringBuffer();

  public MockView() {
    this.verbose = true;
  }

  public String toString() {
    return sb.toString();
  }

  private void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride) {
      System.out.println(msg);
      sb.append(msg);
      sb.append("|");
    }
  }

  public void toggleVerbose() {
    this.verbose = !this.verbose;
  }

  public void echoGetCommand(boolean verbose) {
    print("Get Cmd", false);
  }

  public void echoCloseCmd(boolean verbose) {
    print("Close Cmd", true);
  }

  public void echoIoError(String e, boolean verbose) {
    print("IO Error", true);
  }

  public void echoWrongCmdError(String e, boolean verbose) {
    print("Wrong Cmd", true);
  }

  public void echoFileHandlingError(String e, boolean verbose) {
    print("File Handling Error", true);
  }

  @Override
  public void echoImageNotFoundError(String e, boolean verbose) {
    print("Image Name Error", true);
  }

  public void echoImageNameAlreadyExistsError(String e, boolean verbose) {
    print("Image Name Error", true);
  }

  public void echoLoadSuccess(ImageObj img, boolean verbose) {
    print("Load Success", false);
  }

  public void echoSaveSuccess(ImageObj img,boolean verbose) {
    print("Save Success", false);
  }

  public void echoGreyscaleSuccess(ImageObj img,boolean verbose) {
    print("Greyscale Success", false);
  }

  public void echoBrightenSuccess(ImageObj img,boolean verbose) {
    print("Brighten Success", false);
  }

  public void echoFlipSuccess(ImageObj img,boolean verbose) {
    print("Flip Success", false);
  }

  public void echoSplitSuccess(ImageObj[] imgs, boolean verbose) {
    print("Split Success", false);
  }

  public void echoCombineSuccess(ImageObj img,boolean verbose) {
    print("Combine Success", false);
  }

  public void echoScriptSuccess(boolean verbose) {
    print("Script Success", true);
  }

  public void echoInvalidInputMsg(boolean verbose) {
    print("Invalid Input", true);
  }
}
