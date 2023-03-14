package view;

import helper.FileHandlingException;
import java.io.IOException;

public interface IView {

  void echoGetCommand(boolean b);

  void toggleVerbose();

  void echoCloseCmd(boolean b);

  void echoIoError(String e, boolean b);

  void echoWrongCmdError(String e, boolean b);

  void echoFileHandlingError(String e, boolean b);

  void echoImageNameAlreadyExistsError(String e, boolean b);
  
  void echoLoadSuccess(boolean b);

  void echoSaveSuccess(boolean b);

  void echoGreyscaleSuccess(boolean b);

  void echoBrightenSuccess(boolean b);

  void echoFlipSuccess(boolean b);

  void echoCombineSuccess(boolean b);

  void echoSplitSuccess(boolean b);

  void echoScriptSuccess(boolean b);

  void echoInvalidInputMsg(boolean b);
}
