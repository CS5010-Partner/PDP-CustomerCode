package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;
import model.IFile;
import model.IImage;
import model.PPMFile;

public class ImgControllerImpl implements ImgController{
  private IImage model;
  private InputStream in;
  private OutputStream out;


  public ImgControllerImpl(IImage model, InputStream in, OutputStream out) {
    this.model = model;
    this.in = in;
    this.out = out;
  }


  public void go() throws IllegalAccessException {
    Scanner sc = new Scanner(this.in);
    System.out.println("Enter the command");
    boolean flag=true;
    while (flag) {
      String cmd=sc.next();
      switch (cmd) {
        case "load":
          flag=loadHelper(sc);
          break;
        case "save":
          flag=saveHelper(sc);
          break;
        case "greyscale":
          flag=greyHelper(sc);
          break;
        case "brighten":
          flag=brightenHelper(sc);
          break;
        case "vertical-flip":
          flag=verticalFlipHelper(sc);
          break;
        case "horizontal-flip":
          flag=horizontalFlipHelper(sc);
          break;
        case "rgb-split":
          flag=rgbSplitHelper(sc);
          break;
        case "rgb-combine":
          flag=rgbCombineHelper(sc);
          break;
        case "#":
          flag=false;
          break;
        default:
          System.out.println("Please Enter A Valid Input");
      }
    }

  }
  boolean loadHelper(Scanner sc) throws IllegalAccessException {
    String imagePath=sc.next();
    if(imagePath.equals("#")) return false;
    String imageName=sc.next();
    if(imageName.equals("#")) return false;
    model.load(imagePathHelper(imagePath),imageName);
    return true;
  }

  boolean saveHelper(Scanner sc)
  {
    String imagePath=sc.next();
    if(imagePath.equals("#")) return false;
    String imageName=sc.next();
    if(imageName.equals("#")) return false;
    model.save(imagePathHelper(imagePath),imageName);
    return true;
  }

  boolean brightenHelper(Scanner sc) throws IllegalAccessException {
    int in=0;
    while (true)
      try {
        String increment = sc.next();
        if (increment.equals("#"))
          return false;
        in = Integer.parseInt(increment);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Please Enter A Valid Integer");
      }
    String sourceName=sc.next();
    if(sourceName.equals("#")) return false;
    String destName=sc.next();
    if(destName.equals("#")) return false;
    model.brighten(in,sourceName,destName);
    return true;
  }
  boolean verticalFlipHelper(Scanner sc) throws IllegalAccessException {
    String sourceName=sc.next();
    if(sourceName.equals("#")) return false;
    String destName=sc.next();
    if(destName.equals("#")) return false;
    model.verticalFlip(sourceName,destName);
    return true;
  }

  boolean horizontalFlipHelper(Scanner sc) throws IllegalAccessException {
    String sourceName=sc.next();
    if(sourceName.equals("#")) return false;
    String destName=sc.next();
    if(destName.equals("#")) return false;
    model.horizontalFlip(sourceName,destName);
    return true;
  }

  boolean rgbSplitHelper(Scanner sc) throws IllegalAccessException {
    String imageName=sc.next();
    if(imageName.equals("#")) return false;
    String redImg=sc.next();
    if(redImg.equals("#")) return false;
    String greenImg=sc.next();
    if(greenImg.equals("#")) return false;
    String blueImg=sc.next();
    if(blueImg.equals("#")) return false;
    model.rgbSplit(imageName,redImg,greenImg,blueImg);
    return true;
  }

  boolean rgbCombineHelper(Scanner sc) throws IllegalAccessException {
    String imageName=sc.next();
    if(imageName.equals("#")) return false;
    String redImg=sc.next();
    if(redImg.equals("#")) return false;
    String greenImg=sc.next();
    if(greenImg.equals("#")) return false;
    String blueImg=sc.next();
    if(blueImg.equals("#")) return false;
    model.rgbCombine(imageName,redImg,greenImg,blueImg);
    return true;
  }


  boolean greyHelper(Scanner sc) throws IllegalAccessException {
    String value=sc.next().toLowerCase();
    if (value.equals("#")) return false;

//    if(value.equals("#") ||(!value.equals("red")&&!value.equals("green")&&!value.equals("blue"))) return false;
    String sourceName=sc.next();
    if(sourceName.equals("#")) return false;
    String destName=sc.next();
    if(destName.equals("#")) return false;
    switch (value.toLowerCase()){
      case "red":
        model.greyScaleRed(sourceName,destName);
        break;
      case "green":
        model.greyScaleGreen(sourceName,destName);
        break;
      case "blue":
        model.greyScaleBlue(sourceName,destName);
        break;
      case "value":
        model.greyScaleValue(sourceName,destName);
        break;
      case "intensity":
        model.greyScaleIntensity(sourceName,destName);
        break;
      case "luma":
        model.greyScaleLuma(sourceName,destName);
        break;
      default:
        System.out.println("Please Enter the Command Again");
    }
    return true;
  }

  IFile imagePathHelper(String imagePath)
  {
    return new PPMFile(imagePath);
  }
}
