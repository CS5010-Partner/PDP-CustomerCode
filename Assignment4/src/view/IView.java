package view;

import model.ImageObj;

/**
 * IView represents the view interface and the methods that are required for the view.
 */
public interface IView {

  /**
   * Asks the user to enter the command.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoGetCommand(boolean b);

  void toggleMasterVerbose();

  /**
   * Changes the value of the toggle data member. Decides whether to print a message or not.
   */
  void toggleVerbose();

  /**
   * Prints if the program is successfully terminated.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoCloseCmd(boolean b);

  /**
   * Prints the message for the IOError.
   *
   * @param e represents the error message
   * @param b decides whether to show the message to the user or not.
   */
  void echoIoError(String e, boolean b);

  /**
   * Prints the message for the Wrong Command Error.
   *
   * @param e represents the error message
   * @param b decides whether to show the message to the user or not.
   */
  void echoWrongCmdError(String e, boolean b);

  /**
   * Prints the message for the File Handling Error.
   *
   * @param e represents the error message
   * @param b decides whether to show the message to the user or not.
   */
  void echoFileHandlingError(String e, boolean b);

  void echoImageNotFoundError(String e, boolean verbose);

  /**
   * Prints the message for the ImageNameAlreadyExists Error.
   *
   * @param e represents the error message
   * @param b decides whether to show the message to the user or not.
   */
  void echoImageNameAlreadyExistsError(String e, boolean b);

  /**
   * Prints the message for the successful load of the image.
   *
   * @param b decides whether to show the message to the user or not.
   * @param img img object returned by the controller.
   */
  void echoLoadSuccess(ImageObj img, boolean b);

  /**
   * Prints the message for the successful save of the image.
   *
   * @param b decides whether to show the message to the user or not.
   * @param img img object returned by the controller.
   */
  void echoSaveSuccess(ImageObj img, boolean b);

  /**
   * Prints the message for the successful grey scale transformation of the image.
   *
   * @param b decides whether to show the message to the user or not.
   * @param img img object returned by the controller.
   */
  void echoGreyscaleSuccess(ImageObj img, boolean b);

  /**
   * Prints the message for the brightening of the image.
   *
   * @param verbose decides whether to show the message to the user or not.
   * @param img img object returned by the controller.
   */
  void echoBrightenSuccess(ImageObj img, boolean verbose);

  /**
   * Prints the message for the successful flip of the image.
   *
   * @param b decides whether to show the message to the user or not.
   * @param img img object returned by the controller.
   */
  void echoFlipSuccess(ImageObj img, boolean b);


  /**
   * Prints the message for the successful combination of three componenets  of the image.
   *
   * @param b decides whether to show the message to the user or not.
   * @param img img object returned by the controller.
   */
  void echoCombineSuccess(ImageObj img, boolean b);


  /**
   * Prints the message for the successful split of the image into three components.
   *
   * @param b decides whether to show the message to the user or not.
   * @param img img object returned by the controller.
   */
  void echoSplitSuccess(ImageObj[] imgs, boolean b);


  /**
   * Prints the message for the successful run of the script file.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoScriptSuccess(boolean b);

  /**
   * Prints the message for the invalid input entered by the user.
   *
   * @param b decides whether to show the message to the user or not.
   */
  void echoInvalidInputMsg(boolean b);
}
