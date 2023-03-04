package model;

public interface IFile {
  String fileRead(String filePath);
  void fileWrite(String filePath, String content);

}
