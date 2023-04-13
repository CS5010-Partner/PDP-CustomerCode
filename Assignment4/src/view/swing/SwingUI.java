package view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.HashMap;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.ImageObj;
import view.ViewAdvanced;

public class SwingUI extends ViewAdvanced {
  private JFrame frame;
  private JPanel panel,histoPanel,topPanel, operationPanel;
  private JLabel imageLabel, currentOperation,histoLabel1,histoLabel2,histoLabel;
  private JLabel  histoLabel3,histoLabel4;
  private JScrollPane scrollPane;
  public HashMap<String, JButton> btnMap;
  private  JComboBox<String> greyChooserDropdown;
  private  JComboBox<String> splitChooserDropdown;
  private  JComboBox<String> combineChooserDropdown;

  private String[] splitChooserOptions;
  private String[] combineChooserOptions;


  public SwingUI()
  {
    super(null);
    frame=new JFrame();
    panel=new JPanel();
    histoPanel=new JPanel();
    topPanel=new JPanel();
    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
    operationPanel=new JPanel();

    String[] greyChooserOptions = {"Select","Transformation", "Red", "Blue", "Green", "Luma", "Intensity", "Value"};
    greyChooserDropdown = new JComboBox<>(greyChooserOptions);

    splitChooserOptions = new String[]{"Store in memory", "Save to disk"};
    splitChooserDropdown = new JComboBox<>(splitChooserOptions);

    combineChooserOptions = new String[]{"Load from memory", "Load from disk"};
    combineChooserDropdown = new JComboBox<>(combineChooserOptions);


    imageLabel=new JLabel();

    frame.setMinimumSize(new Dimension(1200, 800));
    frame.setTitle("Image Transformations");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes when clicked on X
    frame.setSize(1200,800);
    String welcomeText = "<html><div style='text-align: center; font-size: 20px; font-weight: bold; " +
        "font-family: Arial, sans-serif;'>Welcome to my Application!</div></html>";

    histoLabel=new JLabel(welcomeText);
    histoLabel1=new ImageLabel(null,"RED HISTOGRAM");
    histoLabel2=new ImageLabel(null,"GREEN HISTOGRAM");
    histoLabel3=new ImageLabel(null,"BLUE HISTOGRAM");
    histoLabel4=new ImageLabel(null,"INTENSITY HISTOGRAM");

    histoLabel.setVerticalAlignment(SwingConstants.CENTER);
    histoLabel.setHorizontalAlignment(SwingConstants.CENTER);
    histoLabel1.setVisible(false);

    histoLabel2.setVisible(false);
    histoLabel3.setVisible(false);
    histoLabel4.setVisible(false);
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
    BufferedImage image = imageConverter(img);
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
    btnMap.get("save").setVisible(true);
    btnMap.get("bright").setVisible(true);
    btnMap.get("grey-normal").setVisible(true);
    btnMap.get("vFlip").setVisible(true);
    btnMap.get("hFlip").setVisible(true);
    btnMap.get("split").setVisible(true);
    btnMap.get("combine").setVisible(true);
    btnMap.get("blur").setVisible(true);
    btnMap.get("sharpen").setVisible(true);
    btnMap.get("sepia").setVisible(true);
    btnMap.get("dither").setVisible(true);
    histoLabel.setVisible(false);
    histoLabel1.setVisible(true);
    histoLabel2.setVisible(true);
    histoLabel3.setVisible(true);
    histoLabel4.setVisible(true);
  }

  @Override
  public void echoDither(ImageObj img, boolean verbose) {
    currentOperation.setText("Dithered the Image Successfully");
    showImage(img);
  }

