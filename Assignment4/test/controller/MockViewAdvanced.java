package controller;

import view.IViewAdvanced;

/**
 * This class acts as a new mock implementation to the view class.
 */
public class MockViewAdvanced extends MockView implements IViewAdvanced {

  public MockViewAdvanced() {
    super.verbose = true;
  }

  private void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride) {
      System.out.println(msg);
      super.sb.append(msg);
      super.sb.append("|");
    }
  }


  @Override
  public void echoFilterBlurSuccess(boolean b) {
    print("Blur Success", false);
  }

  @Override
  public void echoFilterSharpenSuccess(boolean b) {
    print("Sharpen Success", false);

  }

  @Override
  public void echoSepiaSuccess(boolean b) {
    print("Sepia Success", false);

  }

  @Override
  public void echoDither(boolean b) {
    print("Dither Success", false);

  }
}
