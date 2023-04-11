package controller.file;

import exceptions.FileHandlingException;
import model.ImageObj;

/**
 * JPEGFile class supports class for the BMP image type.
 */
public class JPEGFile extends AFile {

  /**
   * Constructor for the JPEGFile class.
   *
   * @param filePath sets the value for the filePath data member.
   */
  public JPEGFile(String filePath) {
    super(filePath);
  }

  @Override
  public void fileWrite(ImageObj content) throws FileHandlingException {
    fileWriteHelper(content, "jpg");
  }
}
