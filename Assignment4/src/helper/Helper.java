package helper;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Helper {
  protected String getInput(BufferedReader sc) throws CloseCmdLineException, IOException {
    StringBuffer input = new StringBuffer();

    while (true) {
      String c = String.valueOf((char)sc.read());
      if (input.length() == 0 && c.equals(" ")) {
        continue;
      }
      if (input.length() !=0) {
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
