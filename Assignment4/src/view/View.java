package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class View implements IView{
  public void print(String msg, boolean verboseOveride) {
    if (this.verbose || verboseOveride)
      System.out.println(msg);
  }

  public void echoGetCommand()
}
