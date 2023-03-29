package controller.commandsAdvanced;

import controller.commands.ACommand;
import controller.file.BMPFile;
import controller.file.IFile;
import controller.file.JPEGFile;
import controller.file.PNGFile;
import controller.file.PPMFile;
import exceptions.WrongCommandException;
import java.io.BufferedReader;
import model.IImage;
import view.IView;

public abstract class ACommandAdvanced extends ACommand {

  /**
   * Constructor for the ACommand class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    represents the input stream.
   */
  public ACommandAdvanced(IImage model, IView view, BufferedReader in) {
    super(model, view, in);
  }

  @Override
  protected IFile imagePathHelper(String imagePath) throws WrongCommandException {
    String[] fileType = imagePath.split("\\.");

    switch (fileType[fileType.length-1]) {
      case "jpg":
        return new JPEGFile(imagePath);
      case "ppm":
        return new PPMFile(imagePath);
      case "png":
        return new PNGFile(imagePath);
      case "bmp":
        return new BMPFile(imagePath);
      default:
        throw new WrongCommandException("The given file type is not supported");
    }
  }

}
