package model;

import static org.junit.Assert.*;

import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import controller.file.IFile;
import controller.file.PPMFile;
import org.junit.Test;

public class ImageSetAdvancedTest {
  private ImageSetAdvanced model;
  private IFile img1;
  private IFile img2;
  private IFile img3;

  private HashMap<String, ImageObj> map;

  public ImageSetAdvancedTest() {
    model = new ImageSetAdvanced();
    img1 = new PPMFile("res/img1orig.ppm");
    img2 = new PPMFile("res/img2orig.ppm");
    img3 = new PPMFile("res/new1.ppm");
    map = new HashMap<String, ImageObj>();
  }

  private boolean checkTwoImages(ImageObj obj1, ImageObj obj2) {
    if (obj1.getHeight() != obj2.getHeight()
        || obj1.getWidth() != obj2.getWidth()) {
      return false;
    }

    return Arrays.deepEquals(obj1.getMatrix(), obj2.getMatrix());
  }

  @Test
  public void filteringTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img3, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1filter", model.filterBlur("1orig", "1filter"));
    map.put("2filter", model.filterBlur("2orig", "2filter"));

    IFile ref1 = new PPMFile("res/img1filter1.ppm");
    IFile ref2 = new PPMFile("res/img2filter1.ppm");

    ImageObj s1 = model.save(ref1, "1filter");
    ImageObj s2 = model.save(ref2, "2filter");

    map.put("1filterRef", model.load(ref1, "1filterRef"));
    map.put("2filterRef", model.load(ref2, "2filterRef"));

    assertEquals(true, checkTwoImages(map.get("1filterRef"), map.get("1filter")));
    assertEquals(true, checkTwoImages(map.get("2filterRef"), map.get("2filter")));

    try {
      model.filterBlur("1orig", "1filter");
      fail("filter red failed");
    } catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: "
              + "Image name already exists.",
          e.toString());
    }

    try {
      model.filterBlur("1orig1", "1filter");
      fail("greyscale red failed");
    } catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",
          e.toString());
    }
  }

  @Test
  public void sharpeningTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img3, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1sharp", model.filterSharpen("1orig", "1sharp"));
    map.put("2sharp", model.filterSharpen("2orig", "2sharp"));

    IFile ref1 = new PPMFile("res/img1sharp1.ppm");
    IFile ref2 = new PPMFile("res/img2sharp1.ppm");

    ImageObj s1 = model.save(ref1, "1sharp");
    ImageObj s2 = model.save(ref2, "2sharp");

    map.put("1sharpef", model.load(ref1, "1sharpRef"));
    map.put("2sharpRef", model.load(ref2, "2sharpRef"));

    assertEquals(true, checkTwoImages(map.get("1sharpRef"), map.get("1sharp")));
    assertEquals(true, checkTwoImages(map.get("2sharpRef"), map.get("2sharp")));

    try {
      model.filterSharpen("1orig", "1sharp");
      fail("sharp red failed");
    } catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: "
              + "Image name already exists.",
          e.toString());
    }

    try {
      model.filterSharpen("1orig1", "1sharp");
      fail("sharp red failed");
    } catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",
          e.toString());
    }
  }

  @Test
  public void greyScaleTransformTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img3, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1grey", model.transformGreyScale("1orig", "1grey"));
    map.put("2grey", model.transformGreyScale("2orig", "2grey"));

    IFile ref1 = new PPMFile("res/img1grey1.ppm");
    IFile ref2 = new PPMFile("res/img2grey1.ppm");

    ImageObj s1 = model.save(ref1, "1grey");
    ImageObj s2 = model.save(ref2, "2grey");

    map.put("1greyRef", model.load(ref1, "1greyRef"));
    map.put("2greyRef", model.load(ref2, "2greyRef"));

    assertEquals(true, checkTwoImages(map.get("1greyRef"), map.get("1grey")));
    assertEquals(true, checkTwoImages(map.get("2greyRef"), map.get("2grey")));

    try {
      model.transformGreyScale("1orig", "1grey");
      fail("grey transform failed");
    } catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: "
              + "Image name already exists.",
          e.toString());
    }

    try {
      model.transformGreyScale("1orig1", "1grey");
      fail("grey tranform failed");
    } catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",
          e.toString());
    }
  }

  @Test
  public void sepiaTransformTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img3, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1sepia", model.transformSepia("1orig", "1sepia"));
    map.put("2sepia", model.transformSepia("2orig", "2sepia"));

    IFile ref1 = new PPMFile("res/img1sepia1.ppm");
    IFile ref2 = new PPMFile("res/img2sepia1.ppm");

    ImageObj s1 = model.save(ref1, "1sepia");
    ImageObj s2 = model.save(ref2, "2sepia");

    map.put("1sepiaRef", model.load(ref1, "1sepiaRef"));
    map.put("2sepiaRef", model.load(ref2, "2sepiaRef"));

    assertEquals(true, checkTwoImages(map.get("1sepiaRef"), map.get("1sepia")));
    assertEquals(true, checkTwoImages(map.get("2sepiaRef"), map.get("2sepia")));

    try {
      model.transformSepia("1orig", "1sepia");
      fail("sepia transform failed");
    } catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: "
              + "Image name already exists.",
          e.toString());
    }

    try {
      model.transformSepia("1orig1", "1sepia");
      fail("sepia tranform failed");
    } catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",
          e.toString());
    }
  }

  @Test
  public void ditherTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img3, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1dither", model.dither("1orig", "1dither"));
    map.put("2dither", model.dither("2orig", "2dither"));

    IFile ref1 = new PPMFile("res/img1dither1.ppm");
    IFile ref2 = new PPMFile("res/img2dither1.ppm");

    ImageObj s1 = model.save(ref1, "1dither");
    ImageObj s2 = model.save(ref2, "2dither");

    map.put("1ditherRef", model.load(ref1, "1ditherRef"));
    map.put("2ditherRef", model.load(ref2, "2ditherRef"));

    assertEquals(true, checkTwoImages(map.get("1ditherRef"), map.get("1dither")));
    assertEquals(true, checkTwoImages(map.get("2ditherRef"), map.get("2dither")));

    try {
      model.dither("1orig", "1dither");
      fail("dither transform failed");
    } catch (ImageNameAlreadyExistsException e) {
      assertEquals("exceptions.ImageNameAlreadyExistsException: "
              + "Image name already exists.",
          e.toString());
    }

    try {
      model.dither("1orig1", "1dither");
      fail("dither tranform failed");
    } catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",
          e.toString());
    }
  }
}