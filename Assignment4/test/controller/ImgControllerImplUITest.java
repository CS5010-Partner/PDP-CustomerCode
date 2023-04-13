package controller;

import static org.junit.Assert.*;

import model.IImageAdvanced;
import org.junit.Before;
import view.IViewAdvanced;

public class ImgControllerImplUITest {
  private IImageAdvanced model;
  private IViewAdvanced view;
  private ImgController controller;

  @Before
  public void setUp() {
    this.model = new MockModelAdvanced();
    this.view = new MockViewAdvanced();
  }
}