package view;

/**
 * Interface that represents the methods present in View class.
 */
public interface IViewUI {

  /**
   * Sets the buttons and other elements in the UI and also sets the frame to visible.
   */
  void show();

  /**
   * Will get the count number of file paths from the user.
   *
   * @param count number of the file paths needed.
   * @return the string array of the paths.
   */
  String[] fileChooser(int count);

  /**
   * This method sets the image in the center of the application. When null we can not read the
   * image and sets the frame to empty.
   */
  void changeImageType();

  /**
   * Returns the input entered by the user in the pop up.
   *
   * @return the string input.
   */
  String popUpInput();

  /**
   * Returns the type of operation to be applied for the grey scale image.
   *
   * @return the value to be applied to the grey transformation.
   */
  String greyChooser();

  /**
   * Returns the type of operation to be applied for the rgb split image.
   *
   * @return the value to be applied to the rgb split transformation.
   */
  boolean splitChooser();

  /**
   * Returns the type of operation to be applied for the rgb combine image.
   *
   * @return the value to be applied to the rgb combine transformation.
   */
  boolean combineChooser();

  /**
   * Returns the path where the image has to be saved.
   *
   * @return the path of the image.
   */
  String savePath();

  /**
   * Asks the user to enter integer input.
   */
  void setBrightException();
}
