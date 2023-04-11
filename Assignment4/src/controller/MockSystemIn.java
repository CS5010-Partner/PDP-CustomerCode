package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MockSystemIn extends InputStream {

  private String input;
  private InputStream in;

  public MockSystemIn() {
    input = "\n";
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
  }

  public void addInput(String s) {
    in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);

  }

  @Override
  public int read() throws IOException {
    return System.in.read();
  }
}