package controller;

import model.ImageObj;
import view.IViewAdvanced;

/**
 * This class represents the mock of the ViewUI class that needs to be used for testing.
 */
public class MockViewUI extends MockView implements IViewAdvanced {

  private void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride) {
      System.out.println(msg);
      super.sb.append(msg);
      super.sb.append("|");
    }
  }

  public void echoLoadSuccess(ImageObj img, boolean verbose) {
    print("Load Success", false);
  }

  @Override
  public void echoFilterBlurSuccess(ImageObj img, boolean b) {
    print("Blur Success", false);
  }

  @Override
  public void echoFilterSharpenSuccess(ImageObj img, boolean b) {
    print("Sharpen Success", false);
  }

  @Override
  public void echoSepiaSuccess(ImageObj img, boolean b) {
    print("Sepia Success", false);
  }

  @Override
  public void echoDither(ImageObj img, boolean b) {
    print("Dither Success", false);
  }

  @Override
  public void echoHistogramSuccess(ImageObj[] imgs, boolean b) {
    print("Histogram Success", false);
  }
}
