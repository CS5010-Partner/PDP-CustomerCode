package model;

import java.nio.file.NoSuchFileException;

public interface IFile {
  String fileRead() throws FileHandlingException;
  void fileWrite(String content);

}
