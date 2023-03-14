package controller;

import static org.junit.Assert.assertEquals;

import helper.Helper;
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
    this.view = new MockView();

  }

  //  Permutation of load commands
  @Test
  public void loadTest() {
    String test = "load code/ant.ppm ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/ant.ppm | ant\n", modelRet);
    assertEquals("Get Cmd|Load Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadNoPathTest() {
    String test = "load ant\n#\n";

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
    String test = "load code/ant.ppm\n#\n";

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
    String test = "code/ant.ppm\n#\n";

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
    String test = "save code/ant.ppm ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("save | code/ant.ppm | ant\n", modelRet);
    assertEquals("Get Cmd|Save Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void saveNoPathTest() {
    String test = "save ant\n#\n";

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
    String test = "save code/ant.ppm\n#\n";

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
    String test = "code/ant.ppm ant\n#\n";

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
    String test = "greyscale red ant antRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleRed | ant | antRed\n", modelRet);
    assertEquals("Get Cmd|Greyscale Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleNoRedTest() {
    String test = "greyscale ant antRed\n#\n";

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
    String test = "greyscale red antRed\n#\n";

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
    String test = "greyscale red ant\n#\n";

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
    String test = "red ant antRed\n#\n";

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
    String test = "greyscale blue ant antBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleBlue | ant | antBlue\n", modelRet);
    assertEquals("Get Cmd|Greyscale Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleBlueNoSrcTest() {
    String test = "greyscale blue antBlue\n#\n";

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
  public void greyscaleBlueNoDestTest() {
    String test = "greyscale blue ant\n#\n";

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
  public void greyscaleNoBlueTest() {
    String test = "greyscale ant antBlue\n#\n";

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
  public void greyscaleBlueNoCmdTest() {
    String test = "blue ant antBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

//  permuations of greyscale green
  @Test
  public void greyscaleGreenTest() {
    String test = "greyscale green ant antGreen\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleGreen | ant | antGreen\n", modelRet);
  }

  @Test
  public void greyscaleGreenNoSrcTest() {
    String test = "greyscale green antGreen\n#\n";

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
  public void greyscaleGreenNoDestTest() {
    String test = "greyscale green ant\n#\n";

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
  public void greyscaleNoGreenTest() {
    String test = "greyscale ant antGreen\n#\n";

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
  public void greyscaleGreenNoCmdTest() {
    String test = "green ant antGreen\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

//  permuations of greyscale value
  @Test
  public void greyscaleValueTest() {
    String test = "greyscale value ant antValue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleValue | ant | antValue\n", modelRet);
    assertEquals("Get Cmd|Greyscale Success|Get Cmd|Close Cmd", viewRet);
  }

  @Test
  public void greyscaleValueNoSrcTest() {
    String test = "greyscale value antValue\n#\n";

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
  public void greyscaleValueNoDestTest() {
    String test = "greyscale value ant\n#\n";

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
  public void greyscaleNoValueTest() {
    String test = "greyscale ant antValue\n#\n";

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
  public void greyscaleValueNoCmdTest() {
    String test = " value ant antValue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

//  permutations of gresycale intensity
  @Test
  public void greyscaleIntensityTest() {
    String test = "greyscale intensity ant antIntensity\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleIntensity | ant | antIntensity\n", modelRet);
    assertEquals("Get Cmd|Greyscale Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleIntensityNoSrcTest() {
    String test = "greyscale intensity antIntensity\n#\n";

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
  public void greyscaleIntensityNoDestTest() {
    String test = "greyscale intensity ant\n#\n";

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
  public void greyscaleNoIntensityTest() {
    String test = "greyscale intensity antIntensity\n#\n";

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
  public void greyscaleIntensityNoCmdTest() {
    String test = " intensity ant antIntensity\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

//  permutations of greyscale luma
  @Test
  public void greyscaleLumaTest() {
    String test = "greyscale luma ant antLuma\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("greyScaleLuma | ant | antLuma\n", modelRet);
    assertEquals("Get Cmd|Greyscale Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleLumaNoSrcTest() {
    String test = "greyscale luma antLuma\n#\n";

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
  public void greyscaleLumaNoDestTest() {
    String test = "greyscale luma ant\n#\n";

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
  public void greyscaleNoLumaTest() {
    String test = "greyscale ant antLuma\n#\n";

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
  public void greyscaleLumaNoCmdTest() {
    String test = " luma ant antLuma\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

//  permuations of greyscale horizontal flip
  @Test
  public void greyscaleHoriFlipTest() {
    String test = "horizontal-flip ant antHFlip\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("horizontalFlip | ant | antHFlip\n", modelRet);
    assertEquals("Get Cmd|Flip Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleHoriFlipNoSrcTest() {
    String test = "horizontal-flip antHFlip\n#\n";

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
  public void greyscaleHoriFlipNoDestTest() {
    String test = "horizontal-flip ant\n#\n";

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
  public void greyscaleHoriFlipNoCmdTest() {
    String test = "ant antHFlip\n#\n";

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

//  permuatations of vertical flip
  @Test
  public void greyscaleVertFlipTest() {
    String test = "vertical-flip ant antVFlip\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("verticalFlip | ant | antVFlip\n", modelRet);
    assertEquals("Get Cmd|Flip Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleVertFlipNoSrcTest() {
    String test = "vertical-flip antVFlip\n#\n";

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
  public void greyscaleVertFlipNoDestTest() {
    String test = "vertical-flip ant\n#\n";

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
  public void greyscaleVertFlipNoCmdTest() {
    String test = " ant antVFlip\n#\n";

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

//  permutations for brighten command
  @Test
  public void greyscaleBrightenTest() {
    String test = "brighten 10 ant antBrighten\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("brighten | 10 | ant | antBrighten\n", modelRet);
    assertEquals("Get Cmd|Brighten Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleBrightenNoSrcTest() {
    String test = "brighten 10 antBrighten\n#\n";

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
  public void greyscaleBrightenNoDestTest() {
    String test = "brighten 10 ant \n#\n";

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
  public void greyscaleBrightenNoValTest() {
    String test = "brighten ant antBrighten\n#\n";

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
  public void greyscaleBrightenNoCmdTest() {
    String test = " 10 ant antBrighten\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

//  permutations of rgb split commands
  @Test
  public void greyscaleRgbSplitTest() {
    String test = "rgb-split antSplit antSRed antSGreen antSBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("rgbSplit | antSplit | antSRed | antSGreen | antSBlue\n", modelRet);
    assertEquals("Get Cmd|Split Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleRgbSplitNo1DestTest() {
    String test = "rgb-split antSplit antSGreen antSBlue\n#\n";

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
  public void greyscaleRgbSplitNo2DestTest() {
    String test = "rgb-split antSplit antSRed antSBlue\n#\n";

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
  public void greyscaleRgbSplitNo3DestTest() {
    String test = "rgb-split antSplit antSRed antSGreen\n#\n";

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
  public void greyscaleRgbSplitNoSrcTest() {
    String test = "rgb-split antSRed antSGreen andSBlue\n#\n";

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
  public void greyscaleRgbSplitNoCmdTest() {
    String test = "antSplit antSRed antSGreen antSBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

//  permutations for the rgb combine command
  @Test
  public void greyscaleRgbCombineTest() {
    String test = "rgb-combine antCombine antSRed antSGreen antSBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("rgbCombine | antCombine | antSRed | antSGreen | antSBlue\n", modelRet);
    assertEquals("Get Cmd|Combine Success|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void greyscaleRgbCombineNoSrc1Test() {
    String test = "rgb-combine antCombine antSGreen antSBlue\n#\n";

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
  public void greyscaleRgbCombineNoSrc2Test() {
    String test = "rgb-combine antCombine antSRed antSBlue\n#\n";

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
  public void greyscaleRgbCombineNoSrc3Test() {
    String test = "rgb-combine antCombine antSRed antSGreen\n#\n";

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
  public void greyscaleRgbCombineNoDestTest() {
    String test = "rgb-combine  antSGreen antSBlue antSBlue\n#\n";

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
  public void greyscaleRgbCombineNoCmdTest() {
    String test = " antCombine antSGreen antSBlue antSBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("", modelRet);
    assertEquals("Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Invalid Input|Get Cmd|Close Cmd|", viewRet);
  }

  @Test
  public void loadSaveTest() {
    String test = "load code/ant.ppm ant\nsave code/antnew.ppm ant\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/ant.ppm | ant\nsave | code/antnew.ppm | ant\n", modelRet);
  }

  @Test
  public void loadLineTest() {
    String test = "load\n    code/ant.ppm     \nant     \n   #      \n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/ant.ppm | ant\n", modelRet);
  }

  @Test
  public void loadLineTest2() {
    String test = "load\n    code/ant.ppm        ant     \n   #      \n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String modelRet = this.model.toString();
    String viewRet = this.view.toString();
    assertEquals("load | code/ant.ppm | ant\n", modelRet);
  }

}