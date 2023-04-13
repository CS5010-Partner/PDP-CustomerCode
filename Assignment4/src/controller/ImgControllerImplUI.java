package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import model.IImageAdvanced;
import view.ViewUI;

/**
 * ImgControllerImplUI acts as a controller for the UI implementation. It is extended from the
 * already created ImgControllerImplAdvanced.
 */
public class ImgControllerImplUI extends ImgControllerImplAdvanced {

  private final String defaultImageName = "tempImg";
  private int iter = 0;
  private CustomSystemIn in = new CustomSystemIn();
  private Map<String, String> formulateMap;
  private ViewUI view;
  private ArrayList<String> currentImgs;


  /**
   * Constructor for the ImgControllerImplAdvanced class.
   *
   * @param model represents the model object.
   * @param view  represents the view object.
   * @param in    gives the object from where the input is read.
   */
  public ImgControllerImplUI(IImageAdvanced model, ViewUI view, BufferedReader in) {
    super(model, view, new BufferedReader(in));
    formulateMap = new HashMap<String, String>();
    this.view = view;
    currentImgs = new ArrayList();
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
    formulateMap.put("grey-normal", "greyscale ");
    formulateMap.put("hFlip", "horizontal-flip ");
    formulateMap.put("vFlip", "vertical-flip ");
    formulateMap.put("combine", "rgb-combine ");
    formulateMap.put("split", "rgb-split ");
    formulateMap.put("grey", "greyscale ");
    formulateMap.put("sepia", "sepia ");
    formulateMap.put("blur", "blur ");
    formulateMap.put("sharpen", "sharpen ");
    formulateMap.put("dither", "dither ");
    formulateMap.put("hist", "histogram ");
  }

  private void initActionListners() {
    view.btnMap.get("load").addActionListener(loadActionListner());
    view.btnMap.get("dither").addActionListener(ditherActionListner());
    view.btnMap.get("save").addActionListener(saveActionListner());
    view.btnMap.get("bright").addActionListener(brightActionListner());
    view.btnMap.get("blur").addActionListener(blurActionListner());
    view.btnMap.get("sepia").addActionListener(sepiaActionListner());
    view.btnMap.get("sharpen").addActionListener(sharpenActionListner());
    view.btnMap.get("grey-normal").addActionListener(greyNormalActionListner());
    view.btnMap.get("hFlip").addActionListener(hflipActionListner());
    view.btnMap.get("vFlip").addActionListener(vflipActionListner());
    view.btnMap.get("split").addActionListener(splitActionListner());
    view.btnMap.get("combine").addActionListener(combineActionListner());
  }

