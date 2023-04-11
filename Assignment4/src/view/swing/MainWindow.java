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
import javax.swing.BoxLayout;
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
  private JPanel panel,histoPanel,topPanel, operationPanel;
  private JLabel imageLabel, histoLabel1,histoLabel2,histoLabel3,histoLabel4, currentOperation;
  private JScrollPane scrollPane;
  public HashMap<String, JButton> btnMap;
  private  JComboBox<String> dropdown;
  public MainWindow()
  {
    super(null);
//    super.toggleMasterVerbose();
    frame=new JFrame();
    panel=new JPanel();
    histoPanel=new JPanel();
    topPanel=new JPanel();
    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
    operationPanel=new JPanel();
    String[] options = {"Select", "Red", "Blue", "Green", "Luma", "Intensity", "Value"};
    dropdown = new JComboBox<>(options);

    imageLabel=new JLabel();


    frame.setMinimumSize(new Dimension(700, 500));
//    imageLabel.setSize(new Dimension(500,500));
    frame.setTitle("Image Transformations");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes when clicked on X
    frame.setSize(800,600);

    histoLabel1=new JLabel("label1");
    histoLabel2=new JLabel("label 2");
    histoLabel3=new JLabel("label 3");
    histoLabel4=new JLabel("label 4");

    currentOperation=new JLabel("Select an operation to show an image");

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
    imageLabel.setText(null);
    imageLabel.setHorizontalAlignment(JLabel.CENTER);
    imageLabel.setVerticalAlignment(JLabel.CENTER);
  }

  @Override
  public void echoLoadSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Loaded Successfully");
    showImage(img);
  }

  @Override
  public void echoDither(ImageObj img, boolean verbose) {
    showImage(img);
  }

  @Override
  public void echoFlipSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Flipped Successfully");
    showImage(img);
  }

  @Override
  public void echoSaveSuccess(ImageObj img, boolean verbose) {
    print("             Image Saved Successfully", true);
  }

  @Override
  public void echoHistogramSuccess(ImageObj[] imgs, boolean verbose) {
    System.out.println("in here");
    showImage(imgs[0]);
  }

  @Override
  public void echoBrightenSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Brightened Successfully");
    showImage(img);
  }
  @Override
  public void echoGreyscaleSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Greyscale Image Generated Successfully");
    showImage(img);
  }

  private void initButtons() {
    btnMap = new HashMap<>();
    btnMap.put("load", new JButton("Load"));
    btnMap.put("save",new JButton("save"));
    btnMap.put("histogram", new JButton("Histogram"));
//
    btnMap.put("hflip",new JButton("Horizontal Flip"));
    btnMap.put("vFlip",new JButton("Vertical Flip"));
    btnMap.put("bright",new JButton("Brighten"));
    btnMap.put("grey-normal",new JButton("grey-normal"));
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
    panel.setLayout(new GridLayout(10,1,2,1)); //divides the panel into rectangles
    panel.setBackground(Color.red);
    panel.add(btnMap.get("load"));
    panel.add(btnMap.get("save"));
    panel.add(btnMap.get("histogram"));
    panel.add(btnMap.get("bright"));


    panel.add(btnMap.get("grey-normal"));


//    panel.add(btnMap.get("grey"));
    panel.add(btnMap.get("vFlip"));
    panel.add(btnMap.get("hflip"));
//    panel.add(btnMap.get("split"));
//    panel.add(btnMap.get("combine"));
//    panel.add(btnMap.get("blur"));
//    panel.add(btnMap.get("sharp"));
//    panel.add(btnMap.get("sepia"));
    panel.add(btnMap.get("dither"));



    frame.add(panel, BorderLayout.WEST);
    frame.add(topPanel,BorderLayout.NORTH);

    topPanel.add(histoPanel);
    topPanel.add(operationPanel);

    operationPanel.add(currentOperation);

    histoPanel.add(histoLabel1);
    histoPanel.add(histoLabel2);
    histoPanel.add(histoLabel3);
    histoPanel.add(histoLabel4);


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
  public String popUpInput()
  {
    String input = JOptionPane.showInputDialog(frame, "Enter input:");
    if (input != null) {
      // User clicked OK and entered some input
      return input;
    } else {
      // User clicked Cancel or closed the dialog
      return "not clicked";
    }
  }

  public String greyChooser() {
    int result = JOptionPane.showConfirmDialog(null, dropdown, "Select"
        + " an option", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    String selectedOption = "";
    if (result == JOptionPane.OK_OPTION) {
      selectedOption = (String) dropdown.getSelectedItem();

    }
    return selectedOption;
  }
}
