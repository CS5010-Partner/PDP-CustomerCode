package view;

import java.io.Writer;

/**
 * Class used to test the new view part of the model using a mock buffered writer.
 */
public class MockBufferedWriterAdvanced extends MockBufferedWriter {

  /**
   * Constructor to initialize the variables.
   *
   * @param out Writer object as input.
   */
  public MockBufferedWriterAdvanced(Writer out) {
    super(out);
  }
}
