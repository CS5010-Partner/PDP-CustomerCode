import controller.CloseCmdLineException;
import controller.ImgControllerImpl;
import model.ImageSet;

public class Main {

  public static void main(String[] args) throws CloseCmdLineException {
    ImageSet model=new ImageSet();
    ImgControllerImpl controller=new ImgControllerImpl(model,System.in,System.out);
    controller.go();
  }
}