package controller.file;

import exceptions.FileHandlingException;
import model.ImageObj;

/**
 * PNGFile class supports class for the PNG image type.
 */
public class PNGFile extends AFile {

  /**
   * Constructor for the PNGFile class.
   *
   * @param filePath sets the value for the filePath data member.
   */
  public PNGFile(String filePath) {
    super(filePath);
  }

  @Override
  public void fileWrite(ImageObj content) throws FileHandlingException {
    fileWriteHelper(content, "png");
  }
}
