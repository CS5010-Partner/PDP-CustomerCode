package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MockSystemIn extends InputStream {

  private String input;
  private InputStream in;

//  public MockSystemIn() {
//    input = "";
//    in = new ByteArrayInputStream(input.getBytes());
//    System.setIn(in);
//  }
//  public static void main(String[] args) throws IOException {
//    // Now you can read from System.in as if it were user input
//    int c;
//    while ((c = System.in.read()) != -1) {
//      System.out.print((char) c);
//    }
//  }

  public void addInput(String s) {
//    input = s;
    in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);

  }

  @Override
  public int read() throws IOException {
//    int c;
//    while ((c = System.in.read()) != -1) {
//      System.out.print((char) c);
//    }
    return System.in.read();
//    if (input.length()!=0) {
//      System.out.println(input.charAt(0));
//      byte b = (byte) input.charAt(0);
//      input = input.substring(1, input.length());
//      return b;
//    }
//    System.out.println("end reached");
//    return -1;
//  }
  }
}