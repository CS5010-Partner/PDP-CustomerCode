package controller;

import com.sun.security.jgss.GSSUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.FileHandlingException;
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

  private String getInput(Scanner sc) throws CloseCmdLineException {
    String input = sc.next();
    if (input.equals("#")) {
      throw new CloseCmdLineException("Quit command has been entered.");
    }
    return input;
  }

  @Override
  public void go() {
    Scanner sc = new Scanner(this.in);
    System.out.println("Enter the command");
    while (true) {
      try {
        String cmd = getInput(sc);
        switch (cmd) {
          case "load":
            loadHelper(sc);
            System.out.println("Image loaded sucessfully.");
            break;

          case "save":
            saveHelper(sc);
            System.out.println("Image saved successfully.");
            break;

          case "greyscale":
            greyHelper(sc);
            System.out.println("Image converted to greyscale successfully.");
            break;

          case "brighten":
            brightenHelper(sc);
            System.out.println("Image brightened successfully.");
            break;

          case "vertical-flip":
            verticalFlipHelper(sc);
            System.out.println("Image flipped successfully.");
            break;

          case "horizontal-flip":
            horizontalFlipHelper(sc);
            System.out.println("Image flipped successfully.");
            break;

          case "rgb-split":
            rgbSplitHelper(sc);
            System.out.println("Image splitted successfully.");
            break;

          case "rgb-combine":
            rgbCombineHelper(sc);
            System.out.println("Image combined successfully.");
            break;
          default:
            System.out.println("Please Enter A Valid Input");
        }

      } catch (CloseCmdLineException e) {
        System.out.println("Program exited successfully");
        break;
      } catch (IllegalAccessException | NoSuchElementException | WrongCommandException | FileHandlingException e) {
        System.out.println(e.getMessage() + " Please enter the command again.");
      }
    }
  }

  void loadHelper(Scanner sc)
      throws CloseCmdLineException, IllegalAccessException, FileHandlingException {
    String imagePath = sc.next();
    String imageName = sc.next();
    model.load(imagePathHelper(imagePath), imageName);
  }

  void saveHelper(Scanner sc) throws IllegalAccessException, CloseCmdLineException {
    String imagePath = getInput(sc);
    String imageName = getInput(sc);
    model.save(imagePathHelper(imagePath), imageName);
  }

  void brightenHelper(Scanner sc)
      throws CloseCmdLineException, IllegalAccessException, WrongCommandException {
    int in;
    String increment = getInput(sc);
    String sourceName = getInput(sc);
    String destName = getInput(sc);

    try {
      in = Integer.parseInt(increment);
    } catch (NumberFormatException e) {
      throw new WrongCommandException("Please enter a valid Integer for increment value.");
    }

    model.brighten(in, sourceName, destName);
  }

  void verticalFlipHelper(Scanner sc) throws CloseCmdLineException, IllegalAccessException {
    String sourceName = getInput(sc);
    String destName = getInput(sc);
    model.verticalFlip(sourceName, destName);
  }

  void horizontalFlipHelper(Scanner sc) throws CloseCmdLineException, IllegalAccessException {
    String sourceName = getInput(sc);
    String destName = getInput(sc);
    model.horizontalFlip(sourceName, destName);
  }

  void rgbSplitHelper(Scanner sc) throws CloseCmdLineException, IllegalAccessException {
    String imageName = getInput(sc);
    String redImg = getInput(sc);
    String greenImg = getInput(sc);
    String blueImg = getInput(sc);
    model.rgbSplit(imageName, redImg, greenImg, blueImg);
  }

  void rgbCombineHelper(Scanner sc) throws CloseCmdLineException, IllegalAccessException {
    String imageName = getInput(sc);
    String redImg = getInput(sc);
    String greenImg = getInput(sc);
    String blueImg = getInput(sc);
    model.rgbCombine(imageName, redImg, greenImg, blueImg);
  }


  void greyHelper(Scanner sc)
      throws CloseCmdLineException, IllegalAccessException, NoSuchElementException, WrongCommandException {
    String value = getInput(sc).toLowerCase();
    String sourceName = getInput(sc);
    String destName = getInput(sc);

    switch (value) {
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
        throw new WrongCommandException("Please enter a valid metric for greyscale conversion.");
    }
  }

  IFile imagePathHelper(String imagePath) {
    return new PPMFile(imagePath);
  }
}

// 