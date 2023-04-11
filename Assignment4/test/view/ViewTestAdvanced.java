package view;

import static org.junit.Assert.assertEquals;

import java.io.OutputStreamWriter;
import model.ImageObj;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the new view part of the MVC.
 */
public class ViewTestAdvanced {

  IViewAdvanced v;
  MockBufferedWriterAdvanced mbw;
  ImageObj img = null;

  @Before
  public void setUp() {
    mbw = new MockBufferedWriterAdvanced(new OutputStreamWriter(System.out));
    v = new ViewAdvanced(mbw);
  }

  @Test
  public void getFilterBlurSuccess() {
    v.toggleVerbose();
    v.echoFilterBlurSuccess(img,false);
    String out1 = mbw.checkBuffer();
    v.echoFilterBlurSuccess(img,true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image Blurred successfully.\n", out2);
  }

  @Test
  public void getFilterSharpenSuccess() {
    v.toggleVerbose();
    v.echoFilterSharpenSuccess(img,false);
    String out1 = mbw.checkBuffer();
    v.echoFilterSharpenSuccess(img,true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image Sharpened successfully.\n", out2);
  }

  @Test
  public void getTransformSepiaSuccess() {
    v.toggleVerbose();
    v.echoSepiaSuccess(img,false);
    String out1 = mbw.checkBuffer();
    v.echoSepiaSuccess(img,true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image converted to Sepia successfully.\n", out2);
  }

  @Test
  public void getDitherSuccess() {
    v.toggleVerbose();
    v.echoDither(img,false);
    String out1 = mbw.checkBuffer();
    v.echoDither(img,true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image converted to Dither successfully.\n", out2);
  }
}