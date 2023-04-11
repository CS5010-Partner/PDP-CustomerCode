package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import model.IImageAdvanced;
import view.swing.MainWindow;

public class ImgControllerImplUI extends ImgControllerImplAdvanced {

  private final String defaultImageName = "tempImg";
  private int iter = 0;
  private MockSystemIn in = new MockSystemIn();
  private Map<String, String> formulateMap;
  private MainWindow view;
  private String[] currentImgs;



  /**
   * Constructor for the ImgControllerImplAdvanced class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    gives the object from where the input is read.
   */
  public ImgControllerImplUI(IImageAdvanced model, MainWindow view,
      BufferedReader in) {
    super(model, view, new BufferedReader(in));
    formulateMap = new HashMap<String, String>();
    this.view = view;
    currentImgs = new String[3];
//    super.commandExecution();
  }

  private void initView() {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        view.show();
      }
    });
    initActionListners();
  }

  private String generateNewImageName() {
    String newImgName = defaultImageName + String.valueOf(iter);
    iter += 1;
    return newImgName;
  }

  private void generateCommands() {
    formulateMap.put("load", "load ");
    formulateMap.put("save", "save ");
    formulateMap.put("bright", "brighten ");
    formulateMap.put("grey-red", "greyscale red ");
    formulateMap.put("grey-blue", "greyscale blue ");
    formulateMap.put("grey-green", "greyscale green ");
    formulateMap.put("grey-intensity", "greyscale intensity ");
    formulateMap.put("grey-luma", "greyscale luma ");
    formulateMap.put("grey-value", "greyscale value ");
    formulateMap.put("hflip", "horizontal-flip ");
    formulateMap.put("vflip", "vertical-flip ");
    formulateMap.put("combine", "rgb-combine ");
    formulateMap.put("split", "rgb-split ");

    formulateMap.put("grey", "greyscale ");
    formulateMap.put("sepia", "sepia ");
    formulateMap.put("blur", "blur ");
    formulateMap.put("sharpen", "sharpen ");
    formulateMap.put("dither", "dither ");

    formulateMap.put("hist", "histogram ");
  }

//  private BufferedImage convertImage(ImageObj img) {
//    int[][][] data=img.getMatrix();
//
//    BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
//    for (int x = 0; x < img.getHeight(); x++) {
//      for (int y = 0; y < img.getWidth(); y++) {
//        int r = data[x][y][0];
//        int g = data[x][y][1];
//        int b = data[x][y][2];
//        int rgb = (r << 16) | (g << 8) | b;
//        image.setRGB(y, x, rgb);
//      }
//    }
//    return image;
//  }

//  private void loadActionListner() {
//    for (Map.Entry<String, JButton> btnName : view.btnMap.entrySet()) {
//      view.btnMap.get(btnName).addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//          actionHelper(btnName);
//
//        }
//      });
//    }
//  }

  private void initActionListners() {
    view.btnMap.get("load").addActionListener(loadActionListner());
    view.btnMap.get("dither").addActionListener(ditherActionListner());
    view.btnMap.get("save").addActionListener(saveActionListner());

  }

  private ActionListener loadActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] filePaths = view.fileChooser(1);
//        System.out.println(filePaths[0]);
        String imgName = generateNewImageName();
        currentImgs[0] = imgName;
        String[] params = new String[] {filePaths[0], currentImgs[0]};
        actionHelper(params, "load");
      }
    };
    return a;
  }

  private ActionListener ditherActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String newImgName = generateNewImageName();
        String[] params = new String[] {currentImgs[0], newImgName};
        currentImgs[0] = newImgName;
        actionHelper(params, "dither");
      }
    };
    return a;
  }

  private ActionListener saveActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String newImgName = generateNewImageName();
        String[] params = new String[] {currentImgs[0], newImgName};
        currentImgs[0] = newImgName;
        actionHelper(params, "dither");
      }
    };
    return a;
  }


  public void actionHelper(String[] params, String command) {
    String cmd = formulateMap.get(command);

    if (command == "rgb-combine") {
      for (int i = 0; i < 4; i++) {
        cmd += params[i]; // 3 file paths
        cmd += " ";
      }
      cmd += generateNewImageName();
    } else if (command == "hist") {
      for (int i = 0; i < 5; i++) {
        cmd += params[i]; // 3 file paths
        cmd += " ";
      }
    }
      else if (command == "bright") {
      cmd += params[0]; // brighten param
      cmd += " ";
      cmd += params[1]; // current file path
      cmd += " ";
      cmd += generateNewImageName();
    } else if (command == "load") {
      cmd += params[0]; // load file path
      cmd += " ";
      cmd += params[1]; // current file path
    } else if (command == "save") {
      cmd += params[0]; // save file path
      cmd += " ";
      cmd += params[1]; // current file path
    } else if (command == "rgb-split") {
      cmd += params[0]; // source file path
      cmd += " ";
      cmd += generateNewImageName(); // red image name
      cmd += " ";
      cmd += generateNewImageName(); // green image name
      cmd += " ";
      cmd += generateNewImageName(); // blue image name
    } else {
      cmd += params[0]; // source file path
      cmd += " ";
      cmd += generateNewImageName();
    }
    cmd += "\n#\n";
    System.out.println("command : " + cmd);
    in.addInput(cmd);
    super.commandExecution();
  }

  @Override
  public void run() {
    initView();
    generateCommands();
    actionHelper(new String[]{"/Users/aditya/Programming/CS5010/PDP/Assignment4/res/img1orig.ppm", "i1"}, "load");
    actionHelper(new String[]{"i1", "r", "g", "h", "i"}, "hist");
//        actionHelper(new String[]{"/Users/aditya/Programming/CS5010/PDP/Assignment4/res/img1orig.ppm", "i1"}, "load");
//    actionHelper(new String[]{"i1", "i1d"}, "dither");

//    actionHelper(new String[]{"/Users/aditya/Programming/CS5010/PDP/Assignment4/res/img1orig.ppm", "i1"}, "load");
//    actionHelper(new String[]{"/Users/aditya/Programming/CS5010/PDP/Assignment4/res/img1orig.ppm", "i1"}, "load");
//    String cmd = "";
//    in.addInput(cmd);
  }
}

