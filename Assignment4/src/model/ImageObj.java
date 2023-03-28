package model;

import java.awt.Image;

/**
 * This class represents the ImageObj which represents the image as an entity. Here the images are
 * stored in the form of a 3D integer array. First 2 dimensions represent the pixel and the third
 * dimension represents the RGB components.
 */
public class ImageObj {

  protected final int[][][] image;
  protected final int width;

  protected final int height;
  protected final int maxValue;

  /**
   * Constructor for the ImageObj class.
   *
   * @param image    gives value to the image array.
   * @param width    represents the width of the image.
   * @param height   represents the height of the image.
   * @param maxValue represents the maximum value any component can have.
   */
  public ImageObj(int[][][] image, int width, int height, int maxValue) {
    this.image = image;
    this.width = width;
    this.height = height;
    this.maxValue = maxValue;
  }

  /**
   * Getter for extracting the height of the image.
   * @return  height in the integer format.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Getter for extracting the width of the image.
   * @return width in the integer format.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Getter for extracting the max value of the image.
   * @return max value in integer format.
   */
  public int getMaxValue() {
    return maxValue;
  }

  /**
   * Getter for extracting the image.
   * @return image in the matrix format.
   */

  public int[][][] getMatrix() {
    return image;
  }

  /**
   * Returns the image matrix.
   *
   * @return the integer matrix of the image.
   */
  public int[][][] getImage() {
    return image;
  }


  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
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
   *
   * @return ImageObj of the transformed greyscale red image.
   */
  public ImageObj greyScaleRed() {
    int[][][] image = new int[height][width][3];
    helperGrey(image, 0);
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the transformed greyscale green component image.
   *
   * @return ImageObj of the transformed greyscale green image.
   */
  public ImageObj greyScaleGreen() {
    int[][][] image = new int[height][width][3];
    helperGrey(image, 1);
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the transformed greyscale blue component image.
   *
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
   *
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
   *
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
   *
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
   *
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
   *
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
   *
   * @param green represents the green channel image.
   * @param blue  represents the blue channel image.
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



  /**
   * Returns the vertically flipped image of the current image.
   *
   * @return the ImageObj of the vertically flipped image.
   */
  public ImageObj verticalFlip() {
    int[][][] newImgArr = new int[this.height][this.width][3];

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
   * Returns the horizontally flipped image of the current image.
   *
   * @return the ImageObj of the horizontally flipped image.
   */
  public ImageObj horizontalFlip() {
    int[][][] newImgArr = new int[this.height][this.width][3];

    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < 3; k++) {
          newImgArr[i][this.width - j - 1][k] = this.image[i][j][k];
        }
      }
    }
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

  private int[][][] capValues(int[][][] img, int hardMax, int max, int min) {
    int height = img.length;
    int width = img[0].length;

    int m = 0;

    for (int i=0; i<height; i++) {
      for (int j=0; j<width; j++) {
        for (int k=0; k<3; k++) {
          if (img[i][j][k] > 255 || img[i][j][k] < 0) {
            double val = (double) (img[i][j][k] - min) / (max - min);
            val = val * hardMax;
            img[i][j][k] = (int) val;
            m = (int) Math.max(val, m);
          }
        }
      }
    }
    return img;
  }

  public ImageObj filtering(double[][] kernel){
    int[][][] newImgArr = new int[this.height][this.width][3];

    int ker_row= kernel.length;
    int ker_col=kernel[0].length;
    int channels=3;

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for(int ii=0;ii<this.height;ii++)
    {
      for(int ij=0;ij<this.width;ij++)
      {
        for(int ik=0;ik<channels;ik++)
        {
          double val=0;
          for(int ki=0;ki<ker_row;ki++)
          {
            for(int kj=0;kj<ker_col;kj++)
            {
              if (ii == 0 && ki ==0)
                continue;
              if (ij == 0 && kj == 0)
                continue;
              if (ii == this.height-1 && ki == ker_row-1)
                continue;
              if (ij == this.width-1 && kj == ker_col-1)
                continue;
              if (ii+ki >= this.height || ij+kj >= this.width)
                continue;
              val += this.image[ii+ki][ij+kj][ik] * kernel[ki][kj];
            }
            if (val > maxValue) {
              val = maxValue;
            }
            if (val < 0) {
              val = 0;
            }
            max = (int) Math.max(val, max);
            min = (int) Math.min(val, min);
            newImgArr[ii][ij][ik] = (int) val;
          }
        }
      }
    }
    newImgArr = capValues(newImgArr, this.maxValue, max, min);
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

  public ImageObj transformation(double[][] matrix) {
    int[][][] newImgArr = new int[this.height][this.width][3];

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int ii=0; ii<this.height; ii++) {
      for (int ij=0; ij<this.width; ij++) {
        double red = this.image[ii][ij][0];
        double green = this.image[ii][ij][1];
        double blue = this.image[ii][ij][2];

        for (int k=0; k<3; k++) {
          int val = (int) ((matrix[k][0] * red) + (matrix[k][1] * green) + (matrix[k][2] * blue));
          max = Math.max(val, max);
          min = Math.min(val, min);
          newImgArr[ii][ij][k] = val;
        }
      }
    }
    newImgArr = capValues(newImgArr, this.maxValue, max, min);
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

  public ImageObj dithering() {
    int[][][] newImgArr = new int[this.height][this.width][3];

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    ImageObj grey = transformation(transformations.getGreyScaleMatrix());

    for (int ii=0; ii<grey.height; ii++) {
      for (int ij=0; ij<grey.width; ij++) {
        for (int ik=0; ik<3; ik++) {
          int val = grey.image[ii][ij][ik];
          int newVal = (val > 127) ? 255:0;
          int error = val - newVal;

          newImgArr[ii][ij][ik] = newVal;

          if (ij+1 < grey.width) {
            int temp = newImgArr[ii][ij+1][ik];
            temp += (0.4375*error);
            newImgArr[ii][ij+1][ik] = temp;
            max = Math.max(temp, max);
            min = Math.min(temp, min);
          }

          if (ii+1 < grey.height && ij-1 > 0) {
            int temp = newImgArr[ii+1][ij-1][ik];
            temp += (0.1875*error);
            newImgArr[ii+1][ij-1][ik] = temp;
            max = Math.max(temp, max);
            min = Math.min(temp, min);
          }
          if (ii+1 < grey.height) {
            int temp = newImgArr[ii+1][ij][ik];
            temp += (0.3125*error);
            newImgArr[ii+1][ij][ik] = temp;
            max = Math.max(temp, max);
            min = Math.min(temp, min);
          }
          if (ii+1 < grey.height && ij+1 < grey.width) {
            int temp = newImgArr[ii+1][ij+1][ik];
            temp += (0.0625*error);
            newImgArr[ii+1][ij+1][ik] = temp;
            max   = Math.max(temp, max);
            min = Math.min(temp, min);
          }
        }
      }
    }
    newImgArr = capValues(newImgArr, this.maxValue, max, min);
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }
}
