package controller.file;

import exceptions.FileHandlingException;
import model.ImageObj;

/**
 * IFile represents the methods implemented by the classes which implement IFile interface.
 * This interface will help in future when there is a change in the format of the file.
 * For instance when there is a change from ppm to png format.
 */
public interface IFile {

  /**
   * Returns the read content from the given file.
   * @return the content of the file.
   * @throws FileHandlingException thrown when there is no such file exists.
   */
  String fileRead() throws FileHandlingException;

  /**
   * Writes the content into the specified file.
   * @param content the content to be written to the file.
   * @throws FileHandlingException thrown when there is no such directory exists.
   */
  void fileWrite(ImageObj content) throws FileHandlingException;

}
