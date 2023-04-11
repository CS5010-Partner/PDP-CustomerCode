import controller.ImgControllerImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import model.ImageSet;
import view.IView;
import view.View;

/**
 * This class is used to call controller, and it creates a model and view objects. This is the
 * function the user makes a call to.
 */
public class Main {

  /**
   * Calls the go method of the controller.
   *
   * @param args takes the input from the terminal.
   */
  public static void main(String[] args) {
    ImageSet model = new ImageSet();
    IView view = new View(new BufferedWriter(new OutputStreamWriter(System.out)));
    ImgControllerImpl controller = new ImgControllerImpl(model, view,
        new BufferedReader(new InputStreamReader(System.in)));
    controller.run();
  }
}