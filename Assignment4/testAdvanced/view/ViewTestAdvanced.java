package view;

import static org.junit.Assert.assertEquals;

import java.io.OutputStreamWriter;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the view part of the MVC.
 */
public class ViewTestAdvanced {
  IViewAdvanced v;
  MockBufferedWriterAdvanced mbw;

  @Before
  public void setUp() {
    mbw = new MockBufferedWriterAdvanced(new OutputStreamWriter(System.out));
    v = new ViewAdvanced(mbw);
  }

  @Test
  public void getFilterBlurSuccess() {
    v.toggleVerbose();
    v.echoFilterBlurSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoFilterBlurSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image Blurred successfully.\n", out2);
  }

  @Test
  public void getFilterSharpenSuccess() {
    v.toggleVerbose();
    v.echoFilterSharpenSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoFilterSharpenSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image Sharpened successfully.\n", out2);
  }

  @Test
  public void getTransformSepiaSuccess() {
    v.toggleVerbose();
    v.echoSepiaSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoSepiaSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image converted to Sepia successfully.\n", out2);
  }

  @Test
  public void getDitherSuccess() {
    v.toggleVerbose();
    v.echoDither(false);
    String out1 = mbw.checkBuffer();
    v.echoDither(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image converted to Dither successfully.\n", out2);
  }
}