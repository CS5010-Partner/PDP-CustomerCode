package controller;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import model.IImage;
import model.IImageAdvanced;
import org.junit.Before;
import org.junit.Test;
import view.IView;
import view.IViewAdvanced;

/**
 * This class tests the controller implementation.
 */
public class ImgControllerImplAdvancedTest {

  private IImageAdvanced model;
  private IViewAdvanced view;
  private ImgController controller;

  @Before
  public void setUp() {
    this.model = new MockModelAdvanced();
    this.view = new MockViewAdvanced();

  }

  @Test
  public void loadPPMTest() {
    String test = "load res/img1orig.ppm line \n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | res/img1orig.ppm | line\n", modelRet);
    assertEquals("Get Cmd|Load Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadJPGTest() {
    String test = "load res/img1orig.jpg line \n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | res/img1orig.jpg | line\n", modelRet);
    assertEquals("Get Cmd|Load Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadPNGTest() {
    String test = "load res/img1orig.png line \n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | res/img1orig.png | line\n", modelRet);
    assertEquals("Get Cmd|Load Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadBMPTest() {
    String test = "load res/img1orig.bmp line \n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | res/img1orig.bmp | line\n", modelRet);
    assertEquals("Get Cmd|Load Success|Get Cmd|Close Cmd|", viewRet);
  }


  @Test
  public void loadNoPathTest() {
    String test = "load ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadNoImgTest() {
    String test = "load code/ant.ppm\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();

    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void noCmdTest() {
    String test = "code/ant.ppm\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();

    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void savePPMTest() {
    String test = "save code/ant.ppm ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("save | code/ant.ppm | ant\n", modelRet);
    assertEquals("Get Cmd|Save Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void savePNGTest() {
    String test = "save code/ant.png ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("save | code/ant.png | ant\n", modelRet);
    assertEquals("Get Cmd|Save Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveJPGTest() {
    String test = "save code/ant.jpg ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("save | code/ant.jpg | ant\n", modelRet);
    assertEquals("Get Cmd|Save Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveBMPTest() {
    String test = "save code/ant.bmp ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("save | code/ant.bmp | ant\n", modelRet);
    assertEquals("Get Cmd|Save Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveNoPathTest() {
    String test = "save ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveNoNameTest() {
    String test = "save code/ant.ppm\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveNoCmdTest() {
    String test = "code/ant.ppm ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|",
        viewRet);
  }

  @Test
  public void transformGreyscaleTest() {
    String test = "greyscale ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("transformGreyScale | ant | antRed\n", modelRet);
    assertEquals("Get Cmd|Greyscale Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void transformGreyscaleNoCmdTest() {
    String test = "ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals(
        "Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|",
        viewRet);
  }

 @Test
  public void transformSepiaTest() {
   String test = "sepia ant antRed\n#\n";

   Reader inputString = new StringReader(test);
   BufferedReader reader = new BufferedReader(inputString);
   this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
   this.controller.run();

   String modelRet = this.model.toString();
   String viewRet = this.view.toString();
   assertEquals("transformSepia | ant | antRed\n", modelRet);
   assertEquals("Get Cmd|Sepia Success|Get Cmd|Close Cmd|", viewRet);
 }

  @Test
  public void transformSepiaNoCmdTest() {
    String test = "ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals(
        "Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|",
        viewRet);
  }

  @Test
  public void filterBlurTest() {
    String test = "blur ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("filterBlur | ant | antRed\n", modelRet);
    assertEquals("Get Cmd|Blur Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void filterBlurNoCmdTest() {
    String test = "ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals(
        "Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|",
        viewRet);
  }

  @Test
  public void filterSharpenTest() {
    String test = "sharpen ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("filterSharpen | ant | antRed\n", modelRet);
    assertEquals("Get Cmd|Sharpen Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void filterSharpenNoCmdTest() {
    String test = "ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals(
        "Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|",
        viewRet);
  }

  @Test
  public void ditherTest() {
    String test = "dither ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    this.controller = new ImgControllerImplAdvanced(this.model, this.view, reader);
    this.controller.run();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("dither | ant | antRed\n", modelRet);
    assertEquals("Get Cmd|Dither Success|Get Cmd|Close Cmd|", viewRet);
  }

}