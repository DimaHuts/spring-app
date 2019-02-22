package notebook.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class LocationConverter {
  public static Path resolveFileStorageLocation(String path) {
    return Paths.get(path)
      .toAbsolutePath().normalize();
  }
}
