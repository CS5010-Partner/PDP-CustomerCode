package controller.file;

import exceptions.FileHandlingException;
import model.ImageObj;

public class BMPFile extends AFile {
  public BMPFile(String filePath) {
    super(filePath);
  }

  @Override
  public void fileWrite(ImageObj content) throws FileHandlingException {
    fileWriteHelper(content, "bmp");
  }
}
