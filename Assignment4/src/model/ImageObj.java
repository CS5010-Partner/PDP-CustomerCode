package model;

public class ImageObj {
  private int[][][] image;
  private int width;

  private int height;
  private int maxValue;

  public ImageObj(int[][][] image, int width, int height,int maxValue) {
    this.image = image;
    this.width = width;
    this.height = height;
    this.maxValue=maxValue;
  }
  public ImageObj()
  {

  }
  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int[][][] getImage() {
    return image;
  }

  public int getMaxValue() {
    return maxValue;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("P3\n");
    s.append(this.width+"\n");
    s.append(this.height+"\n");
    s.append(this.maxValue+"\n");
    for (int i=0; i<this.height; i++) {
      for (int j=0; j<this.width; j++) {
        for (int k=0; k<3;k++) {
          s.append(this.image[i][j][k] + "\n");
        }
      }
    }
    return s.toString();
  }

  public ImageObj greyScaleRed()
  {
    int[][][] image=new int[height][width][3];
    helperGrey(image,0);
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }
  public ImageObj greyScaleGreen()
  {
    int[][][] image=new int[height][width][3];
    helperGrey(image,1);
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }

  public ImageObj greyScaleBlue()
  {
    int[][][] image=new int[height][width][3];
    helperGrey(image,2);
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }
  private void helperGrey(int[][][] image,int index)
  {
    for (int i=0;i<this.height;i++) {
      for (int j=0;j<this.width;j++) {
        for(int k=0;k<3;k++)
        {
          image[i][j][k]=this.image[i][j][index];
        }
      }
    }
  }

  public ImageObj greyScaleValue()
  {
    int[][][] image=new int[height][width][3];
    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        int max=Math.max(this.image[i][j][0],Math.max(this.image[i][j][1],this.image[i][j][2]));
        for(int k=0;k<3;k++)
        {
          image[i][j][k]=max;
        }
      }
    }
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }

  public ImageObj greyScaleIntensity()
  {
    int[][][] image=new int[height][width][3];
    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        int avg=(this.image[i][j][0]+this.image[i][j][1]+this.image[i][j][2])/3;
        for(int k=0;k<3;k++)
        {
          image[i][j][k]=avg;
        }
      }
    }
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }

  public ImageObj greyScaleLUMA()
  {
    int[][][] image=new int[height][width][3];
    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        double luma=0.2126*(double)this.image[i][j][0]+0.7152 * (double) this.image[i][j][1]+0.0722*(double) this.image[i][j][2];
        for(int k=0;k<3;k++)
        {
          image[i][j][k]=(int)luma;
        }
      }
    }
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }

  public ImageObj brighten(int increment)
  {
    int[][][] image=new int[height][width][3];
    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        for(int k=0;k<3;k++)
        {
          int val=this.image[i][j][k]+increment;
          val=val<0?0:val;
          val=val>this.maxValue?this.maxValue:val;
          image[i][j][k]=val;
        }
      }
    }
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }

  public ImageObj[] rgbSplit()
  {
    ImageObj[] result=new ImageObj[3];
    result[0]=this.greyScaleRed();
    result[1]=this.greyScaleGreen();
    result[2]=this.greyScaleBlue();
    return result;
  }

  public ImageObj rgbCombine(ImageObj green, ImageObj blue)
  {
    int[][][] image=new int[this.height][this.width][3];

    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        image[i][j][0] = this.image[i][j][0];
        image[i][j][1] = green.getImage()[i][j][1];
        image[i][j][2] = blue.getImage()[i][j][2];
      }
    }
    return new ImageObj(image,this.width,this.height,this.maxValue);
  }

  private void swap(int[][][] imgArr, int i1, int j1, int i2, int j2) {

    for (int k=0; k<3; k++) {
      int temp = imgArr[i1][j1][k];
      imgArr[i1][j1][k] = imgArr[i2][j2][k];
      imgArr[i2][j2][k] = temp;
    }


  }

  public ImageObj verticalFlip() {
    int newImgArr[][][] = new int[this.height][this.width][3];

    for (int i=0; i<this.height; i++) {
      for (int j=0; j<this.width; j++) {
        for (int k=0; k<3;k++) {
            newImgArr[this.height - i - 1][j][k] = this.image[i][j][k];
        }
      }
    }
    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }
  public ImageObj horizontalFlip() {
    int newImgArr[][][] = new int[this.height][this.width][3];

    for (int i=0; i<this.height; i++) {
      for (int j=0; j<this.width; j++) {
        for (int k=0; k<3;k++) {
            newImgArr[i][this.width-j-1][k] = this.image[i][j][k];
        }
      }
    }

    return new ImageObj(newImgArr, this.width, this.height, this.maxValue);
  }

}
