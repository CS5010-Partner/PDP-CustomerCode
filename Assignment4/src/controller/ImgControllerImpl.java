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
import java.util.Scanner;
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

  private String getInput(Scanner sc) throws IllegalStateException {
    String input = sc.next();
    if (input.equals("#")) {
      throw new IllegalStateException("Quit command has been entered.");
    }
    return input;
  }

  @Override
  public void go() throws IllegalAccessException {
    Scanner sc = new Scanner(this.in);
    System.out.println("Enter the command");
    try {
      while (true) {
        String cmd = getInput(sc);
        switch (cmd) {
          case "load":
            Load load = new Load(model, view, sc);
            load.execute();

            break;

          case "save":
            Save save = new Save(model, view, sc);
            save.execute();
            break;

          case "greyscale":
            GreyScale greyScale = new GreyScale(model, view, sc);
            greyScale.execute();
            break;

          case "brighten":
            Brighten brighten = new Brighten(model, view, sc);
            brighten.execute();
            break;

          case "vertical-flip":
            VerticalFlip verticalFlip = new VerticalFlip(model, view, sc);
            verticalFlip.execute();
            break;

          case "horizontal-flip":
            HorizontalFlip horizontalFlip = new HorizontalFlip(model, view, sc);
            horizontalFlip.execute();
            break;

          case "rgb-split":
            RGBSplit rgbSplit = new RGBSplit(model, view, sc);
            rgbSplit.execute();
            break;
          case "rgb-combine":
            RGBCombine rgbCombine = new RGBCombine(model, view, sc);
            rgbCombine.execute();
            break;
          case "#":
            System.out.println("Program exited successfully");
            break;
          default:
            System.out.println("Please Enter A Valid Input");
        }
      }
    } catch (IllegalStateException e) {
      System.out.println("Program exited successfully");
    }


  }
}