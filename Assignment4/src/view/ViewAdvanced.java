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
    print("Image Blurred successfully.", b);
  }

  @Override
  public void echoFilterSharpenSuccess(boolean b) {
    print("Image Sharpened successfully.", b);
  }

  @Override
  public void echoSepiaSuccess(boolean b) {
    print("Image converted to Sepia successfully.", b);
  }

  @Override
  public void echoDither(boolean b) {
    print("Image converted to Dither successfully.", b);
  }

}
