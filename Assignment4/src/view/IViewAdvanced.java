package view;

/**
 * IViewAdvanced represents the view interface and the methods that are required for the new view.
 */
public interface IViewAdvanced extends IView {

  /**
   * Prints the message for the image being transformed to blur image.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoFilterBlurSuccess(boolean b);

  /**
   * Prints the message for the image being transformed to sharpened image.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoFilterSharpenSuccess(boolean b);

  /**
   * Prints the message for the image being transformed to sepia image.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoSepiaSuccess(boolean b);

  /**
   * Prints the message for the image being transformed to sepia image.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoDither(boolean b);
}