  private ActionListener combineActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String newImgName;
        boolean isLoadMemory = view.combineChooser();
        if (!isLoadMemory) {
          String[] params;
          String[] filePaths = view.fileChooser(3);

          currentImgs.add(generateNewImageName());
          params = new String[]{filePaths[0], currentImgs.get(currentImgs.size() - 1)};
          actionHelper(params, "load");

          currentImgs.add(generateNewImageName());
          params = new String[]{filePaths[1], currentImgs.get(currentImgs.size() - 1)};
          actionHelper(params, "load");

          currentImgs.add(generateNewImageName());
          params = new String[]{filePaths[2], currentImgs.get(currentImgs.size() - 1)};
          actionHelper(params, "load");
        }
        newImgName = generateNewImageName();
        String[] params = new String[]{newImgName, currentImgs.get(currentImgs.size() - 3),
            currentImgs.get(currentImgs.size() - 2), currentImgs.get(currentImgs.size() - 1)};
        actionHelper(params, "combine");
        currentImgs.add(newImgName);
        histoGenerator();
      }
    };
    return a;
  }


  private ActionListener splitActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String source = currentImgs.get(currentImgs.size() - 1);
        boolean isSaveMemory = view.splitChooser();
        histoGenerator();

        String imgNameRed = generateNewImageName();
        currentImgs.add(imgNameRed);
        String imgNameGreen = generateNewImageName();
        currentImgs.add(imgNameGreen);
        String imgNameBlue = generateNewImageName();
        currentImgs.add(imgNameBlue);
        String[] params = new String[]{source, imgNameRed, imgNameGreen, imgNameBlue};
        actionHelper(params, "split");

        if (!isSaveMemory) {
          String savePath;
          savePath = view.savePath();
          params = new String[]{savePath, currentImgs.get(currentImgs.size() - 3)};
          actionHelper(params, "save");

          savePath = view.savePath();
          params = new String[]{savePath, currentImgs.get(currentImgs.size() - 2)};
          actionHelper(params, "save");

          savePath = view.savePath();
          params = new String[]{savePath, currentImgs.get(currentImgs.size() - 1)};
          actionHelper(params, "save");
        }
      }
    };
    return a;
  }

  private ActionListener sharpenActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String imgName = generateNewImageName();
        String[] params = new String[]{currentImgs.get(currentImgs.size() - 1), imgName};
        currentImgs.add(imgName);
        actionHelper(params, "sharpen");
        histoGenerator();
      }
    };
    return a;
  }

  private ActionListener greyNormalActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String imgName = generateNewImageName();
        String selectedOption = view.greyChooser();
        String type = null;
        switch (selectedOption) {
          case "Red":
            type = "red";
            break;
          case "Blue":
            type = "blue";
            break;
          case "Green":
            type = "green";
            break;
          case "Luma":
            type = "luma";
            break;
          case "Intensity":
            type = "intensity";
            break;
          case "Value":
            type = "value";
            break;
          case "Transformation":
            type = " ";
            break;
          default:
            break;
        }
        String[] params = new String[]{type, currentImgs.get(currentImgs.size() - 1), imgName};
        currentImgs.add(imgName);
        actionHelper(params, "grey-normal");
        histoGenerator();
      }
    };
    return a;
  }

  private ActionListener hflipActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String imgName = generateNewImageName();
        String[] params = new String[]{currentImgs.get(currentImgs.size() - 1), imgName};
        currentImgs.add(imgName);
        actionHelper(params, "hFlip");
        histoGenerator();
      }
    };
    return a;
  }

  private ActionListener vflipActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String imgName = generateNewImageName();
        String[] params = new String[]{currentImgs.get(currentImgs.size() - 1), imgName};
        currentImgs.add(imgName);
        actionHelper(params, "vFlip");
        histoGenerator();
      }
    };
    return a;
  }

  private ActionListener sepiaActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String imgName = generateNewImageName();
        String[] params = new String[]{currentImgs.get(currentImgs.size() - 1), imgName};
        currentImgs.add(imgName);
        actionHelper(params, "sepia");
        histoGenerator();
      }
    };
    return a;
  }

  private ActionListener loadActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] filePaths = view.fileChooser(1);
        if (filePaths[0] == null) {
          return;
        }
        String[] fileType = filePaths[0].split("\\.");
        if ((!fileType[1].equals("jpg")) && (!fileType[1].equals("png")) && (!fileType[1].equals(
            "bmp")) && (!fileType[1].equals("ppm"))) {
          view.changeImageType();
        } else {
          String imgName = generateNewImageName();
          currentImgs.add(imgName);
          String[] params = new String[]{filePaths[0], currentImgs.get(currentImgs.size() - 1)};
          actionHelper(params, "load");
          histoGenerator();
        }

      }
    };
    return a;
  }

  private void histoGenerator() {
    String[] params2 = new String[]{currentImgs.get(currentImgs.size() - 1), generateNewImageName(),
        generateNewImageName(), generateNewImageName(), generateNewImageName()};
    actionHelper(params2, "hist");
  }

  private ActionListener ditherActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String newImgName = generateNewImageName();
        String[] params = new String[]{currentImgs.get(currentImgs.size() - 1), newImgName};
        currentImgs.add(newImgName);
        actionHelper(params, "dither");
        histoGenerator();
      }
    };
    return a;
  }

  private ActionListener saveActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String savePath = view.savePath();
        String[] params = new String[]{savePath, currentImgs.get(currentImgs.size() - 1)};
        actionHelper(params, "save");
      }
    };
    return a;
  }

  private ActionListener blurActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String newImgName = generateNewImageName();
        String[] params = new String[]{currentImgs.get(currentImgs.size() - 1), newImgName};
        currentImgs.add(newImgName);
        actionHelper(params, "blur");
        histoGenerator();
      }
    };
    return a;
  }

  private ActionListener brightActionListner() {
    ActionListener a = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String imgName = generateNewImageName();
        String input = view.popUpInput();
        int increment = 0;
        if (!input.equals("not clicked")) {
          try {
            increment = Integer.parseInt(input);
          } catch (NumberFormatException exception) {
            view.setBrightException();
            return;
          }
        }
        String[] params = new String[]{String.valueOf(increment),
            currentImgs.get(currentImgs.size() - 1), imgName};
        currentImgs.add(imgName);
        actionHelper(params, "bright");
        histoGenerator();
      }
    };
    return a;
  }

  private void actionHelper(String[] params, String command) {
    String cmd = formulateMap.get(command);

    switch (command) {
      case "combine":
        for (int i = 0; i < 4; i++) {
          cmd += params[i]; // 3 file paths
          cmd += " ";
        }
        break;
      case "hist":
        for (int i = 0; i < 5; i++) {
          cmd += params[i]; // 3 file paths
          cmd += " ";
        }
        break;
      case "bright":
      case "grey-normal":
        cmd += params[0]; // brighten param
        cmd += " ";
        cmd += params[1]; // current file path
        cmd += " ";
        cmd += params[2];
        break;
      case "split":
        cmd += params[0]; // source file path
        cmd += " ";
        cmd += params[1]; // red image name
        cmd += " ";
        cmd += params[2]; // green image name
        cmd += " ";
        cmd += params[3]; // blue image name
        break;
      default:
        cmd += params[0]; // source file path
        cmd += " ";
        cmd += params[1];
        break;
    }
    cmd += "\n#\n";
    in.addInput(cmd);
    super.commandExecution();
  }

  @Override
  public void run() {
    initView();
    generateCommands();
  }
}

