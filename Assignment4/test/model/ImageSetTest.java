package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import model.file.IFile;
import model.file.PPMFile;
import org.junit.Test;

public class ImageSetTest {

  private ImageSet model;
  private IFile img1;
  private IFile img2;
  private IFile img3;

  private HashMap<String, ImageObj> map;

  public ImageSetTest() {
    model = new ImageSet();
    img1 = new PPMFile("res/img1orig.ppm");
    img2 = new PPMFile("res/img2orig.ppm");
    img3 = new PPMFile("res/somerandompath.ppm");
    map = new HashMap<String, ImageObj>();
  }

  private boolean checkTwoImages(ImageObj obj1, ImageObj obj2) {
    if (obj1.getHeight() != obj2.getHeight() ||
        obj1.getWidth() != obj2.getWidth()) {
      return false;
    }

    return Arrays.deepEquals(obj1.getMatrix(), obj2.getMatrix());
  }

  @Test
  public void loadTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    String imgNameExp = "exceptions.ImageNameAlreadyExistsException: Image name already exists.";
    String noFileExp = "exceptions.FileHandlingException: File res/somerandompath.ppm not found!";
    try {
      model.load(img1, "1orig");
      fail("load failed");
    } catch (ImageNameAlreadyExistsException e) {
      assertEquals(imgNameExp, e.toString());
    }

    try {
      model.load(img2, "2orig");
      fail("load failed");
    } catch (ImageNameAlreadyExistsException e) {
      assertEquals(imgNameExp, e.toString());
    }