  @Override
  public void echoFlipSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Flipped Successfully");
    showImage(img);
  }

  @Override
  public void echoSaveSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Saved Successfully");
  }

  @Override
  public void echoBrightenSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Brightened Successfully");
    showImage(img);
  }

  @Override
  public void echoHistogramSuccess(ImageObj[] imgs, boolean verbose) {
    showHistogram(imgs);
  }

  @Override
  public void echoFilterBlurSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Blurred Successfully");
    showImage(img);
  }

  @Override
  public void echoSepiaSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Sepia Successful.");
    showImage(img);
  }

  @Override
  public void echoFilterSharpenSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Sharpening Successful.");
    showImage(img);
  }

  @Override
  public void echoGreyscaleSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Greyscale Image Generated Successfully");
    showImage(img);
  }

  @Override
  public void echoCombineSuccess(ImageObj img, boolean verbose) {
    currentOperation.setText("Combined the last three images Successfully");
    showImage(img);
  }

  @Override
  public void echoSplitSuccess(ImageObj[] imgs, boolean verbose) {
    currentOperation.setText("RGB Split Done Successfully");
    showImage(imgs[0]);
  }

  private void initButtons() {
    btnMap = new HashMap<>();
    btnMap.put("load", new JButton("LOAD"));
    btnMap.put("save",new JButton("SAVE"));

    btnMap.put("hFlip",new JButton("HORIZONTAL FLIP"));
    btnMap.put("vFlip",new JButton("VERTICAL FLIP"));
    btnMap.put("bright",new JButton("BRIGHTEN"));
    btnMap.put("grey-normal",new JButton("GRAY"));
    btnMap.put("split",new JButton("RGB SPLIT"));
    btnMap.put("combine",new JButton("RGB COMBINE"));
    btnMap.put("blur",new JButton("BLUR"));
    btnMap.put("sepia",new JButton("SEPIA"));
    btnMap.put("sharpen",new JButton("SHARPEN"));
    btnMap.put("dither",new JButton("DITHER"));
  }
  public void show()
  {
    frame.setVisible(true);
    panel.setLayout(new GridLayout(13,1,1,1)); //divides the panel into rectangles
    panel.setBackground(Color.red);
    panel.add(btnMap.get("load"));
    panel.add(btnMap.get("save"));
    panel.add(btnMap.get("bright"));
    panel.add(btnMap.get("grey-normal"));
    panel.add(btnMap.get("bright"));
    panel.add(btnMap.get("grey-normal"));
    panel.add(btnMap.get("vFlip"));
    panel.add(btnMap.get("hFlip"));
   panel.add(btnMap.get("split"));
   panel.add(btnMap.get("combine"));
    panel.add(btnMap.get("blur"));
    panel.add(btnMap.get("sharpen"));
    panel.add(btnMap.get("sepia"));
    panel.add(btnMap.get("dither"));

    btnMap.get("save").setVisible(false);
    btnMap.get("bright").setVisible(false);
    btnMap.get("grey-normal").setVisible(false);
    btnMap.get("vFlip").setVisible(false);
    btnMap.get("hFlip").setVisible(false);
    btnMap.get("split").setVisible(false);
    btnMap.get("combine").setVisible(false);
    btnMap.get("blur").setVisible(false);
    btnMap.get("sharpen").setVisible(false);
    btnMap.get("sepia").setVisible(false);
    btnMap.get("dither").setVisible(false);



    frame.add(panel, BorderLayout.WEST);
    frame.add(topPanel,BorderLayout.NORTH);

    topPanel.add(histoPanel);
    topPanel.add(operationPanel);

    operationPanel.add(currentOperation);

    histoPanel.add(histoLabel);
    histoPanel.add(histoLabel1);
    histoPanel.add(histoLabel2);
    histoPanel.add(histoLabel3);
    histoPanel.add(histoLabel4);
    histoPanel.setPreferredSize(new Dimension(1200,300));

    frame.add(imageLabel);
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


  private BufferedImage imageConverter(ImageObj img) {
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
    imageLabel.setText(null);
    String[] filePaths = new String[count];
    for (int i = 0; i < count; i++) {
      JFileChooser fileChooser = new JFileChooser();
      int returnValue = fileChooser.showOpenDialog(null);
      if (returnValue == JFileChooser.APPROVE_OPTION) {
        String fileName = fileChooser.getSelectedFile().getAbsolutePath();
        filePaths[i] = fileName;
      }
    }
    return filePaths;
  }
  public void changeImageType()
  {
    if(imageLabel!=null)
      frame.remove(imageLabel);
    imageLabel=new JLabel();
    imageLabel.setText("Cannot read the file");
    frame.add(imageLabel);

    // Repaint the frame to show the updated contents
    frame.revalidate();
    frame.repaint();
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
    int result = JOptionPane.showConfirmDialog(null, greyChooserDropdown, "Select"
        + " an option", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    String selectedOption = "";
    if (result == JOptionPane.OK_OPTION) {
      selectedOption = (String) greyChooserDropdown.getSelectedItem();
    }
    return selectedOption;
  }

  public boolean splitChooser() {
    int result = JOptionPane.showConfirmDialog(null, splitChooserDropdown, "Select"
        + " an option", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    String selectedOption = "";
    if (result == JOptionPane.OK_OPTION) {
      selectedOption = (String) splitChooserDropdown.getSelectedItem();
    }
    if (selectedOption == splitChooserOptions[0])
      return true;
    return false;
  }

  public boolean combineChooser() {
    int result = JOptionPane.showConfirmDialog(null, combineChooserDropdown, "Select"
        + " an option", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    String selectedOption = "";
    if (result == JOptionPane.OK_OPTION) {
      selectedOption = (String) splitChooserDropdown.getSelectedItem();
    }
    if (selectedOption == combineChooserOptions[0])
      return true;
    return false;
  }


  public String savePath(){
    return JOptionPane.showInputDialog(frame,
        "Enter path where the current image has to be saved:");
  }
  private void showHistogram(ImageObj[] img) {
    BufferedImage image = imageConverter(img[0]);
    ImageIcon icon1 = new ImageIcon(image);
    histoLabel1.setText(null);
    histoLabel1.setIcon(icon1);

    image = imageConverter(img[1]);
    ImageIcon icon2 = new ImageIcon(image);
    histoLabel2.setText(null);
    histoLabel2.setIcon(icon2);

    image = imageConverter(img[2]);
    ImageIcon icon3 = new ImageIcon(image);
    histoLabel3.setText(null);
    histoLabel3.setIcon(icon3);

    image = imageConverter(img[3]);
    ImageIcon icon4 = new ImageIcon(image);
    histoLabel4.setText(null);
    histoLabel4.setIcon(icon4);

    histoLabel1.setBorder(new EmptyBorder(10,0,10,0));
    histoLabel2.setBorder(new EmptyBorder(10,0,10,0));
    histoLabel3.setBorder(new EmptyBorder(10,0,10,0));
    histoLabel4.setBorder(new EmptyBorder(10,0,10,0));

  }

  public class ImageLabel extends JLabel {
    private String text;

    public ImageLabel(ImageIcon icon, String text) {
      super(icon);
      this.text = text;
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawString(text, 0+2, getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
      Dimension size = super.getPreferredSize();
      size.width = Math.max(size.width, getFontMetrics(getFont()).stringWidth(text));
      size.height += getFontMetrics(getFont()).getHeight();
      return size;
    }
  }
}
