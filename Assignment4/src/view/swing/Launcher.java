package view.swing;

import controller.ImgControllerImplUI;
import javax.swing.SwingUtilities;

public class Launcher {
  public static void main(ImgControllerImplUI controller) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        MainWindow main=new MainWindow();
        main.show();
      }
    });
  }
}
