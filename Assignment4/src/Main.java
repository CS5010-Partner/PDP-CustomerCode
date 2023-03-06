import controller.ImgControllerImpl;
import model.ImageSet;
import view.IView;
import view.View;

public class Main {

  public static void main(String[] args) throws IllegalAccessException {
    ImageSet model=new ImageSet();
    IView view=new View();
    ImgControllerImpl controller=new ImgControllerImpl(model, view, System.in,System.out);
    controller.go();
  }
}