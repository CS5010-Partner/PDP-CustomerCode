package controller.file;

import exceptions.FileHandlingException;
import model.ImageObj;

/**
 * BMPFile class supports class for the BMP image type.
 */
public class BMPFile extends AFile {

  /**
   * Constructor for the BMPFile class.
   *
   * @param filePath sets the value for the filePath data member.
   */
  public BMPFile(String filePath) {
    super(filePath);
  }

  @Override
  public void fileWrite(ImageObj content) throws FileHandlingException {
    fileWriteHelper(content, "bmp");
  }
}
