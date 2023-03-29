package controller.file;

import exceptions.FileHandlingException;
import model.ImageObj;

public class JPEGFile extends AFile{
  public JPEGFile(String filePath) {
    super(filePath);
  }

  @Override
  public void fileWrite(ImageObj content) throws FileHandlingException {
    fileWriteHelper(content, "jpg");
  }
}
