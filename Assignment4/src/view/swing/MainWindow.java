package view.swing;

import static java.awt.Component.CENTER_ALIGNMENT;

import controller.file.BMPFile;
import controller.file.IFile;
import controller.file.JPEGFile;
import controller.file.PNGFile;
import controller.file.PPMFile;
import exceptions.FileHandlingException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import model.ImageObj;
import view.ViewAdvanced;

public class MainWindow extends ViewAdvanced {
  private ImageObj img;
  private JFrame frame;
  private JPanel panel,panel1;
  private JLabel imageLabel;
  private JScrollPane scrollPane;
  public HashMap<String, JButton> btnMap;
  public MainWindow()
  {
    super(null);
//    super.toggleMasterVerbose();
    frame=new JFrame();
    panel=new JPanel();
    panel1=new JPanel();
    imageLabel=new JLabel("Select an option to display an image");
    imageLabel.setAlignmentX(CENTER_ALIGNMENT);
    imageLabel.setSize(new Dimension(500,500));
    frame.setTitle("Image Transformations");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes when clicked on X
    frame.setSize(800,600);
    initButtons();
  }

  @Override
  protected void print(String msg, boolean verboseOveride) {
      if (getVerbose() || verboseOveride) {
        imageLabel=new JLabel(msg);
      }
  }

  private void showImage(ImageObj img) {
    BufferedImage image = imageCovnerter(img);
    scrollPaneHelper();
    ImageIcon icon = new ImageIcon(image);
    imageLabel.setText(null);
    imageLabel.setIcon(icon);
    Dimension imageSize = new Dimension(image.getWidth(null), image.getHeight(null));
    imageLabel.setPreferredSize(imageSize);
  }

  @Override
  public void echoLoadSuccess(ImageObj img, boolean verbose) {
    showImage(img);
  }

  @Override
  public void echoDither(ImageObj img, boolean verbose) {
    showImage(img);
  }

  @Override
  public void echoSaveSuccess(ImageObj img, boolean verbose) {
    print("             Image Saved Successfully", true);
  }

  private void initButtons() {
    btnMap = new HashMap<>();
    btnMap.put("load", new JButton("Load"));
    btnMap.put("save",new JButton("save"));
//
//    btnMap.put("hFlip",new JButton("Horizontal Flip"));
//    btnMap.put("vFlip",new JButton("Vertical Flip"));
//    btnMap.put("bright",new JButton("Brighten"));
//
//    btnMap.put("grey",new JButton("GreyScale"));
//    btnMap.put("split",new JButton("RGB Split"));
//    btnMap.put("combine",new JButton("RGB Combine"));
//
//    btnMap.put("blur",new JButton("Blur"));
//    btnMap.put("sepia",new JButton("Sepia"));
//    btnMap.put("sharp",new JButton("Sharpen"));
    btnMap.put("dither",new JButton("Dither"));
//
//    String[] greyScaleOptions = {"Default","Red", "Blue","Green", "Luma","Intensity","Value"};
//    JComboBox<String> dropdown = new JComboBox<>(greyScaleOptions);
  }
  public void show()
  {
    frame.setVisible(true);
    panel.setLayout(new GridLayout(6,5,10,10)); //divides the panel into rectangles
    panel.setBackground(Color.red);
    panel.add(btnMap.get("load"));
    panel.add(btnMap.get("save"));
//    panel.add(btnMap.get("bright"));
//    panel.add(btnMap.get("grey"));
//    panel.add(btnMap.get("vFlip"));
//    panel.add(btnMap.get("hFlip"));
//    panel.add(btnMap.get("split"));
//    panel.add(btnMap.get("combine"));
//    panel.add(btnMap.get("blur"));
//    panel.add(btnMap.get("sharp"));
//    panel.add(btnMap.get("sepia"));
    panel.add(btnMap.get("dither"));
    frame.add(panel, BorderLayout.WEST);
    frame.add(imageLabel);
  }

  private void initActionListner() {
    for (Map.Entry<String,JButton> btnName : btnMap.entrySet()) {
      btnMap.get(btnName).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
      });
    }
  }

//  private JButton horizontalFlipHelper(){
//    horizontalFlip.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        if(img!=null)
//        {
//          img=img.horizontalFlip();
//          functionsHelper1();
//        }
//      }
//    });
//    return horizontalFlip;
//  }

//  private JButton verticalFlipHelper(){
//    JButton verticalFlip = new JButton("Vertical Flip");
//    verticalFlip.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        if(img!=null)
//        {
//          img=img.verticalFlip();
//          functionsHelper1();
//        }
//      }
//    });
//    return verticalFlip;
//  }

