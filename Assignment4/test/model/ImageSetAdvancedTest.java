package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import controller.file.IFile;
import controller.file.JPEGFile;
import controller.file.PPMFile;
import exceptions.FileHandlingException;
import exceptions.ImageNameAlreadyExistsException;
import exceptions.ImageNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.Test;

/**
 * Class to test the Model part of the new MVC.
 */
public class ImageSetAdvancedTest {

  private ImageSetAdvanced model;
  private IFile img1;
  private IFile img2;

  private HashMap<String, ImageObj> map;

  /**
   * Constructor to initialize the variables.
   */
  public ImageSetAdvancedTest() {
    model = new ImageSetAdvanced();
    img1 = new PPMFile("res/img1orig.ppm");
    img2 = new PPMFile("res/img2orig.ppm");
    IFile img3 = new PPMFile("res/new1.ppm");
    map = new HashMap<String, ImageObj>();
  }

  private boolean checkTwoImages(ImageObj obj1, ImageObj obj2) {
    if (obj1.getHeight() != obj2.getHeight() || obj1.getWidth() != obj2.getWidth()) {
      return false;
    }

    return Arrays.deepEquals(obj1.getMatrix(), obj2.getMatrix());
  }

  @Test
  public void filteringTest()
      throws ImageNameAlreadyExistsException, FileHandlingException, ImageNotFoundException {
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1filter", model.filterBlur("1orig", "1filter"));
    map.put("2filter", model.filterBlur("2orig", "2filter"));

    IFile ref1 = new PPMFile("res/img1filterRef.ppm");
    IFile ref2 = new PPMFile("res/img2filterRef.ppm");

    IFile ref1jpg = new JPEGFile("res/img1filterRef.jpg");
    IFile ref2jpg = new JPEGFile("res/img2filterRef.jpg");

    IFile ref1png = new JPEGFile("res/img1filterRef.png");
    IFile ref2png = new JPEGFile("res/img2filterRef.png");

    IFile ref1bmp = new JPEGFile("res/img1filterRef.bmp");
    IFile ref2bmp = new JPEGFile("res/img2filterRef.bmp");

    ImageObj s1 = model.save(ref1, "1filter");
    ImageObj s2 = model.save(ref2, "2filter");

    map.put("1filterRef", model.load(ref1, "1filterRef"));
    map.put("2filterRef", model.load(ref2, "2filterRef"));

    map.put("1filterRefJpg", model.load(ref1jpg, "1filterRefJpg"));
    map.put("2filterRefJpg", model.load(ref2jpg, "2filterRefJpg"));

    map.put("1filterRefPng", model.load(ref1png, "1filterRefPng"));
    map.put("2filterRefPng", model.load(ref2png, "2filterRefPng"));

    map.put("1filterRefBmp", model.load(ref1bmp, "1filterRefBmp"));
    map.put("2filterRefBmp", model.load(ref2bmp, "2filterRefBmp"));

    assertEquals(true, checkTwoImages(map.get("1filterRef"), map.get("1filter")));
    assertEquals(true, checkTwoImages(map.get("2filterRef"), map.get("2filter")));

    assertEquals(true, checkTwoImages(map.get("1filterRef"), map.get("1filter")));
    assertEquals(true, checkTwoImages(map.get("2filterRef"), map.get("2filter")));

    assertEquals(true, checkTwoImages(map.get("1filterRef"), map.get("1filter")));
    assertEquals(true, checkTwoImages(map.get("2filterRef"), map.get("2filter")));

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
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1sharp", model.filterSharpen("1orig", "1sharp"));
    map.put("2sharp", model.filterSharpen("2orig", "2sharp"));

    IFile ref1 = new PPMFile("res/img1sharpRef.ppm");
    IFile ref2 = new PPMFile("res/img2sharpRef.ppm");

    IFile ref1jpg = new JPEGFile("res/img1sharpRef.jpg");
    IFile ref2jpg = new JPEGFile("res/img2sharpRef.jpg");

    IFile ref1png = new JPEGFile("res/img1sharpRef.png");
    IFile ref2png = new JPEGFile("res/img2sharpRef.png");

    IFile ref1bmp = new JPEGFile("res/img1sharpRef.bmp");
    IFile ref2bmp = new JPEGFile("res/img2sharpRef.bmp");

    ImageObj s1 = model.save(ref1, "1sharp");
    ImageObj s2 = model.save(ref2, "2sharp");

    map.put("1sharpRef", model.load(ref1, "1sharpRef"));
    map.put("2sharpRef", model.load(ref2, "2sharpRef"));

    map.put("1sharpRefJpg", model.load(ref1jpg, "1sharpRefJpg"));
    map.put("2sharpRefJpg", model.load(ref2jpg, "2sharpRefJpg"));

    map.put("1sharpRefPng", model.load(ref1png, "1sharpRefPng"));
    map.put("2sharpRefPng", model.load(ref2png, "2sharpRefPng"));

    map.put("1sharpRefBmp", model.load(ref1bmp, "1sharpRefBmp"));
    map.put("2sharpRefBmp", model.load(ref2bmp, "2sharpRefBmp"));

    assertEquals(true, checkTwoImages(map.get("1sharpRef"), map.get("1sharp")));
    assertEquals(true, checkTwoImages(map.get("2sharpRef"), map.get("2sharp")));

    assertEquals(true, checkTwoImages(map.get("1sharpRef"), map.get("1sharp")));
    assertEquals(true, checkTwoImages(map.get("2sharpRef"), map.get("2sharp")));

    assertEquals(true, checkTwoImages(map.get("1sharpRef"), map.get("1sharp")));
    assertEquals(true, checkTwoImages(map.get("2sharpRef"), map.get("2sharp")));

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
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1grey", model.transformGreyScale("1orig", "1grey"));
    map.put("2grey", model.transformGreyScale("2orig", "2grey"));

    IFile ref1 = new PPMFile("res/img1greyRef.ppm");
    IFile ref2 = new PPMFile("res/img2greyRef.ppm");

    IFile ref1jpg = new JPEGFile("res/img1greyRef.jpg");
    IFile ref2jpg = new JPEGFile("res/img2greyRef.jpg");

    IFile ref1png = new JPEGFile("res/img1greyRef.png");
    IFile ref2png = new JPEGFile("res/img2greyRef.png");

    IFile ref1bmp = new JPEGFile("res/img1greyRef.bmp");
    IFile ref2bmp = new JPEGFile("res/img2greyRef.bmp");

    ImageObj s1 = model.save(ref1, "1grey");
    ImageObj s2 = model.save(ref2, "2grey");

    map.put("1greyRef", model.load(ref1, "1greyRef"));
    map.put("2greyRef", model.load(ref2, "2greyRef"));

    map.put("1greyRefJpg", model.load(ref1jpg, "1greyRefJpg"));
    map.put("2greyRefJpg", model.load(ref2jpg, "2greyRefJpg"));

    map.put("1greyRefPng", model.load(ref1png, "1greyRefPng"));
    map.put("2greyRefPng", model.load(ref2png, "2greyRefPng"));

    map.put("1greyRefBmp", model.load(ref1bmp, "1greyRefBmp"));
    map.put("2greyRefBmp", model.load(ref2bmp, "2greyRefBmp"));

    assertEquals(true, checkTwoImages(map.get("1greyRef"), map.get("1grey")));
    assertEquals(true, checkTwoImages(map.get("2greyRef"), map.get("2grey")));

    assertEquals(true, checkTwoImages(map.get("1greyRef"), map.get("1grey")));
    assertEquals(true, checkTwoImages(map.get("2greyRef"), map.get("2grey")));

    assertEquals(true, checkTwoImages(map.get("1greyRef"), map.get("1grey")));
    assertEquals(true, checkTwoImages(map.get("2greyRef"), map.get("2grey")));

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
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1sepia", model.transformSepia("1orig", "1sepia"));
    map.put("2sepia", model.transformSepia("2orig", "2sepia"));

    IFile ref1 = new PPMFile("res/img1sepiaRef.ppm");
    IFile ref2 = new PPMFile("res/img2sepiaRef.ppm");

    IFile ref1jpg = new JPEGFile("res/img1sepiaRef.jpg");
    IFile ref2jpg = new JPEGFile("res/img2sepiaRef.jpg");

    IFile ref1png = new JPEGFile("res/img1sepiaRef.png");
    IFile ref2png = new JPEGFile("res/img2sepiaRef.png");

    IFile ref1bmp = new JPEGFile("res/img1sepiaRef.bmp");
    IFile ref2bmp = new JPEGFile("res/img2sepiaRef.bmp");

    ImageObj s1 = model.save(ref1, "1sepia");
    ImageObj s2 = model.save(ref2, "2sepia");

    map.put("1sepiaRef", model.load(ref1, "1sepiaRef"));
    map.put("2sepiaRef", model.load(ref2, "2sepiaRef"));

    map.put("1sepiaRefJpg", model.load(ref1jpg, "1sepiaRefJpg"));
    map.put("2sepiaRefJpg", model.load(ref2jpg, "2sepiaRefJpg"));

    map.put("1sepiaRefPng", model.load(ref1png, "1sepiaRefPng"));
    map.put("2sepiaRefPng", model.load(ref2png, "2sepiaRefPng"));

    map.put("1sepiaRefBmp", model.load(ref1bmp, "1sepiaRefBmp"));
    map.put("2sepiaRefBmp", model.load(ref2bmp, "2sepiaRefBmp"));

    assertEquals(true, checkTwoImages(map.get("1sepiaRef"), map.get("1sepia")));
    assertEquals(true, checkTwoImages(map.get("2sepiaRef"), map.get("2sepia")));

    assertEquals(true, checkTwoImages(map.get("1sepiaRef"), map.get("1sepia")));
    assertEquals(true, checkTwoImages(map.get("2sepiaRef"), map.get("2sepia")));

    assertEquals(true, checkTwoImages(map.get("1sepiaRef"), map.get("1sepia")));
    assertEquals(true, checkTwoImages(map.get("2sepiaRef"), map.get("2sepia")));

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
    map.put("1orig", model.load(img1, "1orig"));
    map.put("2orig", model.load(img2, "2orig"));

    map.put("1dither", model.dither("1orig", "1dither"));
    map.put("2dither", model.dither("2orig", "2dither"));

    IFile ref1 = new PPMFile("res/img1ditherRef.ppm");
    IFile ref2 = new PPMFile("res/img2ditherRef.ppm");

    IFile ref1jpg = new JPEGFile("res/img1ditherRef.jpg");
    IFile ref2jpg = new JPEGFile("res/img2ditherRef.jpg");

    IFile ref1png = new JPEGFile("res/img1ditherRef.png");
    IFile ref2png = new JPEGFile("res/img2ditherRef.png");

    IFile ref1bmp = new JPEGFile("res/img1ditherRef.bmp");
    IFile ref2bmp = new JPEGFile("res/img2ditherRef.bmp");

    ImageObj s1 = model.save(ref1, "1dither");
    ImageObj s2 = model.save(ref2, "2dither");

    map.put("1ditherRef", model.load(ref1, "1ditherRef"));
    map.put("2ditherRef", model.load(ref2, "2ditherRef"));

    map.put("1ditherRefJpg", model.load(ref1jpg, "1ditherRefJpg"));
    map.put("2ditherRefJpg", model.load(ref2jpg, "2ditherRefJpg"));

    map.put("1ditherRefPng", model.load(ref1png, "1ditherRefPng"));
    map.put("2ditherRefPng", model.load(ref2png, "2ditherRefPng"));

    map.put("1ditherRefBmp", model.load(ref1bmp, "1ditherRefBmp"));
    map.put("2ditherRefBmp", model.load(ref2bmp, "2ditherRefBmp"));

    assertEquals(true, checkTwoImages(map.get("1ditherRef"), map.get("1dither")));
    assertEquals(true, checkTwoImages(map.get("2ditherRef"), map.get("2dither")));

    assertEquals(true, checkTwoImages(map.get("1ditherRef"), map.get("1dither")));
    assertEquals(true, checkTwoImages(map.get("2ditherRef"), map.get("2dither")));

    assertEquals(true, checkTwoImages(map.get("1ditherRef"), map.get("1dither")));
    assertEquals(true, checkTwoImages(map.get("2ditherRef"), map.get("2dither")));

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
      fail("dither transform failed");
    } catch (ImageNotFoundException e) {
      assertEquals("exceptions.ImageNotFoundException: The image name does not exist.",
          e.toString());
    }
  }
}