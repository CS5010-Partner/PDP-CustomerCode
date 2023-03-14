package controller;

import static org.junit.Assert.*;

import helper.CloseCmdLineException;
import helper.Helper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import model.IImage;
import org.junit.Before;
import org.junit.Test;
import view.IView;
import view.View;

public class ImgControllerImplTest extends Helper {
  IImage model;
  IView view;
  ImgController controller;

  @Before
  public void setUp() {
    this.model = new MockModel();;
    this.view=new View();
//    this.controller=new ImgControllerImpl(this.model, this.view, new BufferedReader(new InputStreamReader(System.in)),new BufferedWriter(new OutputStreamWriter(System.out)));
//    this.controller.go();

  }

  @Test
  public void loadTest() {
    String test = "load code/koala.ppm koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("load | code/koala.ppm | koala", ret);
  }

  @Test
  public void saveTest() {
    String test = "save code/koala.ppm koala\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("save | code/koala.ppm | koala", ret);
  }

  @Test
  public void greyscaleRedTest() {
    String test = "greyscale red koala koalaRed\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("greyScaleRed | koala | koalaRed", ret);
  }

  @Test
  public void greyscaleBlueTest() {
    String test = "greyscale blue koala koalaBlue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("greyScaleBlue | koala | koalaBlue", ret);
  }

  @Test
  public void greyscaleGreenTest() {
    String test = "greyscale green koala koalaGreen\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("greyScaleGreen | koala | koalaGreen", ret);
  }


  @Test
  public void greyscaleValueTest() {
    String test = "greyscale value koala koalaValue\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("greyScaleValue | koala | koalaValue", ret);
  }

  @Test
  public void greyscaleIntensityTest() {
    String test = "greyscale intensity koala koalaIntensity\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("greyScaleIntensity | koala | koalaIntensity", ret);
  }

  @Test
  public void greyscaleLumaTest() {
    String test = "greyscale luma koala koalaLuma\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("greyScaleLuma | koala | koalaLuma", ret);
  }

  @Test
  public void greyscaleHoriFlipTest() {
    String test = "horizontalFlip koala koalaHFli\n#\n";

    Reader inputString = new StringReader(test);
    BufferedReader reader = new BufferedReader(inputString);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    this.controller = new ImgControllerImpl(this.model, this.view, reader, writer);
    this.controller.go();

    String ret = this.model.toString();
    assertEquals("greyScaleLuma | koala | koalaLuma", ret);
  }


}