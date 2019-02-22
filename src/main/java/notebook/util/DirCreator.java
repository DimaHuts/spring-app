package notebook.util;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class DirCreator {
  public static void create(Path dir) {
    try {
      Files.createDirectories(dir);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
