package model;

import java.util.Arrays;

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

  public ImageObj greyScaleRed(ImageObj obj)
  {
    int[][][] image=new int[height][width][3];
    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        for(int k=0;k<3;k++)
        {
          image[i][j][k]=this.image[i][j][0];
        }
      }
    }
    return new ImageObj(image,this.height,this.width,this.maxValue);
  }

  @Override
  public String toString() {
    StringBuffer result=new StringBuffer();
    for(int i=0;i<height;i++)
    {
      for(int j=0;j<width;j++)
      {
        for(int k=0;k<3;k++)
        {
          result.append(image[i][j][k]+"\n");
        }
      }
    }
    return result.toString();
//    return "ImageObj{" +
//        "image=" + Arrays.toString(image) +
//        ", width=" + width +
//        ", height=" + height +
//        '}';
  }
  public ImageObj load(String filePath)
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
    obj=obj.load("/Users/srinidhisunkara/Desktop/pdp/projects/Assignment4/PDP/Assignment4/code/KoalaNew.ppm");
//    System.out.println(obj.toString());
    System.out.println((obj.greyScaleRed(obj)).toString());
  }
}
