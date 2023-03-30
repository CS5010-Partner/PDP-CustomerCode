import controller.ImgControllerImplAdvanced;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import model.ImageSetAdvanced;
import view.IViewAdvanced;
import view.ViewAdvanced;

/**
 * This class is used to call controller, and it creates a model and view advanced objects. This is
 * the function the user makes a call to.
 */
public class MainAdvanced {

  /**
   * Calls the go method of the controller advanced.
   *
   * @param args takes the input from the terminal.
   */
  public static void main(String[] args) {
    ImageSetAdvanced model = new ImageSetAdvanced();
    IViewAdvanced view = new ViewAdvanced(new BufferedWriter(new OutputStreamWriter(System.out)));
    ImgControllerImplAdvanced controller = new ImgControllerImplAdvanced(model, view,
        new BufferedReader(new InputStreamReader(System.in)));
    controller.run();
  }
}
