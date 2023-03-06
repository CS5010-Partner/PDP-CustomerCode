package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PPMFile implements IFile{
  String filePath;

  public PPMFile(String path) {
    filePath = path;
  }
  public PPMFile()
  {

  }
  @Override
  public String fileRead() {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(this.filePath));
    }
    catch (FileNotFoundException e) {
      System.out.println("File "+this.filePath+ " not found!");
      return null;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s+System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
      return null;
    }
    StringBuilder result=new StringBuilder();
    result.append("P3\n");
    int width = sc.nextInt();
    result.append(width+"\n");
    
//    result.append("Width of image: "+width+"\n");
    int height = sc.nextInt();
    result.append(height+"\n");
//    result.append("Height of image: "+height+"\n");
    int maxValue = sc.nextInt();
    result.append(maxValue+"\n");
//    result.append("Max Value: "+maxValue+"\n");

    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        result.append(r+"\n"+g+"\n"+b+"\n");
//        result.append("("+j+","+i+"): ("+ r+","+g+","+b+")\n");
      }
    }
    return result.toString();
//    return image;
  }

  @Override
  public void fileWrite(String content) {
    File file = new File(filePath);

    try (FileOutputStream fos = new FileOutputStream(file)) {

      // if file doesn't exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      // get the content in bytes

      byte[] contentInBytes = content.getBytes();

      fos.write(contentInBytes);
      fos.flush();
      fos.close();

      System.out.println("Done");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

//  public static void main(String[] args) {
//    PPMFile obj=new PPMFile();
//    String content=(obj.fileRead("/Users/srinidhisunkara/Desktop/pdp/projects/Assignment4/PDP/Assignment4/code/Koala.ppm"));
//    obj.fileWrite("/Users/srinidhisunkara/Desktop/pdp/projects/Assignment4/PDP/Assignment4/code/KoalaNew.ppm",content);
//  }
}
