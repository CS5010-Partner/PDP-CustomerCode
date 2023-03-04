package model;

import java.util.Arrays;

public class ImageObj {
  private int[][][] image;
  private int width;

  public int[][][] getImage() {
    return image;
  }

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

  public ImageObj greyScaleRed(ImageObj obj)
  {
    int[][][] image=new int[height][width][3];
    helperGrey(image,0);
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }
  public ImageObj greyScaleGreen(ImageObj obj)
  {
    int[][][] image=new int[height][width][3];
    helperGrey(image,1);
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }

  public ImageObj greyScaleBlue(ImageObj obj)
  {
    int[][][] image=new int[height][width][3];
    helperGrey(image,2);
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }
  private void helperGrey(int[][][] image,int index)
  {
    for (int i=0;i<this.height;i++) {
      for (int j=0;j<this.width;j++) {
        for(int k=0;k<3;k++)
        {
          image[i][j][k]=this.image[i][j][index];
          System.out.println(image[i][j][k]);
        }
      }
    }
  }

  public ImageObj greyScaleValue(ImageObj obj)
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
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }

  public ImageObj greyScaleIntensity(ImageObj obj)
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
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }

  public ImageObj greyScaleLUMA(ImageObj obj)
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
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }

  public ImageObj brighten(ImageObj obj, int increment)
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
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }

  public ImageObj[] rgbSplit(ImageObj obj)
  {
    ImageObj[] result=new ImageObj[3];
    result[0]=this.greyScaleRed(obj);
    result[1]=this.greyScaleGreen(obj);
    result[2]=this.greyScaleBlue(obj);
    return result;
  }

  public ImageObj rgbCombine(ImageObj red,ImageObj green, ImageObj blue)
  {
    int[][][] image=new int[height][width][3];
    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {

        image[i][j][0]=red.getImage()[i][j][0];
        image[i][j][1]=green.getImage()[i][j][1];
        image[i][j][2]=blue.getImage()[i][j][2];

      }
    }
    return new ImageObj(image,this.height,this.width,this.maxValue);

  }
  public ImageObj _load(String filePath)
  {
    IFile obj=new PPMFile();
    String content=obj.fileRead(filePath);
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
    return new ImageObj(image,width,height,maxValue);
  }

  public static void main(String[] args) {
    ImageObj obj=new ImageObj();
    obj=obj._load("/Users/srinidhisunkara/Desktop/pdp/projects/Assignment4/PDP/Assignment4/code/Koala.ppm");
//    System.out.println((obj.toString()).substring(obj.toString().length()-20));
    System.out.println((obj.greyScaleValue(obj)));
  }
}
