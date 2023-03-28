package model.file;

import exceptions.FileHandlingException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.ImageObj;

public class JPEGFile extends AFile{

  public JPEGFile(String filePath) {
    super(filePath);
  }

  @Override
  public void fileWrite(ImageObj content) throws FileHandlingException {
    File file = new File(filePath);
    int width = content.getWidth();
    int height = content.getHeight();
    int[][][] img=content.getImage();
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        int r = img[x][y][0];
        int g = img[x][y][1];
        int b = img[x][y][2];
        int rgb = (r << 16) | (g << 8) | b;
        image.setRGB(x, y, rgb);
      }
    }
    try {
      ImageIO.write(image, "jpg", file);
    }catch (IOException e)
    {
      throw new FileHandlingException("Error in file creation");
    }
  }
}
