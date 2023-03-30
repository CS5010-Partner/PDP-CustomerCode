package main;

import static org.junit.Assert.assertEquals;

import controller.ImgController;
import controller.ImgControllerImplAdvanced;
import controller.file.BMPFile;
import controller.file.IFile;
import controller.file.JPEGFile;
import controller.file.PNGFile;
import controller.file.PPMFile;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import model.ImageObj;
import model.ImageSetAdvanced;
import org.junit.Test;
import view.IViewAdvanced;
import view.ViewAdvanced;

/**
 * Class to test the end to end functionality of the code for the newer implementation.
 */
public class MainTestAdvanced {

  private ImageSetAdvanced model;
  private IViewAdvanced view;
  private ImgController controller;

  public MainTestAdvanced() {
    model = new ImageSetAdvanced();
    view = new ViewAdvanced(new BufferedWriter(new OutputStreamWriter(System.out)));
  }

  private IFile getFileObj(String s) {
    String[] sp = s.split("\\.");

    switch (sp[sp.length - 1]) {
      case "ppm":
        System.out.println("ppm");
        return new PPMFile(s);
      case "png":
        System.out.println("png");
        return new PNGFile(s);
      case "jpg":
        System.out.println("jpg");
        return new JPEGFile(s);
      case "bmp":
        System.out.println("bmp");
        return new BMPFile(s);
      default:
        return null;
    }
  }

  private boolean checkTwoImages(String[] s1, String[] s2)
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {

    boolean check = true;
    for (int i = 0; i < s1.length; i++) {
      IFile img1 = getFileObj(s1[i]);
      String ref1 = "ref1" + i;
      ImageObj obj1 = model.load(img1, ref1);

      for (int j = 0; j < s2.length; j++) {
        IFile img2 = getFileObj(s2[j]);
        String ref2 = "ref2" + j;

        ImageObj obj2 = model.load(img2, ref2);

        if (obj1.getHeight() != obj2.getHeight() || obj1.getWidth() != obj2.getWidth()) {
          System.out.println(i);
          return false;
        }

        check = check && Arrays.deepEquals(obj1.getMatrix(), obj2.getMatrix());
        System.out.println(check + " : " + i + " - " + j);

      }
    }
    return check;
  }

  @Test
  public void loadTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\nsave res/loadTest.ppm i1\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true,
        checkTwoImages(new String[]{"res/img1orig.ppm"}, new String[]{"res/loadTest.ppm"}));
  }

  @Test
  public void loadWithSpaceTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load      res/img1orig.ppm     i1\n    save     res/loadWithSpaceTest.ppm"
        + "       i1\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true, checkTwoImages(new String[]{"res/img1orig.ppm"},
        new String[]{"res/loadWithSpaceTest.ppm"}));
  }

  @Test
  public void loadRepeatNameTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\nsave res/loadRepeatNameTest.ppm i1\nload "
        + "res/img2orig.ppm i1\nsave res/loadRepeatNameTest.ppm i1\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(false, checkTwoImages(new String[]{"res/img2orig.ppm"},
        new String[]{"res/loadRepeatNameTest.ppm"}));
  }

  @Test(expected = FileHandlingException.class)
  public void saveWrongNameTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\nsave res/saveWrongNameTest.ppm i2\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(false, checkTwoImages(new String[]{"res/img1orig.ppm"},
        new String[]{"res/saveWrongNameTest.ppm"}));
  }

  @Test
  public void saveSamePathTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\nsave res/saveSamePathTest.ppm i1\nload "
        + "res/img2orig.ppm i2\nsave res/saveSamePathTest.ppm i2\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true,
        checkTwoImages(new String[]{"res/img2orig.ppm"}, new String[]{"res/saveSamePathTest.ppm"}));
  }

  @Test
  public void saveSamePathWrongNameTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\nsave res/saveSamePathTest.ppm i1\nload "
        + "res/img2orig.ppm i2\nsave res/saveSamePathTest.ppm i3\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(false,
        checkTwoImages(new String[]{"res/img2orig.ppm"}, new String[]{"res/saveSamePathTest.ppm"}));
  }

  @Test
  public void greyScaleTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "load res/img1orig.png i11\n";
    test += "greyscale i1 i1g\n";
    test += "greyscale i11 i1g1\n";

    test += "save res/greyScale.ppm i1g\n";
    test += "save res/greyScale.png i1g\n";
    test += "save res/greyScale.jpg i1g1\n";
    test += "save res/greyScale.bmp i1g1\n";

    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true,
        checkTwoImages(new String[]{"res/greyScale.ppm"}, new String[]{"res/greyScale.png"}));
  }

  @Test
  public void sepiaTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "load res/img1orig.jpg i11\n";
    test += "sepia i1 i1g\n";
    test += "sepia i11 i1g1\n";

    test += "save res/sepia.ppm i1g\n";
    test += "save res/sepia.png i1g\n";
    test += "save res/sepia.jpg i1g1\n";
    test += "save res/sepia.bmp i1g1\n";

    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true,
        checkTwoImages(new String[]{"res/sepia.ppm"}, new String[]{"res/sepia.png"}));
  }

  @Test
  public void ditherTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "load res/img1orig.jpg i11\n";
    test += "dither i1 i1g\n";
    test += "dither i11 i1g1\n";

    test += "save res/dither.ppm i1g\n";
    test += "save res/dither.png i1g\n";
    test += "save res/dither.jpg i1g1\n";
    test += "save res/dither.bmp i1g1\n";

    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true,
        checkTwoImages(new String[]{"res/sepia.ppm"}, new String[]{"res/sepia.png"}));
  }

  @Test
  public void blurTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "load res/img1orig.jpg i11\n";
    test += "blur i1 i1g\n";
    test += "blur i11 i1g1\n";

    test += "save res/blur.ppm i1g\n";
    test += "save res/blur.png i1g\n";
    test += "save res/blur.jpg i1g1\n";
    test += "save res/blur.bmp i1g1\n";

    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true,
        checkTwoImages(new String[]{"res/blur.ppm"}, new String[]{"" + "res/blur.png"}));
  }

  @Test
  public void sharpenTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "load res/img1orig.jpg i11\n";
    test += "sharpen i1 i1g\n";
    test += "sharpen i11 i1g1\n";

    test += "save res/sharpen.ppm i1g\n";
    test += "save res/sharpen.png i1g\n";
    test += "save res/sharpen.jpg i1g1\n";
    test += "save res/sharpen.bmp i1g1\n";

    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImplAdvanced(model, view, reader);
    this.controller.run();

    assertEquals(true,
        checkTwoImages(new String[]{"res/sharpen.ppm"}, new String[]{"res/sharpen.png"}));
  }
}