package controller;

import static org.junit.Assert.assertEquals;

import controller.helper.Helper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import model.IImage;
import org.junit.Before;
import org.junit.Test;
import view.IView;

public class ImgControllerImplTest extends Helper {

  IImage model;
  IView view;
  ImgController controller;

  @Before
  public void setUp() {
    this.model = new MockModel();
    ;
    this.view = new MockView();
//    this.controller=new ImgControllerImpl(this.model, this.view, new BufferedReader(new InputStreamReader(System.in)),new BufferedWriter(new OutputStreamWriter(System.out)));
//    this.controller.go();

  }

  //  Permutation of load commands
  @Test
  public void loadTest() {
    String test = "load code/koala.ppm koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/koala.ppm | koala\n", modelRet);
    assertEquals("Get Cmd|Load Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadNoPathTest() {
    String test = "load koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadNoImgTest() {
    String test = "load code/koala.ppm\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();

    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void noCmdTest() {
    String test = "code/koala.ppm\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();

    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

  //  perumatations of save commands
  @Test
  public void saveTest() {
    String test = "save code/koala.ppm koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("save | code/koala.ppm | koala\n", modelRet);
    assertEquals("Get Cmd|Save Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveNoPathTest() {
    String test = "save koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveNoNameTest() {
    String test = "save code/koala.ppm\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveNoCmdTest() {
    String test = "code/koala.ppm koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

  //  permuations of greyscale red
  @Test
  public void greyscaleRedTest() {
    String test = "greyscale red koala koalaRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleRed | koala | koalaRed\n", modelRet);
    assertEquals("Get Cmd|Greyscale Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleNoRedTest() {
    String test = "greyscale koala koalaRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleRedNoSrcTest() {
    String test = "greyscale red koalaRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleRedNoDestTest() {
    String test = "greyscale red koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleRedNoCmdTest() {
    String test = "red koala koalaRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals(
        "Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|",
        viewRet);
  }

  //  permutations of greyscale blue cmd
  @Test
  public void greyscaleBlueTest() {
    String test = "greyscale blue koala koalaBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleBlue | koala | koalaBlue\n", modelRet);
//    assertEquals("Get Cmd|");
  }

  @Test
  public void greyscaleGreenTest() {
    String test = "greyscale green koala koalaGreen\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleGreen | koala | koalaGreen\n", modelRet);
  }


  @Test
  public void greyscaleValueTest() {
    String test = "greyscale value koala koalaValue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleValue | koala | koalaValue\n", modelRet);
  }

  @Test
  public void greyscaleIntensityTest() {
    String test = "greyscale intensity koala koalaIntensity\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleIntensity | koala | koalaIntensity\n", modelRet);
  }

  @Test
  public void greyscaleLumaTest() {
    String test = "greyscale luma koala koalaLuma\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleLuma | koala | koalaLuma\n", modelRet);
  }

  @Test
  public void greyscaleHoriFlipTest() {
    String test = "horizontal-flip koala koalaHFlip\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("horizontalFlip | koala | koalaHFlip\n", modelRet);
  }

  @Test
  public void greyscaleVertFlipTest() {
    String test = "vertical-flip koala koalaVFlip\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("verticalFlip | koala | koalaVFlip\n", modelRet);
  }

  @Test
  public void greyscaleBrightenTest() {
    String test = "brighten 10 koala koalaBrighten\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("brighten | 10 | koala | koalaBrighten\n", modelRet);
  }

  @Test
  public void greyscaleRgbSplitTest() {
    String test = "rgb-split koalaSplit koalaSRed koalaSGreen koalaSBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("rgbSplit | koalaSplit | koalaSRed | koalaSGreen | koalaSBlue\n", modelRet);
  }

  @Test
  public void greyscaleRgbCombineTest() {
    String test = "rgb-combine koalaCombine koalaSRed koalaSGreen koalaSBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("rgbCombine | koalaCombine | koalaSRed | koalaSGreen | koalaSBlue\n", modelRet);
  }

  @Test
  public void loadSaveTest() {
    String test = "load code/koala.ppm koala\nsave code/koalanew.ppm koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/koala.ppm | koala\nsave | code/koalanew.ppm | koala\n", modelRet);
  }

  @Test
  public void loadLineTest() {
    String test = "load\n    code/koala.ppm     \nkoala     \n   #      \n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/koala.ppm | koala\n", modelRet);
  }

  @Test
  public void loadLineTest2() {
    String test = "load\n    code/koala.ppm        koala     \n   #      \n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/koala.ppm | koala\n", modelRet);
  }

}