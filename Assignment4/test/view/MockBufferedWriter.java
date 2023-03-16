package view;

import java.io.BufferedWriter;
import java.io.Writer;

/**
 * Class used to test the view part of the model using a mock buffered writer.
 */
public class MockBufferedWriter extends BufferedWriter {

  private String s;
  private String flush;

  /**
   * Constructor to initialize the variables.
   *
   * @param out Writer object as input.
   */
  public MockBufferedWriter(Writer out) {
    super(out);
    s = "";
    flush = "";
  }

  public String checkBuffer() {
    return this.flush;
  }

  public void write(String inp) {
    this.s += inp;
  }

  public void flush() {
    this.flush = this.s;
    this.s = "";
  }

  public void newLine() {
    this.s += "\n";
  }
}
