import controller.CustomSystemIn;
import controller.ImgControllerImplUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import model.ImageSetAdvanced;
import view.ViewUI;

/**
 * This class is used to call controller, and it creates a model and view advanced objects. This is
 * the function the user makes a call to.
 */
public class MainUI {

  /**
   * Calls the go method of the controller advanced.
   *
   * @param args takes the input from the terminal.
   */
  public static void main(String[] args) {
    CustomSystemIn in = new CustomSystemIn();
    ImageSetAdvanced model = new ImageSetAdvanced();
    ViewUI view = new ViewUI();
    ImgControllerImplUI controller = new ImgControllerImplUI(model, view,
        new BufferedReader(new InputStreamReader(in)));
    controller.run();
  }
}
