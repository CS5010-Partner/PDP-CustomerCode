import controller.ImgControllerImplAdvanced;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import model.ImageSetAdvanced;
import view.IViewAdvanced;
import view.ViewAdvanced;

public class MainAdvanced {
  /**
   * Calls the go method of the controller.
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
