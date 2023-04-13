package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class is used as a Custom SystemIn to parse the commands to the System.in.
 */
public class CustomSystemIn extends InputStream {

  private String input;
  private InputStream in;

  /**
   * Constructor to initialize the data members of this class.
   */
  public CustomSystemIn() {
    input = "\n";
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
  }

  /**
   * Sets the parameter string s to the system.in.
   *
   * @param s string to be considered as system.in input.
   */
  public void addInput(String s) {
    in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);

  }

  @Override
  public int read() throws IOException {
    return System.in.read();
  }
}