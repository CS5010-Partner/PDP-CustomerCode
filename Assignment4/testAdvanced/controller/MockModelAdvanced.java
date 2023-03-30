package controller;

import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import model.IImageAdvanced;
import model.ImageObj;

/**
 * This class acts as a mock implementation to the model class.
 */
public class MockModelAdvanced extends MockModel implements IImageAdvanced {

  @Override
  public ImageObj filterBlur(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("filterBlur | " + imageName + " | " + destImageName + "\n");
    return null;
  }

  @Override
  public ImageObj filterSharpen(String imageName, String destImageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("filterSharpen | " + imageName + " | " + destImageName + "\n");
    return null;
  }

  @Override
  public ImageObj transformGreyScale(String param1, String param2)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("transformGreyScale | " + param1 + " | " + param2 + "\n");
    return null;
  }

  @Override
  public ImageObj transformSepia(String sourceName, String destName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("transformSepia | " + sourceName + " | " + destName + "\n");

    return null;
  }

  @Override
  public ImageObj dither(String sourceName, String destName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    super.sb.append("dither | " + sourceName + " | " + destName + "\n");
    return null;
  }
}
