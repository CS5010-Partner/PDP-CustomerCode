package view;

import java.io.BufferedWriter;
import model.ImageObj;

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
  public void echoFilterBlurSuccess(ImageObj img, boolean b) {
    print("Image Blurred successfully.", b);
  }

  @Override
  public void echoFilterSharpenSuccess(ImageObj img, boolean b) {
    print("Image Sharpened successfully.", b);

  }

  @Override
  public void echoSepiaSuccess(ImageObj img, boolean b) {
    print("Image converted to Sepia successfully.", b);
  }

  @Override
  public void echoDither(ImageObj img, boolean b) {
    print("Image converted to Dither successfully.", b);
  }

  @Override
  public void echoHistogramSuccess(ImageObj[] imgs, boolean b) {
    System.out.println("adasdas");
    print("Histograms generated successfully.", b);
  }

}
