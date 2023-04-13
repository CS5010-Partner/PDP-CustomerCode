package model;

import java.util.HashMap;

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
   *
   * @return height in the integer format.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Getter for extracting the width of the image.
   *
   * @return width in the integer format.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Getter for extracting the max value of the image.
   *
   * @return max value in integer format.
   */
  public int getMaxValue() {
    return maxValue;
  }

  /**
   * Getter for extracting the image.
   *
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

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < 3; k++) {
          s.append(this.image[i][j][k]).append("\n");
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
   * @param increment the factor which is applied on all the component parts.
   * @return the brightened image.
   */
  public ImageObj brighten(int increment) {
    int[][][] image = new int[height][width][3];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          int val = this.image[i][j][k] + increment;
          val = Math.max(val, 0);
          val = Math.min(val, this.maxValue);
          image[i][j][k] = val;
        }
      }
    }
    return new ImageObj(image, this.width, this.height, this.maxValue);
  }

  /**
   * Splits the image into red, green, and blue components.
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
        image[i][j][1] = green.getMatrix()[i][j][1];
        image[i][j][2] = blue.getMatrix()[i][j][2];
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
        System.arraycopy(this.image[i][j], 0, newImgArr[this.height - i - 1][j], 0, 3);
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
        System.arraycopy(this.image[i][j], 0, newImgArr[i][this.width - j - 1],
            0, 3);
      }
    }
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

  private void capValues(int[][][] img, int hardMax, int max, int min) {
    int height = img.length;
    int width = img[0].length;

    int m = 0;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          if (img[i][j][k] > this.maxValue || img[i][j][k] < 0) {
            double val = (double) (img[i][j][k] - min) / (max - min);
            val = val * hardMax;
            img[i][j][k] = (int) val;
            m = (int) Math.max(val, m);
          }
        }
      }
    }
  }

  /**
   * Returns the filtered image based on the given kernel of the current image.
   *
   * @param kernel the kernel which is applied for the filtering.
   * @return ImageObj of the filtered image.
   */
  public ImageObj filtering(double[][] kernel) {
    int[][][] newImgArr = new int[this.height][this.width][3];

    int ker_row = kernel.length;
    int ker_mid = ker_row / 2;
    int channels = 3;

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int ii = 0; ii < this.height; ii++) {
      for (int ij = 0; ij < this.width; ij++) {
        for (int ik = 0; ik < channels; ik++) {
          double val = 0;
          for (int ki = -ker_mid; ki < ker_mid + 1; ki++) {
            for (int kj = -ker_mid; kj < ker_mid + 1; kj++) {
              if (ii + ki < 0 || ii + ki >= this.height) {
                continue;
              }
              if (ij + kj < 0 || ij + kj >= this.width) {
                continue;
              }
              val += this.image[ii + ki][ij + kj][ik] * kernel[ki + ker_mid][kj + ker_mid];
            }
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
    capValues(newImgArr, this.maxValue, max, min);
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the transformed image based on the given matrix of the current image.
   *
   * @param matrix the matrix which is used for transformation.
   * @return the ImageObj of the transformed image.
   */

  public ImageObj transformation(double[][] matrix) {
    int[][][] newImgArr = new int[this.height][this.width][3];

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int ii = 0; ii < this.height; ii++) {
      for (int ij = 0; ij < this.width; ij++) {
        double red = this.image[ii][ij][0];
        double green = this.image[ii][ij][1];
        double blue = this.image[ii][ij][2];

        for (int k = 0; k < 3; k++) {
          int val = (int) ((matrix[k][0] * red) + (matrix[k][1] * green) + (matrix[k][2] * blue));
          max = Math.max(val, max);
          min = Math.min(val, min);
          newImgArr[ii][ij][k] = val;
        }
      }
    }
    capValues(newImgArr, this.maxValue, max, min);
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

  /**
   * Returns the dithered image of the current image.
   *
   * @return ImageObj of the dithered form of the current image.
   */
  public ImageObj dithering() {
    ImageObj grey = transformation(Transformations.getGreyScaleMatrix());

    for (int i = 0; i < grey.height; i++) {
      for (int j = 0; j < grey.width; j++) {
        for (int k = 0; k < 3; k++) {
          int oldC = grey.image[i][j][0];
          int newC = 0;
          if (oldC > 127) {
            newC = 255;
          }

          double error = oldC - newC;

          grey.image[i][j][k] = newC;

          if ((j + 1) < grey.width) {
            grey.image[i][j + 1][k] += (int) ((7.0 / 16) * error);
          }

          if ((i + 1) < grey.height && (j - 1) >= 0) {
            grey.image[i + 1][j - 1][k] += (int) ((3.0 / 16) * error);
          }
          if ((i + 1) < grey.height) {
            grey.image[i + 1][j][k] += (int) ((5.0 / 16) * error);
          }
          if ((i + 1) < grey.height && (j + 1) < grey.width) {
            grey.image[i + 1][j + 1][k] += (int) ((1.0 / 16) * error);
          }
        }
      }
    }
    return new ImageObj(grey.image, this.width, this.height, this.maxValue);
    }

    private ImageObj generateHistogram(ImageObj img, int index) {
      int[][][] newImgArr = new int[256][256][3];
      double maxVal = -1;

      HashMap<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < img.height; i++) {
        for (int j = 0; j < img.width; j++) {
          int val = img.getMatrix()[i][j][index];
          if (map.containsKey(val)) {
            map.put(val, map.get(val) + 1);
            if (maxVal < map.get(val)) {
              maxVal = map.get(val);
            }
          } else {
            map.put(val, 1);
          }
        }
      }

      for (int i=0; i<255; i++) {
        if (!map.containsKey(i)) {
          map.put(i, 0);
        }
      }

      for (int i=1; i<255; i++) {
        int j1 = 255 - (int)(((map.get(i-1) - 0.0) / maxVal)*255.0);
        int j2 = 255 - (int)(((map.get(i) - 0.0) / maxVal)*255.0);

        newImgArr[j1][i-1][0] = 255;
        newImgArr[j1][i][0] = 255;

        newImgArr[j1][i-1][1] = 255;
        newImgArr[j1][i][1] = 255;

        newImgArr[j1][i-1][2] = 255;
        newImgArr[j1][i][2] = 255;

        if (j1>j2) {
          for (int c=j2; c<j1; c++) {
            newImgArr[c][i][0] = 100;
            newImgArr[c][i][1] = 100;
            newImgArr[c][i][2] = 100;
          }
        }
        else {
          for (int c=j1; c<j2; c++) {
            newImgArr[c][i][0] = 100;
            newImgArr[c][i][1] = 100;
            newImgArr[c][i][2] = 100;
          }
        }

      }

      return new ImageObj(newImgArr,256, 256, 255);

    }

    public ImageObj[] histograms() {
      ImageObj[] hist = new ImageObj[4];

      hist[0] = generateHistogram(this.greyScaleRed(), 0);
      hist[1] = generateHistogram(this.greyScaleGreen(), 0);
      hist[2] = generateHistogram(this.greyScaleBlue(), 0);
      hist[3] = generateHistogram(this.greyScaleIntensity(), 0);

      return hist;
    }

  }


