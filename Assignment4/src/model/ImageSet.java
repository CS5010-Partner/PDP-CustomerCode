package model;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ImageSet implements IImage {
  HashMap<String,ImageObj> map;

  public ImageSet()
  {
    map=new HashMap<>();
  }

  private void checkName(String[] inputNames, String[] destNames)
      throws NoSuchElementException, IllegalAccessException {
    for (String s:inputNames) {
      if (!map.containsKey(s))
        throw new NoSuchElementException("The image name does not exist.");
    }

    for (String s:destNames) {
      if (map.containsKey(s))
        throw new IllegalAccessException("Image name already exists. Please choose a different name.");
    }
  }

  @Override
  public void load(IFile obj, String imageName) throws IllegalAccessException {
    if (map.containsKey(imageName))
      throw new IllegalAccessException("Image name already exists. Please choose a different name.");

    String content=obj.fileRead();
    String[] token=content.split("\n");

    int width=Integer.parseInt(token[1]);
    int height=Integer.parseInt(token[2]);
    int maxValue=Integer.parseInt(token[3]);

    int t=4;
    int[][][] image=new int[height][width][3];

    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        for(int k=0;k<3;k++)
        {
          image[i][j][k]=Integer.parseInt(token[t]);
          t++;
        }
      }
    }

//    System.out.println("load height : "+ image.length);
//    System.out.println("load width : "+ image[0].length);

    map.put(imageName, new ImageObj(image,width,height,maxValue));
  }

  @Override
  public void save(IFile format, String imageName) {
    format.fileWrite(map.get(imageName).toString());
  }

  @Override
  public void greyScaleRed(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException {
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleRed();
    map.put(desImageName, grey);
  }

  @Override
  public void greyScaleGreen(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleGreen();
    map.put(desImageName, grey);
  }

  @Override
  public void greyScaleBlue(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleBlue();
    map.put(desImageName, grey);
  }

  @Override
  public void greyScaleValue(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleValue();
    map.put(desImageName, grey);

  }

  @Override
  public void greyScaleIntensity(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleIntensity();
    map.put(desImageName, grey);

  }

  @Override
  public void greyScaleLuma(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj grey = map.get(imageName).greyScaleLUMA();
    map.put(desImageName, grey);

  }

  @Override
  public void horizontalFlip(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj horizontalFlip = map.get(imageName).horizontalFlip();
    map.put(desImageName, horizontalFlip);
  }

  @Override
  public void verticalFlip(String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj verticalFlip = map.get(imageName).verticalFlip();
    map.put(desImageName, verticalFlip);
  }

  @Override
  public void brighten(int increment, String imageName, String desImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{desImageName});
    ImageObj brighten = map.get(imageName).brighten(increment);
    map.put(desImageName, brighten);

  }

  @Override
  public void rgbSplit(String imageName, String redDesImageName, String greenDesImageName,
      String blueDesImageName)
      throws NoSuchElementException, IllegalAccessException{
    checkName(new String[]{imageName}, new String[]{redDesImageName, greenDesImageName, blueDesImageName});
    ImageObj[] rgbSplit = map.get(imageName).rgbSplit();
    map.put(redDesImageName, rgbSplit[0]);
    map.put(greenDesImageName, rgbSplit[1]);
    map.put(blueDesImageName, rgbSplit[2]);
  }

  @Override
  public void rgbCombine(String destimageName, String redImageName, String greenImageName,
      String blueImageName) throws NoSuchElementException, IllegalAccessException {
    checkName(new String[]{redImageName, greenImageName, blueImageName}, new String[]{destimageName});
    ImageObj redImage = map.get(redImageName);
    ImageObj greenImage = map.get(greenImageName);
    ImageObj blueImage = map.get(blueImageName);

    map.put(destimageName, redImage.rgbCombine(greenImage, blueImage));
  }

}
