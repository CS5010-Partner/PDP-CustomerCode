package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Mock class to test the implementation of the custom SystemIn.
 */
public class MockSystemIn extends InputStream {

  private InputStream in;


  /**
   * Sets the input s to the System.in
   *
   * @param s the value to be set to the System.in
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