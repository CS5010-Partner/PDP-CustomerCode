import controller.ImgControllerImplUI;
import controller.MockSystemIn;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import model.ImageSetAdvanced;
import view.swing.MainWindow;

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
    MockSystemIn in = new MockSystemIn();
    ImageSetAdvanced model = new ImageSetAdvanced();
//    IViewAdvanced view = new ViewUI(new BufferedWriter(new OutputStreamWriter(System.out)));
    MainWindow view = new MainWindow();
    ImgControllerImplUI controller = new ImgControllerImplUI(model, view,
        new BufferedReader(new InputStreamReader(in)));
    controller.run();
  }
}
