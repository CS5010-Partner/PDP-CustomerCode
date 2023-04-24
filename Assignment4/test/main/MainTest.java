package main;

import static org.junit.Assert.assertEquals;

import controller.ImgController;
import controller.ImgControllerImpl;
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
import model.ImageSet;
import controller.file.IFile;
import controller.file.PPMFile;
import org.junit.Test;
import view.IView;
import view.View;

/**
 * Class to test the end to end functionality of the code.
 */
public class MainTest {

  private ImageSet model;
  private IView view;
  private ImgController controller;

  public MainTest() {
    model = new ImageSet();
    view = new View(new BufferedWriter(new OutputStreamWriter(System.out)));
  }

  private boolean checkTwoImages(String[] s1, String[] s2)
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {

    boolean check = true;
    for (int i = 0; i < s1.length; i++) {
      IFile img1 = new PPMFile(s1[i]);
      IFile img2 = new PPMFile(s2[i]);

      String ref1 = "ref1" + i;
      String ref2 = "ref2" + i;

      ImageObj obj1 = model.load(img1, ref1);
      ImageObj obj2 = model.load(img2, ref2);

      if (obj1.getHeight() != obj2.getHeight()
         || obj1.getWidth() != obj2.getWidth()) {
        return false;
      }

      check = check && Arrays.deepEquals(obj1.getMatrix(), obj2.getMatrix());
    }
    System.out.println(check);
    return check;
  }

  @Test
  public void loadTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\nsave res/loadTest.ppm i1\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImpl(model, view, reader);
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

    this.controller = new ImgControllerImpl(model, view, reader);
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

    this.controller = new ImgControllerImpl(model, view, reader);
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

    this.controller = new ImgControllerImpl(model, view, reader);
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

    this.controller = new ImgControllerImpl(model, view, reader);
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

    this.controller = new ImgControllerImpl(model, view, reader);
    this.controller.run();

    assertEquals(false,
        checkTwoImages(new String[]{"res/img2orig.ppm"}, new String[]{"res/saveSamePathTest.ppm"}));
  }

  @Test
  public void greyScaleTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "greyscale red i1 r1\n";
    test += "greyscale green i1 g1\n";
    test += "greyscale blue i1 b1\n";

    test += "save res/greyScaleTestRed.ppm r1\n";
    test += "save res/greyScaleTestGreen.ppm g1\n";
    test += "save res/greyScaleTestBlue.ppm b1\n";
    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImpl(model, view, reader);
    this.controller.run();

    assertEquals(true, checkTwoImages(
        new String[]{"res/img1greyRed.ppm", "res/img1greyGreen.ppm", "res/img1greyBlue.ppm"},
        new String[]{"res/greyScaleTestRed.ppm", "res/greyScaleTestGreen.ppm",
            "res/greyScaleTestBlue.ppm"}));
  }

  @Test
  public void brightenTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "brighten 50 i1 b1\n";
    test += "save res/brightenTest.ppm b1\n";
    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImpl(model, view, reader);
    this.controller.run();

    assertEquals(true, checkTwoImages(new String[]{"res/img1brighten2.ppm"},
        new String[]{"res/brightenTest.ppm"}));
  }


  @Test
  public void verticalFlipTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "vertical-flip i1 vf1\n";
    test += "save res/verticalFlipTest.ppm vf1\n";
    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImpl(model, view, reader);
    this.controller.run();

    assertEquals(true, checkTwoImages(new String[]{"res/img1vflip.ppm"},
        new String[]{"res/verticalFlipTest.ppm"}));
  }

  @Test
  public void horizontalFlipTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "horizontal-flip i1 vf1\n";
    test += "save res/horizontalFlipTest.ppm vf1\n";
    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImpl(model, view, reader);
    this.controller.run();

    assertEquals(true, checkTwoImages(new String[]{"res/img1hflip.ppm"},
        new String[]{"res/horizontalFlipTest.ppm"}));
  }

  @Test
  public void rgbSplitTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";
    test += "rgb-split i1 rs1 rs2 rs3\n";

    test += "save res/rgbSplitTest1.ppm rs1\n";
    test += "save res/rgbSplitTest2.ppm rs2\n";
    test += "save res/rgbSplitTest3.ppm rs3\n";

    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImpl(model, view, reader);
    this.controller.run();

    assertEquals(true, checkTwoImages(
        new String[]{"res/img1split1.ppm", "res/img1split2.ppm", "res/img1split3.ppm"},
        new String[]{"res/rgbSplitTest1.ppm", "res/rgbSplitTest2.ppm", "res/rgbSplitTest3.ppm"}));
  }

  @Test
  public void rgbCombineTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    String test = "load res/img1orig.ppm i1\n";

    test += "load res/rgbSplitTest1.ppm rs1\n";
    test += "load res/rgbSplitTest2.ppm rs2\n";
    test += "load res/rgbSplitTest3.ppm rs3\n";

    test += "rgb-combine rc rs1 rs2 rs3\n";

    test += "save res/rgbCombineTest.ppm rc\n";
    test += "#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);

    this.controller = new ImgControllerImpl(model, view, reader);
    this.controller.run();

    assertEquals(true, checkTwoImages(new String[]{"res/img1combine.ppm"},
        new String[]{"res/rgbCombineTest.ppm"}));
  }

}