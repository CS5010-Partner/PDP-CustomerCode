package model;

import controller.file.IFile;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.util.HashMap;

/**
 * ImageSet class implements the IImage interface, and it acts as a model.
 */
public class ImageSet implements IImage {

  HashMap<String, ImageObj> map;

  /**
   * Represents the empty constructor and initialises the data member which is the hashmap.
   */
  public ImageSet() {
    map = new HashMap<>();
  }

  protected void checkName(String[] inputNames, String[] destNames)
      throws ImageNameAlreadyExistsException, ImageNotFoundException {
    for (String s : inputNames) {
      if (!map.containsKey(s)) {
        throw new ImageNotFoundException("The image name does not exist.");
      }
    }

    for (String s : destNames) {
      if (map.containsKey(s)) {
        throw new ImageNameAlreadyExistsException("Image name already exists.");
      }
    }
  }

  @Override
  public ImageObj load(IFile obj, String imageName)
      throws FileHandlingException, ImageNameAlreadyExistsException, ImageNotFoundException {

    checkName(new String[]{}, new String[]{imageName});

    String content = obj.fileRead();
    String[] token = content.split("\n");
    int width = Integer.parseInt(token[0]);
    int height = Integer.parseInt(token[1]);
    int maxValue = Integer.parseInt(token[2]);

    int t = 3;
    int[][][] image = new int[height][width][3];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = Integer.parseInt(token[t]);
          t++;
        }
      }
    }
    ImageObj loadObj = new ImageObj(image, width, height, maxValue);
    map.put(imageName, loadObj);
    return loadObj;
  }

  @Override
  public ImageObj save(IFile format, String imageName)
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    checkName(new String[]{imageName}, new String[]{});
    ImageObj saveObj = map.get(imageName);
    format.fileWrite(saveObj);
    return map.get(imageName);
  }

  @Override
  public ImageObj greyScaleRed(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleRed();
    map.put(desImageName, grey);
    return grey;
  }

  @Override
  public ImageObj greyScaleGreen(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleGreen();
    map.put(desImageName, grey);
    return grey;
  }

  @Override
  public ImageObj greyScaleBlue(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleBlue();
    map.put(desImageName, grey);
    return grey;
  }

  @Override
  public ImageObj greyScaleValue(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleValue();
    map.put(desImageName, grey);
    return grey;

  }

  @Override
  public ImageObj greyScaleIntensity(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleIntensity();
    map.put(desImageName, grey);
    return grey;
  }

  @Override
  public ImageObj greyScaleLuma(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleLUMA();
    map.put(desImageName, grey);
    return grey;
  }

  @Override
  public ImageObj horizontalFlip(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj horizontalFlip = map.get(imageName).horizontalFlip();
    map.put(desImageName, horizontalFlip);
    return horizontalFlip;
  }

  @Override
  public ImageObj verticalFlip(String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj verticalFlip = map.get(imageName).verticalFlip();
    map.put(desImageName, verticalFlip);
    return verticalFlip;
  }

  @Override
  public ImageObj brighten(int increment, String imageName, String desImageName)
      throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj brighten = map.get(imageName).brighten(increment);
    map.put(desImageName, brighten);
    return brighten;
  }

  @Override
  public ImageObj[] rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName) throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{imageName},
        new String[]{redDesImageName, greenDesImageName, blueDesImageName});
    ImageObj[] rgbSplit = map.get(imageName).rgbSplit();
    map.put(redDesImageName, rgbSplit[0]);
    map.put(greenDesImageName, rgbSplit[1]);
    map.put(blueDesImageName, rgbSplit[2]);
    return rgbSplit;
  }

  @Override
  public ImageObj rgbCombine(String destImageName, String redImageName, String greenImageName,
      String blueImageName) throws ImageNotFoundException, ImageNameAlreadyExistsException {
    checkName(new String[]{redImageName, greenImageName, blueImageName},
        new String[]{destImageName});
    ImageObj redImage = map.get(redImageName);
    ImageObj greenImage = map.get(greenImageName);
    ImageObj blueImage = map.get(blueImageName);
    ImageObj combine = redImage.rgbCombine(greenImage, blueImage);
    map.put(destImageName, combine);
    return combine;
  }
}
