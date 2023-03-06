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
import model.PPMFile;
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


}
