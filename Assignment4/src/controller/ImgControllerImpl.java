package controller;

import commands.Brighten;
import commands.GreyScale;
import commands.HorizontalFlip;
import commands.Load;
import commands.RGBCombine;
import commands.RGBSplit;
import commands.Save;
import commands.VerticalFlip;
import helper.CloseCmdLineException;
import helper.Helper;
import helper.WrongCommandException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import helper.FileHandlingException;
import model.IImage;
import view.IView;

public class ImgControllerImpl extends Helper implements ImgController {

  private final IView view;
  private IImage model;
  private BufferedReader in;
  private BufferedWriter out;

  public ImgControllerImpl(IImage model, IView view, BufferedReader in, BufferedWriter out) {
    this.model = model;
    this.view = view;
    this.in = in;
    this.out = out;
  }

  @Override
  public void go() {
    System.out.println("Enter the command");

    while (true) {
      try {
        String cmd = getInput(in);
        switch (cmd) {
          case "load":
            Load load = new Load(model, view, in);
            load.execute();
            System.out.println("Image loaded sucessfully.");

            break;

          case "save":
            Save save = new Save(model, view, in);
            save.execute();
            System.out.println("Image saved successfully.");

            break;

          case "greyscale":
            GreyScale greyScale = new GreyScale(model, view, in);
            greyScale.execute();
            System.out.println("Image converted to greyscale successfully.");

            break;

          case "brighten":
            Brighten brighten = new Brighten(model, view, in);
            brighten.execute();
            System.out.println("Image brightened successfully.");

            break;

          case "vertical-flip":
            VerticalFlip verticalFlip = new VerticalFlip(model, view, in);
            verticalFlip.execute();
            System.out.println("Image flipped successfully.");

            break;

          case "horizontal-flip":
            HorizontalFlip horizontalFlip = new HorizontalFlip(model, view, in);
            horizontalFlip.execute();
            System.out.println("Image flipped successfully.");

            break;

          case "rgb-split":
            RGBSplit rgbSplit = new RGBSplit(model, view, in);
            rgbSplit.execute();
            System.out.println("Image splitted successfully.");

            break;
          case "rgb-combine":
            RGBCombine rgbCombine = new RGBCombine(model, view, in);
            rgbCombine.execute();
            System.out.println("Image combined successfully.");
            break;

          default:
            System.out.println("Please Enter A Valid Input");
        }

      } catch (CloseCmdLineException e) {
        System.out.println("Program exited successfully");
        break;
      } catch (IllegalAccessException | NoSuchElementException | WrongCommandException |
               FileHandlingException e) {
        System.out.println(e.getMessage() + " Please enter the command again.");
      } catch (IOException e) {
        System.out.println();
      }
    }
  }


}
