import controller.CustomSystemIn;
import controller.ImgControllerImplAdvanced;
import controller.ImgControllerImplScript;
import controller.ImgControllerImplUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import model.ImageSetAdvanced;
import view.IViewAdvanced;
import view.ViewAdvanced;
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
//    for (String i : args) {
//      System.out.println(i);
//    }

    ImageSetAdvanced model = new ImageSetAdvanced();

    if (args.length == 0) {
      CustomSystemIn in = new CustomSystemIn();
      ViewUI view = new ViewUI();
      ImgControllerImplUI controller = new ImgControllerImplUI(model, view,
          new BufferedReader(new InputStreamReader(in)));
      controller.run();
      return;
    }

    if (args[0].equals("-file") && args.length >= 2) {
      CustomSystemIn in = new CustomSystemIn();
      IViewAdvanced view = new ViewAdvanced(new BufferedWriter(new OutputStreamWriter(System.out)));
      ImgControllerImplScript controller = new ImgControllerImplScript(model, view,
          new BufferedReader(new InputStreamReader(in)), args);
      controller.run();
    }
    else if (args[0].equals("-text")) {
      IViewAdvanced view = new ViewAdvanced(new BufferedWriter(new OutputStreamWriter(System.out)));
      ImgControllerImplAdvanced controller = new ImgControllerImplAdvanced(model, view,
          new BufferedReader(new InputStreamReader(System.in)));
      controller.run();
      return;
    }
      System.out.println("Enter a valid command!");

  }
}
