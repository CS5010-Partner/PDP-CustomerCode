package view;

import java.io.BufferedWriter;

/**
 * ViewAdvanced class represents the view object which is the accessed from the main object. It
 * implements the IViewAdvanced and overrides the different types of the print statements.
 */
public class ViewAdvanced extends View implements IViewAdvanced {

  /**
   * Constructor for the ViewAdvanced class. It initializes the verbose data member value.
   *
   * @param out represents the buffered writer object.
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
