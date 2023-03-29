package controller.file;

import exceptions.FileHandlingException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.ImageObj;

public abstract class AFile implements IFile{
  protected final String filePath;

  protected AFile(String filePath) {
    this.filePath = filePath;
  }
  @Override
  public String fileRead() throws FileHandlingException {
    StringBuilder s = new StringBuilder();
    int maxValue=Integer.MIN_VALUE;
    int width;
    int height;
    BufferedImage image;
    try {
      image = ImageIO.read(new File(this.filePath));
    }catch (IOException e)
    {
      throw new FileHandlingException("File " + this.filePath + " not found!");
    }
    width=image.getWidth();
    height=image.getHeight();
    int[][][] img = new int[height][width][3];

    for (int x = 0; x < height; x++) {
      for (int y = 0; y < width; y++) {
        int rgb = image.getRGB(y, x);
        img[x][y][0] = (rgb >> 16) & 0xFF;
        s.append(img[x][y][0]).append("\n");
        img[x][y][1] = (rgb >> 8) & 0xFF;
        s.append(img[x][y][1]).append("\n");
        img[x][y][2] = rgb & 0xFF;
        s.append(img[x][y][2]).append("\n");
        maxValue=Math.max(img[x][y][0],Math.max(img[x][y][1],Math.max(maxValue,img[x][y][2])));
      }
    }
    return convertToResult(s.toString(),maxValue,width,height);
  }
  private String convertToResult(String pngImage, int maxValue,int width,int height)
  {
    return width + "\n"
        + height + "\n"
        + maxValue + "\n"
        + pngImage;
  }

  protected void fileWriteHelper(ImageObj content, String fileType) throws FileHandlingException {
    File file = new File(filePath);
    int width = content.getWidth();
    int height = content.getHeight();
    int[][][] img=content.getImage();
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < height; x++) {
      for (int y = 0; y < width; y++) {
        int r = img[x][y][0];
        int g = img[x][y][1];
        int b = img[x][y][2];
        int rgb = (r << 16) | (g << 8) | b;
        image.setRGB(y, x, rgb);
      }
    }
    try {
      ImageIO.write(image, fileType, file);
    }catch (IOException e)
    {
      throw new FileHandlingException("Directory not Found.");
    }
  }
}