    try {
      model.load(img3, "3orig");
      fail("load failed");
    } catch (FileHandlingException e) {
      assertEquals(noFileExp, e.toString());
    }
  }

  @Test
  public void saveTest()
      throws ImageNameAlreadyExistsException, NoSuchElementException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    IFile img1Save = new PPMFile("res/img1origCopy.ppm");
    IFile img2Save = new PPMFile("res/img2origCopy.ppm");
    IFile img3Save = new PPMFile("res123/img3origCopy.ppm");

    ImageObj s1 = model.save(img1Save, "1orig");
    ImageObj s2 = model.save(img2Save, "2orig");

    try {
      model.save(img3Save, "3orig");
      fail("save failed");
    } catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",
          e.toString());
    }

    try {
      model.save(img3Save, "2orig");
      fail("save failed");
    } catch (FileHandlingException e) {
      assertEquals("exceptions.FileHandlingException: Directory not Found.", e.toString());
    }
  }


  @Test
  public void greyScaleRedTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1greyRed", model.greyScaleRed("1orig", "1greyRed"));
    map.put("2greyRed", model.greyScaleRed("2orig", "2greyRed"));

    IFile ref1 = new PPMFile("res/img1greyRed.ppm");
    IFile ref2 = new PPMFile("res/img2greyRed.ppm");

    map.put("1greyRedRef", model.load(ref1, "1greyRedRef"));
    map.put("2greyRedRef", model.load(ref2, "2greyRedRef"));

    assertEquals(true, checkTwoImages(map.get("1greyRedRef"), map.get("1greyRed")));
    assertEquals(true, checkTwoImages(map.get("2greyRedRef"), map.get("2greyRed")));

    try {
      model.greyScaleRed("1orig", "1greyRed");
      fail("greyscale red failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.greyScaleRed("1orig1", "1greyRed");
      fail("greyscale red failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void greyScaleGreenTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1greyGreen", model.greyScaleGreen("1orig", "1greyGreen"));
    map.put("2greyGreen", model.greyScaleGreen("2orig", "2greyGreen"));

    IFile ref1 = new PPMFile("res/img1greyGreen.ppm");
    IFile ref2 = new PPMFile("res/img2greyGreen.ppm");

    map.put("1greyGreenRef", model.load(ref1, "1greyGreenRef"));
    map.put("2greyGreenRef", model.load(ref2, "2greyGreenRef"));

    assertEquals(true, checkTwoImages(map.get("1greyGreenRef"), map.get("1greyGreen")));
    assertEquals(true, checkTwoImages(map.get("2greyGreenRef"), map.get("2greyGreen")));

    try {
      model.greyScaleGreen("1orig", "1greyGreen");
      fail("greyscale Green failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.greyScaleGreen("1orig1", "1greyGreen");
      fail("greyscale Green failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void greyScaleBlueTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1greyBlue", model.greyScaleBlue("1orig", "1greyBlue"));
    map.put("2greyBlue", model.greyScaleBlue("2orig", "2greyBlue"));

    IFile ref1 = new PPMFile("res/img1greyBlue.ppm");
    IFile ref2 = new PPMFile("res/img2greyBlue.ppm");

    map.put("1greyBlueRef", model.load(ref1, "1greyBlueRef"));
    map.put("2greyBlueRef", model.load(ref2, "2greyBlueRef"));

    assertEquals(true, checkTwoImages(map.get("1greyBlueRef"), map.get("1greyBlue")));
    assertEquals(true, checkTwoImages(map.get("2greyBlueRef"), map.get("2greyBlue")));

    try {
      model.greyScaleBlue("1orig", "1greyBlue");
      fail("greyscale Blue failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.greyScaleBlue("1orig1", "1greyBlue");
      fail("greyscale Blue failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void greyScaleValTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1greyVal", model.greyScaleValue("1orig", "1greyVal"));
    map.put("2greyVal", model.greyScaleValue("2orig", "2greyVal"));

    IFile ref1 = new PPMFile("res/img1greyVal.ppm");
    IFile ref2 = new PPMFile("res/img2greyVal.ppm");

    map.put("1greyValRef", model.load(ref1, "1greyValRef"));
    map.put("2greyValRef", model.load(ref2, "2greyValRef"));

    assertEquals(true, checkTwoImages(map.get("1greyValRef"), map.get("1greyVal")));
    assertEquals(true, checkTwoImages(map.get("2greyValRef"), map.get("2greyVal")));

    try {
      model.greyScaleValue("1orig", "1greyVal");
      fail("greyscale Value failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.greyScaleValue("1orig1", "1greyVal");
      fail("greyscale Value failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void greyScaleIntensityTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1greyIn", model.greyScaleIntensity("1orig", "1greyIn"));
    map.put("2greyIn", model.greyScaleIntensity("2orig", "2greyIn"));

    IFile ref1 = new PPMFile("res/img1greyIn.ppm");
    IFile ref2 = new PPMFile("res/img2greyIn.ppm");

    map.put("1greyInRef", model.load(ref1, "1greyInRef"));
    map.put("2greyInRef", model.load(ref2, "2greyInRef"));

    assertEquals(true, checkTwoImages(map.get("1greyInRef"), map.get("1greyIn")));
    assertEquals(true, checkTwoImages(map.get("2greyInRef"), map.get("2greyIn")));

    try {
      model.greyScaleIntensity("1orig", "1greyIn");
      fail("greyscale Intensity failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.greyScaleIntensity("1orig1", "1greyIn");
      fail("greyscale Intensity failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void greyScaleLumaTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1greyLuma", model.greyScaleLuma("1orig", "1greyLuma"));
    map.put("2greyLuma", model.greyScaleLuma("2orig", "2greyLuma"));

    IFile ref1 = new PPMFile("res/img1greyLuma.ppm");
    IFile ref2 = new PPMFile("res/img2greyLuma.ppm");

    map.put("1greyLumaRef", model.load(ref1, "1greyLumaRef"));
    map.put("2greyLumaRef", model.load(ref2, "2greyLumaRef"));

    assertEquals(true, checkTwoImages(map.get("1greyLumaRef"), map.get("1greyLuma")));
    assertEquals(true, checkTwoImages(map.get("2greyLumaRef"), map.get("2greyLuma")));

    try {
      model.greyScaleLuma("1orig", "1greyLuma");
      fail("greyscale Luma failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.greyScaleLuma("1orig1", "1greyLuma");
      fail("greyscale Luma failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void horiFlipTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1hori", model.horizontalFlip("1orig", "1hori"));
    map.put("2hori", model.horizontalFlip("2orig", "2hori"));

    IFile ref1 = new PPMFile("res/img1hflip.ppm");
    IFile ref2 = new PPMFile("res/img2hflip.ppm");

    map.put("1horiRef", model.load(ref1, "1horiRef"));
    map.put("2horiRef", model.load(ref2, "2horiRef"));

    assertEquals(true, checkTwoImages(map.get("1horiRef"), map.get("1hori")));
    assertEquals(true, checkTwoImages(map.get("2horiRef"), map.get("2hori")));

    try {
      model.horizontalFlip("1orig", "1hori");
      fail("Horizontal Flip failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.horizontalFlip("1orig1", "1hori");
      fail("Horizontal Flip failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void vertFlipTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1vert", model.verticalFlip("1orig", "1vert"));
    map.put("2vert", model.verticalFlip("2orig", "2vert"));

    IFile ref1 = new PPMFile("res/img1vflip.ppm");
    IFile ref2 = new PPMFile("res/img2vflip.ppm");

    map.put("1vertRef", model.load(ref1, "1vertRef"));
    map.put("2vertRef", model.load(ref2, "2vertRef"));

    assertEquals(true, checkTwoImages(map.get("1vertRef"), map.get("1vert")));
    assertEquals(true, checkTwoImages(map.get("2vertRef"), map.get("2vert")));

    try {
      model.verticalFlip("1orig", "1vert");
      fail("Vertical Flip failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.verticalFlip("1orig1", "1vert");
      fail("Vertical Flip failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void brightenTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1br1", model.brighten(200, "1orig", "1br1"));
    map.put("1br2", model.brighten(50, "1orig", "1br2"));

    map.put("2br1", model.brighten(200, "2orig", "2br1"));
    map.put("2br2", model.brighten(50, "2orig", "2br2"));

    IFile ref1 = new PPMFile("res/img1brighten1.ppm");
    IFile ref2 = new PPMFile("res/img2brighten1.ppm");

    IFile ref3 = new PPMFile("res/img1brighten2.ppm");
    IFile ref4 = new PPMFile("res/img2brighten2.ppm");

    map.put("1br1Ref", model.load(ref1, "1br1Ref"));
    map.put("2br1Ref", model.load(ref2, "2br1Ref"));

    map.put("1br2Ref", model.load(ref3, "1br2Ref"));
    map.put("2br2Ref", model.load(ref4, "2br2Ref"));

    assertEquals(true, checkTwoImages(map.get("1br1Ref"), map.get("1br1")));
    assertEquals(true, checkTwoImages(map.get("2br1Ref"), map.get("2br1")));

    assertEquals(true, checkTwoImages(map.get("1br2Ref"), map.get("1br2")));
    assertEquals(true, checkTwoImages(map.get("2br2Ref"), map.get("2br2")));

    try {
      model.brighten(50, "1orig", "1br1");
      fail("Brighten failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.brighten(50, "1orig1", "1br1");
      fail("Brighten Flip failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void rgbSplitTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    ImageObj[] rs1 = model.rgbSplit("1orig", "1rs1", "1rs2", "1rs3");
    ImageObj[] rs2 = model.rgbSplit("2orig", "2rs1", "2rs2", "2rs3");

    map.put("1rs1", rs1[0]);
    map.put("1rs2", rs1[1]);
    map.put("1rs3", rs1[2]);

    map.put("2rs1", rs2[0]);
    map.put("2rs2", rs2[1]);
    map.put("2rs3", rs2[2]);

    IFile rs11 = new PPMFile("res/img1split1.ppm");
    IFile rs12 = new PPMFile("res/img1split2.ppm");
    IFile rs13 = new PPMFile("res/img1split3.ppm");

    IFile rs21 = new PPMFile("res/img2split1.ppm");
    IFile rs22 = new PPMFile("res/img2split2.ppm");
    IFile rs23 = new PPMFile("res/img2split3.ppm");

    map.put("1rs1Ref", model.load(rs11, "1rs1Ref"));
    map.put("1rs2Ref", model.load(rs12, "1rs2Ref"));
    map.put("1rs3Ref", model.load(rs13, "1rs3Ref"));

    map.put("2rs1Ref", model.load(rs21, "2rs1Ref"));
    map.put("2rs2Ref", model.load(rs22, "2rs2Ref"));
    map.put("2rs3Ref", model.load(rs23, "2rs3Ref"));

    assertEquals(true, checkTwoImages(map.get("1rs1Ref"), map.get("1rs1")));
    assertEquals(true, checkTwoImages(map.get("1rs2Ref"), map.get("1rs2")));
    assertEquals(true, checkTwoImages(map.get("1rs3Ref"), map.get("1rs3")));

    assertEquals(true, checkTwoImages(map.get("2rs1Ref"), map.get("2rs1")));
    assertEquals(true, checkTwoImages(map.get("2rs2Ref"), map.get("2rs2")));
    assertEquals(true, checkTwoImages(map.get("2rs3Ref"), map.get("2rs3")));

    try {
      model.rgbSplit("1orig", "1rs1", "1rs1", "1rs3");
      fail("Split failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.rgbSplit("1orig1", "1rs1", "1rs2", "1rs3");
      fail("Brighten Flip failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }

  @Test
  public void rgbCombineTest()
      throws ImageNameAlreadyExistsException, ImageNotFoundException, FileHandlingException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    ImageObj[] rs1 = model.rgbSplit("1orig", "1rs1", "1rs2", "1rs3");
    ImageObj[] rs2 = model.rgbSplit("2orig", "2rs1", "2rs2", "2rs3");

    ImageObj rc1 = model.rgbCombine("1rc", "1rs1", "1rs2", "1rs3");
    ImageObj rc2 = model.rgbCombine("2rc", "2rs1", "2rs2", "2rs3");

    map.put("1rc", rc1);
    map.put("2rc", rc2);

    IFile rc1Ref = new PPMFile("res/img1combine.ppm");
    IFile rc2Ref = new PPMFile("res/img2combine.ppm");

    map.put("1rcRef", model.load(rc1Ref, "1rs1Ref"));
    map.put("2rcRef", model.load(rc2Ref, "1rs2Ref"));

    assertEquals(true, checkTwoImages(map.get("1rc"), map.get("1rcRef")));
    assertEquals(true, checkTwoImages(map.get("2rc"), map.get("2rcRef")));

    try {
      model.rgbCombine("1rc", "1rs1", "1rs1", "1rs3");
      fail("Split failed");
    }
    catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: Image name already exists.",e.toString());
    }

    try {
      model.rgbCombine("1rc", "1rs1", "1rs2", "1rs31");
      fail("Brighten Flip failed");
    }
    catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",e.toString());
    }
  }
}