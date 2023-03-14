package model;

/**
 * This class represents the ImageObj which represents the image as an entity.
 * Here the images are stored in the form of a 3D integer array.
 * First 2 dimensions represent the pixel and the third dimension represents the RGB components.
 */
public class ImageObj {

  private int[][][] image;
  private int width;

  private int height;
  private int maxValue;

  /**
   * Constructor for the ImageObj class.
   * @param image gives value to the image array.
   * @param width represents the width of the image.
   * @param height represents the height of the image.
   * @param maxValue represents the maximum value any component can have.
   */
  public ImageObj(int[][][] image, int width, int height, int maxValue) {
    this.image = image;
    this.width = width;
    this.height = height;
    this.maxValue = maxValue;
  }

  /**
   * Returns the image matrix.
   * @return the integer matrix of the image.
   */
  public int[][][] getImage() {
    return image;
  }


  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("P3\n");
    s.append(this.width + "\n");
    s.append(this.height + "\n");
    s.append(this.maxValue + "\n");
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < 3; k++) {
          s.append(this.image[i][j][k] + "\n");
        }
      }
    }
    return s.toString();
  }

  /**
   * Returns the transformed greyscale red component image.
   * @return ImageObj of the transformed greyscale red image.
   */
  public ImageObj greyScaleRed() {
    int[][][] image = new int[height][width][3];
    helperGrey(image, 0);
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the transformed greyscale green component image.
   * @return ImageObj of the transformed greyscale green image.
   */
  public ImageObj greyScaleGreen() {
    int[][][] image = new int[height][width][3];
    helperGrey(image, 1);
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }
  /**
   * Returns the transformed greyscale blue component image.
   * @return ImageObj of the transformed greyscale blue image.
   */
  public ImageObj greyScaleBlue() {
    int[][][] image = new int[height][width][3];
    helperGrey(image, 2);
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  private void helperGrey(int[][][] image, int index) {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = this.image[i][j][index];
        }
      }
    }
  }

  /**
   * Returns the transformed greyscale value component image.
   * @return ImageObj of the transformed greyscale value image.
   */
  public ImageObj greyScaleValue() {
    int[][][] image = new int[height][width][3];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int max = Math.max(this.image[i][j][0], Math.max(this.image[i][j][1], this.image[i][j][2]));
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = max;
        }
      }
    }
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the transformed greyscale intensity component image.
   * @return ImageObj of the transformed greyscale intensity image.
   */
  public ImageObj greyScaleIntensity() {
    int[][][] image = new int[height][width][3];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int avg = (this.image[i][j][0] + this.image[i][j][1] + this.image[i][j][2]) / 3;
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = avg;
        }
      }
    }
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the transformed greyscale luma component image.
   * @return ImageObj of the transformed greyscale luma image.
   */
  public ImageObj greyScaleLUMA() {
    int[][][] image = new int[height][width][3];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        double luma = 0.2126 * (double) this.image[i][j][0] + 0.7152 * (double) this.image[i][j][1]
            + 0.0722 * (double) this.image[i][j][2];
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = (int) luma;
        }
      }
    }
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the brightens image of the current image object.
   * @param increment the factor which is spplied on all the component parts.
   * @return the brightened image.
   */
  public ImageObj brighten(int increment) {
    int[][][] image = new int[height][width][3];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          int val = this.image[i][j][k] + increment;
          val = val < 0 ? 0 : val;
          val = val > this.maxValue ? this.maxValue : val;
          image[i][j][k] = val;
        }
      }
    }
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Splits the image into red, green, and blue componenets.
   * @return the ImageObj array of three components.
   */
  public ImageObj[] rgbSplit() {
    ImageObj[] result = new ImageObj[3];
    result[0] = this.greyScaleRed();
    result[1] = this.greyScaleGreen();
    result[2] = this.greyScaleBlue();
    return result;
  }

  /**
   * Combines three channels into an image.
   * @param green represents the green channel image.
   * @param blue represents the blue channel image.
   * @return the ImageObj of the combined image.
   */
  public ImageObj rgbCombine(ImageObj green, ImageObj blue) {
    int[][][] image = new int[this.height][this.width][3];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        image[i][j][0] = this.image[i][j][0];
        image[i][j][1] = green.getImage()[i][j][1];
        image[i][j][2] = blue.getImage()[i][j][2];
      }
    }
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  private void swap(int[][][] imgArr, int i1, int j1, int i2, int j2) {

    for (int k = 0; k < 3; k++) {
      int temp = imgArr[i1][j1][k];
      imgArr[i1][j1][k] = imgArr[i2][j2][k];
      imgArr[i2][j2][k] = temp;
    }


  }

  /**
   * Returns the vertically flipped image of the current image.
   * @return the ImageObj of the vertically flipped image.
   */
  public ImageObj verticalFlip() {
    int newImgArr[][][] = new int[this.height][this.width][3];

    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < 3; k++) {
          newImgArr[this.height - i - 1][j][k] = this.image[i][j][k];
        }
      }
    }
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

  /**
   *  Returns the horizontally flipped image of the current image.
   *  @return the ImageObj of the horizontally flipped image.
   */
  public ImageObj horizontalFlip() {
    int newImgArr[][][] = new int[this.height][this.width][3];

    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < 3; k++) {
          newImgArr[i][this.width - j - 1][k] = this.image[i][j][k];
        }
      }
    }

    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

}
