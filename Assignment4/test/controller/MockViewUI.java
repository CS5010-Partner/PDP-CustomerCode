package controller;

import model.ImageObj;
import view.IViewUI;

/**
 * This class represents the mock of the ViewUI class that needs to be used for testing.
 */
public class MockViewUI extends MockViewAdvanced implements IViewUI {

  protected void print(String msg, boolean verboseOveride) {
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

  @Override
  public void show() {
    print("show Success", false);

  }

  @Override
  public String[] fileChooser(int count) {
    print("file chooser Success", false);
    return null;
  }

  @Override
  public void changeImageType() {
    print("change Image type Success", false);

  }

  @Override
  public String popUpInput() {
    print("popup Success", false);
    return null;
  }

  @Override
  public String greyChooser() {
    print("grey chooser Success", false);
    return null;
  }

  @Override
  public boolean splitChooser() {
    print("split chooser Success", false);
    return false;
  }

  @Override
  public boolean combineChooser() {
    print("combine chooser Success", false);
    return false;
  }

  @Override
  public String savePath() {
    print("sa path Success", false);
    return null;
  }

  @Override
  public void setBrightException() {
    print("bright exception Success", false);

  }
}
