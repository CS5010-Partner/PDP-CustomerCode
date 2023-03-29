package controller.file;

import exceptions.FileHandlingException;
import model.ImageObj;

public class PNGFile extends AFile{
  public PNGFile(String filePath) {
    super(filePath);
  }

  @Override
  public void fileWrite(ImageObj content) throws FileHandlingException {
    fileWriteHelper(content, "png");
  }
}
