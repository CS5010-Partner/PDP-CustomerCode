import controller.helper.CloseCmdLineException;
import controller.ImgController;
import controller.ImgControllerImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import model.ImageSet;
import view.IView;
import view.View;

public class Main {

  public static void main(String[] args) {
    ImageSet model=new ImageSet();
    IView view=new View();
    ImgController controller=new ImgControllerImpl(model, view, new BufferedReader(new InputStreamReader(System.in)),new BufferedWriter(new OutputStreamWriter(System.out)));
    controller.go();
  }
}