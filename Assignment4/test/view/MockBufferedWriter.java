package view;

import java.io.BufferedWriter;
import java.io.Writer;

public class MockBufferedWriter extends BufferedWriter {
  private String s;
  private String flush;
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
