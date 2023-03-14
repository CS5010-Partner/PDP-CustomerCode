package model;

import controller.helper.FileHandlingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * PPMFile represents the image file format which is in PPM.
 * It implements the IFIle interface to implement the file methods.
 */
public class PPMFile implements IFile{
  String filePath;

  /**
   * Constructor for the PPMFile class.
   * @param path the file path.
   */
  public PPMFile(String path) {
    filePath = path;
  }
  @Override
  public String fileRead() throws FileHandlingException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(this.filePath));
    }
    catch (FileNotFoundException e) {
      throw new FileHandlingException("File " + this.filePath + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s+System.lineSeparator());
      }
    }
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new FileHandlingException("Invalid PPM file: plain RAW file should begin with P3");
    }
    StringBuilder result=new StringBuilder();
    result.append("P3\n");

    int width = sc.nextInt();
    result.append(width+"\n");
    int height = sc.nextInt();
    result.append(height+"\n");
    int maxValue = sc.nextInt();
    result.append(maxValue+"\n");

    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        result.append(r+"\n"+g+"\n"+b+"\n");
      }
    }
    return result.toString();
  }

  @Override
  public void fileWrite(String content) {
    File file = new File(filePath);

    try (FileOutputStream fos = new FileOutputStream(file)) {
      if (!file.exists()) {
        file.createNewFile();
      }
      byte[] contentInBytes = content.getBytes();

      fos.write(contentInBytes);
      fos.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
