package view;

import static org.junit.Assert.assertEquals;

import java.io.OutputStreamWriter;
import org.junit.Before;
import org.junit.Test;

public class ViewTest {
  IView v;
  MockBufferedWriter mbw;

  @Before
  public void setUp() {
    mbw = new MockBufferedWriter(new OutputStreamWriter(System.out));
    v = new View(mbw);
  }

  @Test
  public void getCommandTest() {
    v.toggleVerbose();
    v.echoGetCommand(false);
    String out1 = mbw.checkBuffer();
    v.echoGetCommand(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Enter the command\n", out2);
  }

  @Test
  public void getCloseCmd() {
    v.toggleVerbose();
    v.echoCloseCmd(false);
    String out1 = mbw.checkBuffer();
    v.echoCloseCmd(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Program exited successfully\n", out2);
  }

  @Test
  public void getIoError() {
    v.toggleVerbose();
    v.echoIoError("error :", false);
    String out1 = mbw.checkBuffer();
    v.echoIoError("error :",true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("error : There is a problem with reading the input, please try again.\n", out2);
  }

  @Test
  public void getWrongCmdError() {
    v.toggleVerbose();
    v.echoWrongCmdError("error :", false);
    String out1 = mbw.checkBuffer();
    v.echoWrongCmdError("error :",true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("error : Please enter a valid command!\n", out2);
  }

  @Test
  public void getFileHandlingError() {
    v.toggleVerbose();
    v.echoFileHandlingError("error :", false);
    String out1 = mbw.checkBuffer();
    v.echoFileHandlingError("error :",true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("error : File not found, Please try again!\n", out2);
  }

  @Test
  public void getImgNameAlreadyExistsError() {
    v.toggleVerbose();
    v.echoImageNameAlreadyExistsError("error :", false);
    String out1 = mbw.checkBuffer();
    v.echoImageNameAlreadyExistsError("error :",true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("error : Please choose a different name!\n", out2);
  }

  @Test
  public void getLoadSuccess() {
    v.toggleVerbose();
    v.echoLoadSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoLoadSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image loaded sucessfully.\n", out2);
  }

  @Test
  public void getSaveSuccess() {
    v.toggleVerbose();
    v.echoSaveSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoSaveSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image saved successfully.\n", out2);
  }

  @Test
  public void getGreyscaleSuccess() {
    v.toggleVerbose();
    v.echoGreyscaleSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoGreyscaleSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image converted to greyscale successfully.\n", out2);
  }

  @Test
  public void getBrightenSuccess() {
    v.toggleVerbose();
    v.echoBrightenSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoBrightenSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image brightened successfully.\n", out2);
  }

  @Test
  public void getFlipSuccess() {
    v.toggleVerbose();
    v.echoFlipSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoFlipSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image flipped successfully.\n", out2);
  }

  @Test
  public void getSplitSuccess() {
    v.toggleVerbose();
    v.echoSplitSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoSplitSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image split successfully.\n", out2);
  }

  @Test
  public void getCombineSuccess() {
    v.toggleVerbose();
    v.echoCombineSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoCombineSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Image combined successfully.\n", out2);
  }

  @Test
  public void getScriptSuccess() {
    v.toggleVerbose();
    v.echoScriptSuccess(false);
    String out1 = mbw.checkBuffer();
    v.echoScriptSuccess(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Script has been successfully executed.\n", out2);
  }

  @Test
  public void getInvalidInpMsg() {
    v.toggleVerbose();
    v.echoInvalidInputMsg(false);
    String out1 = mbw.checkBuffer();
    v.echoInvalidInputMsg(true);
    String out2 = mbw.checkBuffer();
    assertEquals("", out1);
    assertEquals("Please Enter A Valid Input\n", out2);
  }
}