package view;

import model.ImageObj;

/**
 * IViewAdvanced represents the view interface and the methods that are required for the new view.
 */
public interface IViewAdvanced extends IView {

  /**
   * Prints the message for the image being transformed to blur image.
   *
   * @param b   decides whether to show the message to the user or not.
   * @param img image object returned by the controller.
   */
  void echoFilterBlurSuccess(ImageObj img, boolean b);

  /**
   * Prints the message for the image being transformed to sharpened image.
   *
   * @param b   decides whether to show the message to the user or not.
   * @param img image object returned by the controller.
   */
  void echoFilterSharpenSuccess(ImageObj img, boolean b);

  /**
   * Prints the message for the image being transformed to sepia image.
   *
   * @param b   decides whether to show the message to the user or not.
   * @param img image object returned by the controller.
   */
  void echoSepiaSuccess(ImageObj img, boolean b);

  /**
   * Prints the message for the image being transformed to sepia image.
   *
   * @param b   decides whether to show the message to the user or not.
   * @param img image object returned by the controller.
   */
  void echoDither(ImageObj img, boolean b);

  /**
   * Prints the message for the histogram being created successfully.
   *
   * @param imgs represents the histogram images.
   * @param b    checks if we can print or not.
   */
  void echoHistogramSuccess(ImageObj[] imgs, boolean b);


  /**
   * Prints the message for the image being transformed into a mosaic image.
   *
   * @param img image object returned by the controller.
   * @param b decides whether to show the message to the user or not.
   */
  void echoMosaicSuccess(ImageObj img, boolean b);
}
