package controller;

import model.ImageObj;
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
    print("historgram success", false);
  }
}
