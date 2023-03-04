package model;

public interface IImage {
  void load(IFile imagePath,String imageName);
  void save(IFile imagePath,String imageName);
  void greyScaleRed(String imageName, String desImageName);
  void greyScaleGreen(String imageName, String desImageName);
  void greyScaleBlue(String imageName, String desImageName);
  void greyScaleValue(String imageName, String desImageName);
  void greyScaleIntensity(String imageName, String desImageName);
  void greyScaleLuma(String imageName, String desImageName);

  void horizontalFlip(String imageName, String desImageName);
  void verticalFlip(String imageName,String desImageName);
  void brighten(int increment, String imageName, String desImageName);
  void rgbSplit(String imageName, String redDesImageName, String greenDesImageName, String blueDesImageName);
  void rgbCombine(String imageName, String redImageName, String greenImageName, String blueImageName);

}
