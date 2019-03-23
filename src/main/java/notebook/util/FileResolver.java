package notebook.util;

import java.nio.file.Path;

public final class FileResolver {
  public static Path resolveFileForLocation(Path targetLocation, String normalizedFileName) {
    return targetLocation.resolve(normalizedFileName);
  }
}
