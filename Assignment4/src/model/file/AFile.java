package model.file;

import exceptions.FileHandlingException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class AFile implements IFile{
  protected final String filePath;

  protected AFile(String filePath) {
    this.filePath = filePath;
  }
  @Override
  public String fileRead() throws FileHandlingException {
    StringBuilder s = new StringBuilder();
    int maxValue=Integer.MIN_VALUE;
    int width =0;
    int height =0;
    BufferedImage image=null;
    try {
      image = ImageIO.read(new File(this.filePath));
    }catch (IOException e)
    {
      throw new FileHandlingException("Error in accessing the file");
    }
    width=image.getWidth();
    height=image.getHeight();
    int[][][] img = new int[height][width][3];

    for (int x = 0; x < height; x++) {
      for (int y = 0; y < width; y++) {
        int rgb = image.getRGB(x, y);
        img[x][y][0] = (rgb >> 16) & 0xFF; // red channel
        s.append(img[x][y][0] + "\n");
        img[x][y][1] = (rgb >> 8) & 0xFF; // green channel
        s.append(img[x][y][1] + "\n");
        img[x][y][2] = rgb & 0xFF; // blue channel
        s.append(img[x][y][2] + "\n");
        maxValue=Math.max(img[x][y][0],Math.max(img[x][y][1],Math.max(maxValue,img[x][y][2])));
      }
    }

    return convertToPPM(s.toString(),maxValue,width,height);
  }
  private String convertToPPM(String pngImage, int maxValue,int width,int height)
  {
    StringBuffer result=new StringBuffer();
    result.append("P3\n");
    result.append(width + "\n");
    result.append(height + "\n");
    result.append(maxValue + "\n");
    result.append(pngImage);
    return result.toString();
  }
}
