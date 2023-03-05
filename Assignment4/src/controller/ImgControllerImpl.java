package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import model.IFile;
import model.IImage;
import model.PPMFile;

public class ImgControllerImpl implements ImgController {

  private IImage model;
  private InputStream in;
  private OutputStream out;

  public ImgControllerImpl(IImage model, InputStream in, OutputStream out) {
    this.model = model;
    this.in = in;
    this.out = out;
  }

  private String getInput(Scanner sc) throws IllegalStateException {
    String input = sc.next();
    if (input.equals("#")) {
      throw new IllegalStateException("Quit command has been entered.");
    }
    return input;
  }

  /***
   * Whassu[
   * @throws IllegalAccessException
   */

  @Override
  public void go() throws IllegalAccessException {
    Scanner sc = new Scanner(this.in);
    System.out.println("Enter the command");
    try {
      while (true) {
        String cmd = getInput(sc);
        switch (cmd) {
          case "load":
            loadHelper(sc);
            break;

          case "save":
            saveHelper(sc);
            break;

          case "greyscale":
            greyHelper(sc);
            break;

          case "brighten":
            brightenHelper(sc);
            break;

          case "vertical-flip":
            verticalFlipHelper(sc);
            break;

          case "horizontal-flip":
            horizontalFlipHelper(sc);
            break;

          case "rgb-split":
            rgbSplitHelper(sc);
            break;

          case "rgb-combine":
            rgbCombineHelper(sc);
            break;
          case "#":
            rgbCombineHelper(sc);
            break;
          default:
            System.out.println("Please Enter A Valid Input");
        }
      }
    } catch (IllegalStateException e) {
      System.out.println("Program exited successfully");
    }


  }

  void loadHelper(Scanner sc) throws IllegalAccessException {
    String imagePath = sc.next();
    String imageName = sc.next();
    model.load(imagePathHelper(imagePath), imageName);
  }

  void saveHelper(Scanner sc) {
    String imagePath = getInput(sc);
    String imageName = getInput(sc);
    model.save(imagePathHelper(imagePath), imageName);
  }

  void brightenHelper(Scanner sc) throws IllegalAccessException {
    int in;
    while (true) {
      try {
        String increment = getInput(sc);
        in = Integer.parseInt(increment);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Please Enter A Valid Integer");
      }
    }
    String sourceName = getInput(sc);
    String destName = getInput(sc);
    model.brighten(in, sourceName, destName);
  }

  void verticalFlipHelper(Scanner sc) throws IllegalAccessException {
    String sourceName = getInput(sc);
    String destName = getInput(sc);
    model.verticalFlip(sourceName, destName);
  }

  void horizontalFlipHelper(Scanner sc) throws IllegalAccessException {
    String sourceName = getInput(sc);
    String destName = getInput(sc);
    model.horizontalFlip(sourceName, destName);
  }

  void rgbSplitHelper(Scanner sc) throws IllegalAccessException {
    String imageName = getInput(sc);
    String redImg = getInput(sc);
    String greenImg = getInput(sc);
    String blueImg = getInput(sc);
    model.rgbSplit(imageName, redImg, greenImg, blueImg);
  }

  void rgbCombineHelper(Scanner sc) throws IllegalAccessException {
    String imageName = getInput(sc);
    String redImg = getInput(sc);
    String greenImg = getInput(sc);
    String blueImg = getInput(sc);
    model.rgbCombine(imageName, redImg, greenImg, blueImg);
  }


  void greyHelper(Scanner sc) throws IllegalAccessException {
    String value = getInput(sc).toLowerCase();
    String sourceName = getInput(sc);
    String destName = getInput(sc);

    switch (value.toLowerCase()) {
      case "red":
        model.greyScaleRed(sourceName, destName);
        break;

      case "green":
        model.greyScaleGreen(sourceName, destName);
        break;

      case "blue":
        model.greyScaleBlue(sourceName, destName);
        break;

      case "value":
        model.greyScaleValue(sourceName, destName);
        break;

      case "intensity":
        model.greyScaleIntensity(sourceName, destName);
        break;

      case "luma":
        model.greyScaleLuma(sourceName, destName);
        break;

      default:
        System.out.println("Please Enter the Command Again");
    }
  }

  IFile imagePathHelper(String imagePath) {
    return new PPMFile(imagePath);
  }
}

// 