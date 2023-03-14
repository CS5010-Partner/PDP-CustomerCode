package controller.helper;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Helper class is used to act as a container for the common methods which are implemented in the
 * classes of the controller module.
 */
public abstract class Helper {

  protected String getInput(BufferedReader sc) throws CloseCmdLineException, IOException {
    StringBuffer input = new StringBuffer();

    while (true) {
      char ch = (char) sc.read();
      String c = String.valueOf(ch);
      if (input.length() == 0 && c.equals(" ")) {
        continue;
      }
      if (input.length() != 0) {
        if (c.equals(" ")) {
          break;
        }
        if (c.equals("\n")) {
          break;
        }
      }
      if (!c.equals("\n")) {
        input.append(c);
      }
    }

    if (input.toString().equals("#")) {
      throw new CloseCmdLineException("Quit command has been entered.");
    }
    return input.toString();
  }
}
