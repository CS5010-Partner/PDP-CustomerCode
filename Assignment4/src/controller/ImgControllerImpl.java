package controller;

import commands.Brighten;
import commands.GreyScale;
import commands.HorizontalFlip;
import commands.Load;
import commands.RGBCombine;
import commands.RGBSplit;
import commands.Save;
import commands.VerticalFlip;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.FileHandlingException;
import model.IFile;
import model.IImage;
import view.IView;

public class ImgControllerImpl implements ImgController {

  private final IView view;
  private IImage model;
  private InputStream in;
  private OutputStream out;

  public ImgControllerImpl(IImage model, IView view, InputStream in, OutputStream out) {
    this.model = model;
    this.view = view;
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
            Load load = new Load(model, view, sc);
            load.execute();
            System.out.println("Image loaded sucessfully.");


            break;

          case "save":
            Save save = new Save(model, view, sc);
            save.execute();
            System.out.println("Image saved successfully.");

            break;

          case "greyscale":
            GreyScale greyScale = new GreyScale(model, view, sc);
            greyScale.execute();
            System.out.println("Image converted to greyscale successfully.");

            break;

          case "brighten":
            Brighten brighten = new Brighten(model, view, sc);
            brighten.execute();
            System.out.println("Image brightened successfully.");

            break;

          case "vertical-flip":
            VerticalFlip verticalFlip = new VerticalFlip(model, view, sc);
            verticalFlip.execute();
            System.out.println("Image flipped successfully.");

            break;

          case "horizontal-flip":
            HorizontalFlip horizontalFlip = new HorizontalFlip(model, view, sc);
            horizontalFlip.execute();
            System.out.println("Image flipped successfully.");

            break;

          case "rgb-split":
            RGBSplit rgbSplit = new RGBSplit(model, view, sc);
            rgbSplit.execute();
            System.out.println("Image splitted successfully.");

            break;

          case "rgb-combine":
            RGBCombine rgbCombine = new RGBCombine(model, view, sc);
            rgbCombine.execute();
            System.out.println("Image combined successfully.");

            break;
          case "#":
            System.out.println("Program exited successfully");
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
