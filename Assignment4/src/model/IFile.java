package model;

import helper.FileHandlingException;

public interface IFile {
  String fileRead() throws FileHandlingException;
  void fileWrite(String content);

}
