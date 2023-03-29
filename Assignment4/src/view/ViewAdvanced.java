package view;

import java.io.BufferedWriter;

public class ViewAdvanced extends View implements IViewAdvanced {

  /**
   * Constructor for the View class. It initializes the verbose datamember value.
   *
   * @param out
   */
  public ViewAdvanced(BufferedWriter out) {
    super(out);
  }

  @Override
  public void echoFilterBlurSuccess(boolean b) {
    super.print("Image Blurred successfully.", super.verbose);
  }

  @Override
  public void echoFilterSharpenSuccess(boolean b) {
    super.print("Image Sharpened successfully.", super.verbose);
  }

  @Override
  public void echoSepiaSuccess(boolean b) {
    super.print("Image converted to Sepia successfully.", super.verbose);
  }

  @Override
  public void echoDither(boolean b) {
    super.print("Image converted to Dither successfully.", super.verbose);
  }

}