//  private void functionsHelper1()
//  {
//    int[][][] data=img.getMatrix();
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
//   scrollPaneHelper();
//// create an ImageIcon from the BufferedImage to display in the JLabel
//    ImageIcon icon = new ImageIcon(image);
//    imageLabel.setText(null);
//    imageLabel.setIcon(icon);
//    Dimension imageSize = new Dimension(image.getWidth(null), image.getHeight(null));
//    imageLabel.setPreferredSize(imageSize);
//  }
  private void scrollPaneHelper()
  {
    // Remove the old scroll pane from the frame
    if (scrollPane != null) {
      frame.remove(scrollPane);
    }

    // Create a new scroll pane with the updated label
    scrollPane = new JScrollPane(imageLabel);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    frame.add(scrollPane, BorderLayout.CENTER);

    // Repaint the frame to show the updated contents
    frame.revalidate();
    frame.repaint();
  }


  private BufferedImage imageCovnerter(ImageObj img) {
      int[][][] data=img.getMatrix();
      BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
      for (int x = 0; x < img.getHeight(); x++) {
        for (int y = 0; y < img.getWidth(); y++) {
          int r = data[x][y][0];
          int g = data[x][y][1];
          int b = data[x][y][2];
          int rgb = (r << 16) | (g << 8) | b;
          image.setRGB(y, x, rgb);
        }
      }
      return image;
  }




  public String[] fileChooser(int count) {
    String[] filePaths = new String[count];
    for (int i = 0; i < count; i++) {
      JFileChooser fileChooser = new JFileChooser();
      int returnValue = fileChooser.showOpenDialog(null);
      if (returnValue == JFileChooser.APPROVE_OPTION) {
        String fileName = fileChooser.getSelectedFile().getAbsolutePath();
        filePaths[i] = fileName;
      }
      else {
        imageLabel.setIcon(null);
        imageLabel.setText("Cannot read the file");
      }
    }
    return filePaths;
  }

  private JButton loadHelper()
  {
    JButton label=new JButton("Load");
    label.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          String fileName = selectedFile.getPath();
          String[] params = {fileName, fileName};

          try {
            String[] fileType=(selectedFile.getPath()).split("\\.");

            if(fileType[1].equals("jpg")||fileType[1].equals("png")||fileType[1].equals("ppm")||fileType[1].equals("bmp")) {
              // Read the image file and display it on the JLabel
              System.out.println(selectedFile.getPath());
              BufferedImage image = ImageIO.read(selectedFile);

              imageLabel.setText(null);
              imageLabel.setIcon(new ImageIcon(image));

              Dimension imageSize = new Dimension(image.getWidth(null), image.getHeight(null));
              imageLabel.setPreferredSize(imageSize);


              switch (fileType[1]){
                case "jpg":
                  img = readHelper(new JPEGFile(selectedFile.getPath()));
                  break;
                case "ppm":
                  img = readHelper(new PPMFile(selectedFile.getPath()));
                  break;
                case "png":
                  img = readHelper(new PNGFile(selectedFile.getPath()));
                  break;
                case "bmp":
                  img = readHelper(new BMPFile(selectedFile.getPath()));
                  break;
              }
              scrollPaneHelper();
            }
            else
            {
              imageLabel.setIcon(null);
              imageLabel.setText("Cannot read the file");
            }
          } catch (IOException ex) {
            ex.printStackTrace();
          } catch (FileHandlingException ex) {
            imageLabel.setText("Can not read the specified file");
          }
        }
      }});
    return label;
  }

  private ImageObj readHelper(IFile obj) throws FileHandlingException {
    String content = obj.fileRead();
    String[] token = content.split("\n");
    int width = Integer.parseInt(token[0]);
    int height = Integer.parseInt(token[1]);
    int maxValue = Integer.parseInt(token[2]);

    int t = 3;
    int[][][] image = new int[height][width][3];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < 3; k++) {
          image[i][j][k] = Integer.parseInt(token[t]);
          t++;
        }
      }
    }
    return new ImageObj(image, width, height, maxValue);
  }

  private JButton brightenHelper()
  {
    JButton button = new JButton("Brighten");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(frame, "Enter input:");
        if (input != null) {
          // User clicked OK and entered some input
          img=img.brighten(Integer.parseInt(input));
//          functionsHelper1();
          scrollPaneHelper();
        } else {
          // User clicked Cancel or closed the dialog
          System.out.println("User cancelled input dialog.");
        }
      }
    });
    return button;
  }

  private JButton basicFuntions() {
    JButton button = new JButton("Basic Functions");
    String[] options = {"Select", ""};
    JComboBox<String> dropdown = new JComboBox<>(options);
    return button;
  }
  private JButton checkBox()
  {
    JButton button = new JButton("Gray");
    String[] options = {"Select","Red", "Blue","Green", "Luma","Intensity","Value"};
    JComboBox<String> dropdown = new JComboBox<>(options);

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, dropdown, "Select"
            + " an option", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
          String selectedOption = (String) dropdown.getSelectedItem();
          System.out.println("Selected option: " + selectedOption);
          switch (selectedOption)
          {
            case "Red":
              img=img.greyScaleRed();
              break;
            case "Blue":
              img=img.greyScaleBlue();
              break;
            case "Green":
              img=img.greyScaleGreen();
              break;
            case "LUMA":
              img=img.greyScaleLUMA();
              break;
            case "Intensity":
              img=img.greyScaleIntensity();
              break;
            case "Value":
              img=img.greyScaleValue();
              break;
          }
//          functionsHelper1();
          scrollPaneHelper();
        }
      }
    });
    return button;
  }

}
